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

/**
	This class contains the conversion routines to and from the standard 7bit
	GSM alphabet.
	<br><br>
	Every normal ASCII character must be converted according to the GSM 7bit
	default alphabet before dispatching through the GSM device. The opposite
	conversion is made when a message is received.
	<br><br>
	Since some characters in 7bit alphabet are in the position where control
	characters exist in the ASCII alphabet, each message is represented in
	HEX format as well (field hexText in CMessage class and descendants).
	When talking to the GSM device, either for reading messages, or for
	sending messages, a special mode is used where each character of the
	actual message is represented by two hexadecimal digits.
	So there is another conversion step here, in order to get the ASCII
	character from each pair of hex digits, and vice verca.
	<br><br>
	Note: currently, only GSM default 7Bit character set is supported.
	In all routines, you may assume the "charSet" parameter as constant.
*/
class CGSMAlphabets
{
	protected static final int GSM7BITDEFAULT = 1;

	//private static final String alphabet = "@\uFFFD•@@@@@@@@@@@@ƒ_÷√ÀŸ–ÿ”»Œ@@@@@ !\"#\uFFFD&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ@@@@\uFFFDabcdefghijklmnopqrstuvwxyz@@@@@";
	private static final String alphabet = "@\uFFFD\u00A5\u00E8\u00E9\u00F9\u00EC\u00F2\u00C7\n\u00D8\u00F8\r\u00C5\u00E5ƒ_÷√ÀŸ–ÿ”»Œ@\u00C6\u00E6\u00DF\u00C9 !\"#\u00A4%&\'()*+,-./0123456789:;<=>?\u00A1ABCDEFGHIJKLMNOPQRSTUVWXYZ\u00C4\u00D6\u00D1\u00DCß\u00BFabcdefghijklmnopqrstuvwxyz\u00E4\u00F6\u00F1\u00FC\u00E0";

	/**
		Converts an ASCII character to its hexadecimal pair.

		@param	c	the ASCII character.
		@param	charSet	the target character set for the conversion.
		@return	the two hex digits which represent the character in the
				specific character set.
	*/
	protected static String char2Hex(char c, int charSet)
	{
		switch (charSet)
		{
			case GSM7BITDEFAULT:
				for (int i = 0; i < alphabet.length(); i ++)
					if (alphabet.charAt(i) == c) return (i <= 15 ? "0" + Integer.toHexString(i) : Integer.toHexString(i));
				break;
		}
		return (Integer.toHexString((int) c).length() < 2) ? "0" + Integer.toHexString((int) c) : Integer.toHexString((int) c);
	}

	/**
		Converts a hexadecimal value to the ASCII character it represents.

		@param	index	 the hexadecimal value.
		@param	charSet	the character set in which "index" is represented.
		@return  the ASCII character which is represented by the hexadecimal value.
	*/
	protected static char hex2Char(int index, int charSet)
	{
		switch (charSet)
		{
			case GSM7BITDEFAULT:
				if (index < alphabet.length()) return alphabet.charAt(index);
				else return '?';
		}
		return '?';
	}

	/**
		Converts a int value to the extended ASCII character it represents.
		@author George Karadimas
		@param	ch	 the int value.
		@param	charSet	the character set in which "ch" is represented.
		@return  the extended ASCII character which is represented by the int value.
	*/
	protected static char hex2ExtChar(int ch, int charSet)
	{
		switch (charSet)
		{
			case GSM7BITDEFAULT:
				switch (ch)
				{
					case 10:
						return '\f';
					case 20:
						return '^';
					case 40:
						return '{';
					case 41:
						return '}';
					case 47:
						return '\\';
					case 60:
						return '[';
					case 61:
						return '~';
					case 62:
						return ']';
					case 64:
						return '|';
					case 101:
						return '\u20AC';
					default:
						return '?';
				}
			default:
				return '?';
		}
	}

	/**
		Converts the given ASCII string to a string of hexadecimal pairs.

		@param	text	the ASCII string.
		@param	charSet	the target character set for the conversion.
		@return	the string of hexadecimals pairs which represent the "text"
				parameter in the specified "charSet".
	*/
	protected static String text2Hex(String text, int charSet)
	{
		String outText = "";

		for (int i = 0; i < text.length(); i ++)
		{
			switch (text.charAt(i))
			{
				case '\u00C1': case '\u00E1': case '\u00DC':
					outText = outText + char2Hex('A', charSet);
					break;
				case '\u00C2': case '\u00E2':
					outText = outText + char2Hex('B', charSet);
					break;
				case '\u00C3': case '\u00E3':
					outText = outText + char2Hex('\u00C3', charSet);
					break;
				case '\u00C4': case '\u00E4':
					outText = outText + char2Hex('\u00C4', charSet);
					break;
				case '\u00C5': case '\u00E5': case '\u00DD':
					outText = outText + char2Hex('E', charSet);
					break;
				case '\u00C6': case '\u00E6':
					outText = outText + char2Hex('Z', charSet);
					break;
				case '\u00C7': case '\u00E7': case '\u00DE':
					outText = outText + char2Hex('H', charSet);
					break;
				case '\u00C8': case '\u00E8':
					outText = outText + char2Hex('\u00C8', charSet);
					break;
				case '\u00C9': case '\u00E9': case '\u00DF':
					outText = outText + char2Hex('I', charSet);
					break;
				case '\u00CA': case '\u00EA':
					outText = outText + char2Hex('K', charSet);
					break;
				case '\u00CB': case '\u00EB':
					outText = outText + char2Hex('\u00CB', charSet);
					break;
				case '\u00CC': case '\u00EC':
					outText = outText + char2Hex('M', charSet);
					break;
				case '\u00CD': case '\u00ED':
					outText = outText + char2Hex('N', charSet);
					break;
				case '\u00CE': case '\u00EE':
					outText = outText + char2Hex('\u00CE', charSet);
					break;
				case '\u00CF': case '\u00EF': case '\u00FC':
					outText = outText + char2Hex('O', charSet);
					break;
				case '\u00D0': case '\u00F0':
					outText = outText + char2Hex('\u00D0', charSet);
					break;
				case '\u00D1': case '\u00F1':
					outText = outText + char2Hex('P', charSet);
					break;
				case '\u00D3': case '\u00F3': case '\u00F2':
					outText = outText + char2Hex('\u00D3', charSet);
					break;
				case '\u00D4': case '\u00F4':
					outText = outText + char2Hex('T', charSet);
					break;
				case '\u00D5': case '\u00F5': case '\u00FD':
					outText = outText + char2Hex('Y', charSet);
					break;
				case '\u00D6': case '\u00F6':
					outText = outText + char2Hex('\u00D6', charSet);
					break;
				case '\u00D7': case '\u00F7':
					outText = outText + char2Hex('X', charSet);
					break;
				case '\u00D8': case '\u00F8':
					outText = outText + char2Hex('\u00D8', charSet);
					break;
				case '\u00D9': case '\u00F9': case '\u00FE':
					outText = outText + char2Hex('\u00D9', charSet);
					break;
				case '\f':
					outText = outText + Integer.toHexString(27) + Integer.toHexString(10);
					break;
				case '^':
					outText = outText + Integer.toHexString(27) + Integer.toHexString(20);
					break;
				case '{':
					outText = outText + Integer.toHexString(27) + Integer.toHexString(40);
					break;
				case '}':
					outText = outText + Integer.toHexString(27) + Integer.toHexString(41);
					break;
				case '\\':
					outText = outText + Integer.toHexString(27) + Integer.toHexString(47);
					break;
				case '[':
					outText = outText + Integer.toHexString(27) + Integer.toHexString(60);
					break;
				case '~':
					outText = outText + Integer.toHexString(27) + Integer.toHexString(61);
					break;
				case ']':
					outText = outText + Integer.toHexString(27) + Integer.toHexString(62);
					break;
				case '|':
					outText = outText + Integer.toHexString(27) + Integer.toHexString(64);
					break;
				case '\u20AC':
					outText = outText + Integer.toHexString(27) + Integer.toHexString(101);
					break;
				default:
					outText = outText + char2Hex(text.charAt(i), charSet);
					break;
			}
		}
		return outText;
	}

	/**
		Converts the given string of hexadecimal pairs to its ASCII equivalent string.

		@param	text	the hexadecimal pair string.
		@param	charSet	the target character set for the conversion.
		@return	the ASCII string.
	*/
	protected static String hex2Text(String text, int charSet)
	{
		String outText = "";

		for (int i = 0; i < text.length(); i += 2)
		{
			String hexChar = "" + text.charAt(i) + text.charAt(i + 1);
			int c = Integer.parseInt(hexChar, 16);
			if (c == 27)
			{
				i ++;
				outText = outText + hex2ExtChar((char) c, charSet);
			}
			else outText = outText + hex2Char((char) c, charSet);
		}
		return outText;
	}
}
