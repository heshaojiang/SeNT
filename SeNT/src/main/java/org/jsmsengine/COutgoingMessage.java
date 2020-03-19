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

import java.util.BitSet;
import java.util.Date;
import java.util.LinkedList;

/**
	This class represents an outgoing SMS message, i.e. message created for dispatch
	from the GSM device.

	@see	CMessage
	@see	CIncomingMessage
	@see	CPhoneBook
	@see	CService#sendMessage(COutgoingMessage)
	@see	CService#sendMessage(LinkedList)
*/
public class COutgoingMessage extends CMessage
{
	private Date dispatchDate;
	
	//超长短信分割后，每条都要加的内容（默认为空）
	private String headerInformation = "";

	/**
		Default constructor of the class.
	*/
	public COutgoingMessage()
	{
		super(TYPE_OUTGOING, null, null, null, null, -1);
		setDispatchDate(null);
		setDate(new Date());
	}

	/**
		Constructor of the class.

		@param	recipient	the recipients's number.
		@param	text	the actual text of the message.

		<br><br>Notes:<br>
		<ul>
			<li>Phone numbers are represented in their international or national format.</li>
			<li>If you use a phonebook, the phone number may be a string starting with the '~' character,
					representing an entry in the phonebook.</li>
			<li>By default, a created message is set to be encoded in 7bit. If you want to change that, be sure
					to operate in PDU mode, and change the encoding with setMessageEncoding() method.</li>
		</ul>
	*/
	public COutgoingMessage(String recipient, String text)
	{
		super(TYPE_OUTGOING, new Date(), null, recipient, text, -1);
		setDispatchDate(null);
		setDate(new Date());
	}

	/**
		Set the phone number of the recipient. Applicable to outgoing messages.

		@param	recipient	the recipient's phone number (international format).
	*/
	public void setRecipient(String recipient) { this.recipient = recipient; }

	/**
		Returns the recipient's phone number (international format). 
		Applicable only for outgoing messages.
		<br>
		<strong>This may be an entry from the phonebook.</strong>

		@return  the type of the message.
	*/
	public String getRecipient() { return recipient; }

	/**
		Sets the dispatch date of the message.

		@param	date	the dispatch date of the message.
	*/
	protected void setDispatchDate(Date date) { this.dispatchDate = date; }

	/**
		Returns the dispatch date of the message.

		@return  the dispatch date of the message.
	*/
	public Date getDispatchDate() { return dispatchDate; }

	protected String getPDU(String smscNumber)
	{
		String pdu;
		String str1, str2, str3;
		int i, high, low;
		char c;

		pdu = "";
		if ((smscNumber != null) && (smscNumber.length() != 0))
		{
			str1 = "91" + toBCDFormat(smscNumber.substring(1));
			str2 = Integer.toHexString(str1.length() / 2);
			if (str2.length() != 2) {
				str2 = "0" + str2;
			}
			pdu = pdu + str2 + str1;
		}
		else if ((smscNumber != null) && (smscNumber.length() == 0)) {
			pdu = pdu + "00";
		}
		pdu = pdu + "11";
		pdu = pdu + "00";
		str1 = getRecipient();
		if( str1.charAt(0) == '+' )
		{
			str1 = toBCDFormat(str1.substring(1));
			str2 = Integer.toHexString(getRecipient().length() - 1);
			str1 = "91" + str1;
		}
		else
		{
			str1 = toBCDFormat(str1);
			str2 = Integer.toHexString(getRecipient().length());
			str1 = "81" + str1;
		}
		if (str2.length() != 2) {
			str2 = "0" + str2;
		}

		pdu = pdu + str2 + str1;
		pdu = pdu + "00";
		switch (getMessageEncoding())
		{
			case MESSAGE_ENCODING_7BIT:
				pdu = pdu + "00";
				break;
			case MESSAGE_ENCODING_8BIT:
				pdu = pdu + "04";
				break;
			case MESSAGE_ENCODING_UNICODE:
				pdu = pdu + "08";
				break;
		}
		pdu = pdu + "AA";
		switch (getMessageEncoding())
		{
			case MESSAGE_ENCODING_7BIT:
				str1 = Integer.toHexString(getText().length());
				if (str1.length() != 2) {
					str1 = "0" + str1;
				}
				str2 = textToPDU(getText());
				pdu = pdu + str1 + str2;
				break;
			case MESSAGE_ENCODING_8BIT:
				str1 = getText();
				str2 = "";
				for (i = 0; i < str1.length(); i ++)
				{
					c = str1.charAt(i);
					str2 = str2 + ((Integer.toHexString((int) c).length() < 2) ? "0" + Integer.toHexString((int) c) : Integer.toHexString((int) c));  
				}
				str1 = Integer.toHexString(getText().length());
				if (str1.length() != 2) {
					str1 = "0" + str1;
				}
				pdu = pdu + str1 + str2;
				break;
			case MESSAGE_ENCODING_UNICODE:
				str1 = getText();
				str2 = "";
				for (i = 0; i < str1.length(); i ++)
				{
					c = str1.charAt(i);
					high = (int) (c / 256);
					low = c % 256;
					str2 = str2 + ((Integer.toHexString(high).length() < 2) ? "0" + Integer.toHexString(high) : Integer.toHexString(high));
					str2 = str2 + ((Integer.toHexString(low).length() < 2) ? "0" + Integer.toHexString(low) : Integer.toHexString(low));
				}
				str1 = Integer.toHexString(getText().length() * 2);
				if (str1.length() != 2) {
					str1 = "0" + str1;
				}
				pdu = pdu + str1 + str2;
				break;
		}
		return pdu.toUpperCase();
	}

	private String textToPDU(String text)
	{
		String pdu, str1;
		byte[] oldBytes, newBytes;
		BitSet bitSet;
		int i, j, k, value1, value2;

		str1 = "";		
		text = CGSMAlphabets.text2Hex(text, CGSMAlphabets.GSM7BITDEFAULT);
		for (i = 0; i < text.length(); i += 2)
		{
			j = (Integer.parseInt("" + text.charAt(i), 16) * 16) + Integer.parseInt("" + text.charAt(i + 1), 16);
			str1 += (char) j;
		}
		text = str1; 
		oldBytes = text.getBytes();
		bitSet = new BitSet(text.length() * 8);

		value1 = 0;
		for (i = 0; i < text.length(); i ++) {
			for (j = 0; j < 7; j ++)
			{
				value1 = (i * 7) + j;
				if ((oldBytes[i] & (1 << j)) != 0) {
					bitSet.set(value1);
				}
			}
		}
		value1 ++;

		if (((value1 / 56) * 56) != value1) {
			value2 = (value1 / 8) + 1;
		} else {
			value2 = (value1 / 8);
		}
		if (value2 == 0) {
			value2 = 1;
		}

		newBytes = new byte[value2];
		for (i = 0; i < value2; i ++) {
			for (j = 0; j < 8; j ++)
				if ((value1 + 1) > ((i * 8) + j))
					if (bitSet.get(i * 8 + j)) {
						newBytes[i] |= (byte) (1 << j);
					}
		}

		pdu = "";
		for (i = 0; i < value2; i ++)
		{
			str1 = Integer.toHexString((int) newBytes[i]);
			if (str1.length() != 2) {
				str1 = "0" + str1;
			}
			str1 = str1.substring(str1.length() - 2, str1.length());
			pdu += str1;
		}
		return pdu;
	}

	private String toBCDFormat(String s)
	{
		String bcd;
		int i;

		if ((s.length() % 2) != 0) {
			s = s + "F";
		}
		bcd = "";
		for (i = 0; i < s.length(); i += 2) {
			bcd = bcd + s.charAt(i + 1) + s.charAt(i);
		}
		return bcd; 
	}

	public String getHeaderInformation() {
		return headerInformation;
	}

	public void setHeaderInformation(String headerInformation) {
		this.headerInformation = headerInformation;
	}
}
