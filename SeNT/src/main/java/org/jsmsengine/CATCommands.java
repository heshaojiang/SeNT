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
	This class keeps the various AT commands used by jSMSEngine.
	<br><br>
	<strong>
		Please, do not change these commands, unless you are sure of what
		you are doing! Incorrect use of AT commands may lead in loss of data or
		damage to the phone (for example, accidental change of PIN numbers, etc).
	</strong>
*/
public class CATCommands
{
	protected static final String AT_OK = "OK\r";
	protected static final String AT_AT = "AT\r";
        protected static final String AT_BUSY="BUSY\r";
        protected static final String AT_NO_ANSWER="NO ANSWER\r";
        protected static final String AT_NO_CARRIER="NO CARRIER\r";


	protected static final String AT_ECHO_OFF = "ATE0\r";

	protected static final String AT_CMD_MODE = "+++";

	protected static final String AT_DISABLE_INDICATIONS = "AT+CNMI=0,0,0,0\r";

	protected static final String AT_SIEMENS_SMS_STORAGE = "AT+CPMS=MT\r";

	protected static final String AT_ERICSSON_SMS_STORAGE = "AT+CPMS=\"ME\",\"SM\"\r";
	protected static final String AT_ERICSSON_T630_DISABLE_INDICATIONS = "AT+CNMI=2,0,0,0\r";
	protected static final String AT_ERICSSON_DISABLE_INDICATIONS = "AT+CNMI=3,0,0,0\r";

	protected static final String AT_MANUFACTURER = "AT+CGMI\r";
	protected static final String AT_MODEL = "AT+CGMM\r";
	protected static final String AT_SERIALNO = "AT+CGSN\r";
	protected static final String AT_IMSI = "AT+CIMI\r";
	protected static final String AT_BATTERY = "AT+CBC\r";
	protected static final String AT_SIGNAL = "AT+CSQ\r";
	protected static final String AT_SOFTWARE = "AT+CGMR\r";

	protected static final String AT_LIST = "AT+CMGL={1}\r";

	protected static final String AT_SEND_MESSAGE = "AT+CMGS=\"{1}\"\r";
	protected static final String AT_KEEP_LINK_OPEN = "AT+CMMS=1\r";

	protected  static final String AT_DELETE_MESSAGE = "AT+CMGD={1}\r";

	protected static final String AT_ASCII_MODE = "AT+CMGF=1\r";
	protected static final String AT_PDU_MODE = "AT+CMGF=0\r";
	protected static final String AT_CHARSET_HEX = "AT+CSCS=\"HEX\"\r";

	protected static final String AT_CHECK_LOGIN = "AT+CPIN?\r";
	protected static final String AT_LOGIN = "AT+CPIN=\"{1}\"\r";
	protected static final String AT_READY = "READY\r";
        protected static final String AT_DIALUP = "ATD{1};\r";
        protected static final String AT_HANGUP = "ATH\r";
}
