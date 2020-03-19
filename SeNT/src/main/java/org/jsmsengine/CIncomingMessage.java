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
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
	This class represents an incoming SMS message, i.e. message read from the GSM device.

	@see	CMessage
	@see	COutgoingMessage
	@see	CService#readMessages(LinkedList, int)
*/
public class CIncomingMessage extends CMessage
{
	public static final int CLASS_ALL = 0;	
	public static final int CLASS_REC_UNREAD = 1;
	public static final int CLASS_REC_READ = 2;
	public static final int CLASS_STO_UNSENT = 3;
	public static final int CLASS_STO_SENT = 4;

	/**
		Default constructor of the class.

		@param	 date	the creation date of the message.
		@param	 originator	the originator's number.
		@param	 text	the actual text of the message.
		@param	 memIndex	the index of the memory location in the GSM device where this message is stored.

		<br><br>Notes:<br>
		<ul>
			<li>Phone numbers are represented in their international format (e.g. +306974... for Greece).</li>
		</ul>
	*/
	public CIncomingMessage(Date date, String originator, String text, int memIndex)
	{
		super(TYPE_INCOMING, date, originator, null, text, memIndex);
	}

	protected CIncomingMessage(String pdu, int memIndex)
	{
		super(TYPE_INCOMING, null, null, null, null, memIndex);

		Date date;
		String originator, text;
		String str1, str2;
		int index, i, j, k, protocol, addr, year, month, day, hour, min, sec;

		str1 = pdu.substring(0, 2);
		i = Integer.parseInt(str1, 16);
		index = (i + 1) * 2;
		index += 2;

		str1 = pdu.substring(index, index + 2);
		i = Integer.parseInt(str1, 16);
		j = index + 4;
		originator = "";
		for (k = 0; k < i; k += 2) originator = originator + pdu.charAt(j + k + 1) + pdu.charAt(j + k);
		originator = "+" + originator;
		if (originator.charAt(originator.length() - 1) == 'F') originator = originator.substring(0, originator.length() - 1);

		// Type of Address
		addr = Integer.parseInt(pdu.substring(j - 2, j), 16);
		if ( (addr & (1 << 6)) != 0 && (addr & (1 << 5)) == 0 && (addr & (1 << 4)) != 0)
		{
			//Alphanumeric, (coded according to GSM TS 03.38 7-bit default alphabet)
			str1 = pduToText(pdu.substring(j, j + k));
			originator = "";
			for (i = 0; i < str1.length(); i++)
			{
				if ( (int) str1.charAt(i) == 27) originator += CGSMAlphabets.hex2ExtChar( (int) str1.charAt(++i), CGSMAlphabets.GSM7BITDEFAULT);
				else originator += CGSMAlphabets.hex2Char( (int) str1.charAt(i), CGSMAlphabets.GSM7BITDEFAULT);
			}
		}
		//else if ( (addr & (1 << 6)) == 0 && (addr & (1 << 5)) == 0 && (addr & (1 << 4)) != 0) originator = "+" + originator;

		index = j + k + 2;
		str1 = "" + pdu.charAt(index) + pdu.charAt(index + 1);
		protocol = Integer.parseInt(str1, 16);
		index += 2;
		year = Integer.parseInt("" + pdu.charAt(index + 1) + pdu.charAt(index)); index += 2;
		month = Integer.parseInt("" + pdu.charAt(index + 1) + pdu.charAt(index)); index += 2;
		day = Integer.parseInt("" + pdu.charAt(index + 1) + pdu.charAt(index)); index += 2;
		hour = Integer.parseInt("" + pdu.charAt(index + 1) + pdu.charAt(index)); index += 2;
		min = Integer.parseInt("" + pdu.charAt(index + 1) + pdu.charAt(index)); index += 2;
		sec = Integer.parseInt("" + pdu.charAt(index + 1) + pdu.charAt(index)); index += 4;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year + 2000);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, sec);
		date = cal.getTime();
		switch (protocol & 0x0C)
		{
			case 0:
				str1 = pduToText(pdu.substring(index + 2));
				str2 = "";
				for (i = 0; i < str1.length(); i ++)
					if ((int) str1.charAt(i) == 27) str2 += CGSMAlphabets.hex2ExtChar((int) str1.charAt(++i), CGSMAlphabets.GSM7BITDEFAULT);
					else str2 += CGSMAlphabets.hex2Char((int) str1.charAt(i), CGSMAlphabets.GSM7BITDEFAULT);
				str1 = str2;
				break;
			case 4:
				index += 2;
				str1 = "";
				while (index < pdu.length())
				{
					i = Integer.parseInt("" + pdu.charAt(index) + pdu.charAt(index + 1), 16);
					str1 = str1 + (char) i;
					index += 2;
				}
				break;
			case 8:
				index += 2;
				str1 = "";
				while (index < pdu.length())
				{
					i = Integer.parseInt("" + pdu.charAt(index) + pdu.charAt(index + 1), 16);
					j = Integer.parseInt("" + pdu.charAt(index + 2) + pdu.charAt(index + 3), 16);
					str1 = str1 + (char) ((i * 256) + j);
					index += 4;
				}
				break;
		}

		setOriginator(originator);
		setDate(date);
		setText(str1);
	}

	/**
		Set the phone number of the originator. Applicable to incoming messages.

		@param	originator	the originator's phone number (international format).
	*/
	public void setOriginator(String originator) { this.originator = originator; }

	/**
		Returns the originator's phone number (international format). 
		Applicable only for incoming messages.

		@return	 the originator's phone number.
	*/
	public String getOriginator() { return originator; }

	private String pduToText(String pdu)
	{
		String text;
		byte oldBytes[], newBytes[];
		BitSet bitSet;
		int i, j, value1, value2;

		oldBytes = new byte[pdu.length() / 2];
		for (i = 0; i < pdu.length() / 2; i ++)
		{
			oldBytes[i] = (byte) (Integer.parseInt(pdu.substring(i * 2, (i * 2) + 1), 16) * 16);
			oldBytes[i] += (byte) Integer.parseInt(pdu.substring((i * 2) + 1, (i * 2) + 2), 16);
		}

		bitSet = new BitSet(pdu.length() / 2 * 8);
		value1 = 0;
		for (i = 0; i < pdu.length() / 2; i ++)
			for (j = 0; j < 8; j ++)
			{
				value1 = (i * 8) + j;
				if ((oldBytes[i] & (1 << j)) != 0) bitSet.set(value1);
			}
		value1 ++;

		value2 = value1 / 7;
		if (value2 == 0) value2 ++;

		newBytes = new byte[value2];
		for (i = 0; i < value2; i ++)
			for (j = 0; j < 7; j ++)
				if ((value1 + 1) > (i * 7 + j))
					if (bitSet.get(i * 7 + j)) newBytes[i] |= (byte) (1 << j);

		if (newBytes[value2 - 1] == 0) text = new String(newBytes, 0, value2 - 1);
		else text = new String(newBytes);
		return text;
	}
}
