//
//	jSMSEngine API.
//	An open-source API package for sending and receiving SMS via a GSM device.
//	Copyright (C) 2002-2005, Thanasis Delenikas, Athens/GREECE
//		Web Site: http://www.jsmsengine.org
//
//	jSMSEngine is a package which can be used in order to add SMS processing
//		capabilities in an application. jSMSEngine is written in Java. It allows you
//		to communicate with a compatible mobile phone or GSM Modem, and
//		send / receive SMS messages.
//
//	jSMSEngine is distributed under the LGPL license.
//
//	This library is free software; you can redistribute it and/or
//		modify it under the terms of the GNU Lesser General Public
//		License as published by the Free Software Foundation; either
//		version 2.1 of the License, or (at your option) any later version.
//	This library is distributed in the hope that it will be useful,
//		but WITHOUT ANY WARRANTY; without even the implied warranty of
//		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//		Lesser General Public License for more details.
//	You should have received a copy of the GNU Lesser General Public
//		License along with this library; if not, write to the Free Software
//		Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//

package org.jsmsengine;

import java.io.File;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
	This class handles the operation of the phonebook.
	<br><br>
	The phone book is an XML file, which holds information about destinations.
	The phone book is created and maintained by you. When you use a phone book, it
	is possible to send messages to "nicknames" define in the book, instead of real
	phone numbers. Apart from nicknames, you can also create groups of nicknames,
	in order to send an SMS message to more than one destinations, with only one
	API call.
	<br><br>
	<strong>Note: the phone book is optional.</strong>
	<br><br>
	In the "misc" directory of the distribution tree, you will find a sample phone
	book file. A phone book contains:
	<ol>
		<li>	<strong>&lt;phonebookentry&gt;</strong> entries, which define the association
				of a person with a mobile number. For each entry, you must define the code
				(i.e. nickname), the name (description) and the actual phone.
		<li>	<strong>&lt;group&gt;</strong> entries. These entries group together one or more
				phone book entries. This way, you can define a group as the recipient
				of your SMS message, and your message will be send to all individual
				members of the group.
	</ol>
	<br>
	When you create a message and you want to use a phonebook nickname (for example
	"thanasis"), use it with a "~" symbol in front. This means, set the recipient to value
	"~thanasis". When jSMSEngine sees a recipient value starting with "~", it will know
	that you mean a nickname, and not the actual phone. However, please keep in mind that
	the "~" character does not appear in the phonebook XML definition file.
	<br><br>	
	This class contains all the relevant function for loading the XML phonebook file in memory
	(linked lists), and for resolving the names to the respected numbers.
	<br><br>
	All functions of the class are used internally by jSMSEngine API and are not accecible
	to the user.
	<br><br>
	Comments left to be added in next release.

	@see	CService#setPhoneBook
	@see	CService#sendMessage
	@see	COutgoingMessage
*/
class CPhoneBook
{
	private static final char PHONE_BOOK_INDICATOR = '~';

	private static final int ENTRY_TYPE_NOTFOUND = 0;
	private static final int ENTRY_TYPE_ENTRY = 1;
	private static final int ENTRY_TYPE_GROUP = 2;

	private LinkedList entries;
	private LinkedList groups;

	public CPhoneBook()
	{
		this.entries = new LinkedList();
		this.groups = new LinkedList();
	}

	protected boolean load(String file)
	{
		SAXParserFactory factory;
		SAXParser parser;
		boolean loaded;

		if (file == null)
		{
			entries = new LinkedList();
			groups = new LinkedList();
			loaded = true;
		}
		else
		{
			loaded = true;
			factory = SAXParserFactory.newInstance();
			try
			{
				parser = factory.newSAXParser();
				parser.parse(new File(file), new CParser());
			}
			catch (Exception e) { loaded = false; }
		}
		return loaded;
	}

	protected boolean isLoaded() { return (entries.size() > 0 ? true : false); }

	protected LinkedList expandPhoneBookEntries(COutgoingMessage message)
	{
		LinkedList messageList;
		String entry;
		COutgoingMessage newMessage;

		if (message.getRecipient().charAt(0) == PHONE_BOOK_INDICATOR)
		{
			entry = message.getRecipient().substring(1);
			switch (getEntryType(entry))
			{
				case CPhoneBook.ENTRY_TYPE_ENTRY:
					message.setRecipient(getEntryPhone(entry));
					messageList = new LinkedList();
					messageList.add(message);
					break;
				case CPhoneBook.ENTRY_TYPE_GROUP:
					LinkedList members;
					ListIterator iterator;

					try
					{
						messageList = new LinkedList();
						members = getGroupMembers(entry);
						iterator = members.listIterator(0);
						while (iterator.hasNext())
						{
							newMessage = new COutgoingMessage(getEntryPhone((String) iterator.next()), message.getText());
							newMessage.setMessageEncoding(message.getMessageEncoding()); 
							messageList.add(newMessage);
						}
					}
					catch (Exception e) { messageList = null; }
					break;
				default:
					messageList = null;
					break;
			}
		}
		else
		{
			messageList = new LinkedList();
			messageList.add(message);
		}
		return messageList;
	}

	protected LinkedList expandPhoneBookEntries(LinkedList inList)
	{
		COutgoingMessage message;
		LinkedList outList, tmpList;

		outList = new LinkedList();
		for (int i = 0; i < inList.size(); i ++)
		{
			message = (COutgoingMessage) inList.get(i);
			tmpList = expandPhoneBookEntries(message);
			if (tmpList != null) for (int j = 0; j < tmpList.size(); j ++) outList.add((COutgoingMessage) tmpList.get(j));
			else return null;
		}
		return outList;
	}

	private int getEntryType(String code)
	{
		if (getEntryName(code) != null) return ENTRY_TYPE_ENTRY;
		else if (getGroupName(code) != null) return ENTRY_TYPE_GROUP;
		else return ENTRY_TYPE_NOTFOUND;
	}

	private String getEntryName(String code)
	{
		CPhoneBookEntry entry = getEntry(code);
		return (entry == null ? null : entry.getName());
	}

	private String getEntryPhone(String code)
	{
		CPhoneBookEntry entry = getEntry(code);
		return (entry == null ? null : entry.getPhone());
	}

	private String getGroupName(String code)
	{
		CPhoneBookGroupEntry entry = getGroupEntry(code);
		return (entry == null ? null : entry.getName());
	}

	private LinkedList getGroupMembers(String code)
	{
		return getGroupEntry(code).getMembers();
	}

	private CPhoneBookEntry getEntry(String code)
	{
		CPhoneBookEntry entry;

		for (int i = 0; i < entries.size(); i ++)
		{
			entry = (CPhoneBookEntry) entries.get(i);
			if (entry.getCode().equalsIgnoreCase(code)) return entry;
		}
		return null;
	}

	private CPhoneBookGroupEntry getGroupEntry(String code)
	{
		CPhoneBookGroupEntry entry;

		for (int i = 0; i < groups.size(); i ++)
		{
			entry = (CPhoneBookGroupEntry) groups.get(i);
			if (entry.getCode().equalsIgnoreCase(code)) return entry;
		}
		return null;
	}

	class CPhoneBookEntry
	{
		private String code, name, phone;

		private CPhoneBookEntry()
		{
			code = null;
			name = null;
			phone = null;
		}

		private CPhoneBookEntry(String code, String name, String phone)
		{
			this.code = code;
			this.name = name;
			this.phone = phone;
		}

		private String getCode() { return code; }
		private String getName() { return name; }
		private String getPhone() { return phone; }
	}

	class CPhoneBookGroupEntry
	{
		private String code, name;
		private LinkedList members;

		private CPhoneBookGroupEntry()
		{
			code = null;
			name = null;
			members = new LinkedList();
		}

		private CPhoneBookGroupEntry(String code, String name)
		{
			this.code = code;
			this.name = name;
			members = new LinkedList();
		}

		private void add(String code) { members.addLast(code); }

		private String getCode() { return code; }
		private String getName() { return name; }
		private LinkedList getMembers() { return members; }
	}

	class CParser extends DefaultHandler
	{
		private static final int WHAT_BOOK = 1;
		private static final int WHAT_ENTRY = 2;
		private static final int WHAT_GROUP = 3;
		private int what = 0;
		private String element = "";
		private String entryCode, entryName, entryPhone;
		private String groupCode, groupName;
		private CPhoneBookGroupEntry group;

		public void startDocument () throws SAXException
		{
		}

		public void endDocument () throws SAXException
		{
		}

		public void startElement (String uri, String lName, String qName, Attributes attrs) throws SAXException
		{
			element = null;
			if (qName.equalsIgnoreCase("phonebook")) what = WHAT_BOOK;
			else if (qName.equalsIgnoreCase("phonebookentry")) what = WHAT_ENTRY;
			else if (qName.equalsIgnoreCase("group")) what = WHAT_GROUP;
			else element = qName;
		}

		public void endElement (String uri, String lName, String qName) throws SAXException
		{
			if (qName.equalsIgnoreCase("phonebookentry")) entries.addLast(new CPhoneBookEntry(entryCode, entryName, entryPhone));
			else if (qName.equalsIgnoreCase("group")) groups.addLast(group);
		}

		public void characters (char buf [], int offset, int len) throws SAXException
		{
			if (new String(buf, offset, len).trim().length() == 0) return;
			switch (what)
			{
				case WHAT_ENTRY:
					if (element.equalsIgnoreCase("code")) entryCode = new String(buf, offset, len).trim();
					else if (element.equalsIgnoreCase("name")) entryName = new String(buf, offset, len).trim();
					else if (element.equalsIgnoreCase("phone")) entryPhone = new String(buf, offset, len).trim();
					else if (element != null) throw(new SAXException("Unknown entry: " + element + "."));
					break;
				case WHAT_GROUP:
					if (element.equalsIgnoreCase("code")) groupCode = new String(buf, offset, len).trim();
					else if (element.equalsIgnoreCase("name"))
					{
						groupName = new String(buf, offset, len).trim();
						group = new CPhoneBookGroupEntry(groupCode, groupName);
					}
					else if (element.equalsIgnoreCase("member")) group.add(new String(buf, offset, len).trim());
					break;
			}
		}
	}
}
