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

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class provides all the functionality of jSMSEngine API to the developer.
 * <br>
 * <br>
 * The class CService provides all the interface routines to jSMSEngine. It is
 * responsible for initialization of the communication with the GSM device,
 * reading and sending messages, setting the phonebook. <br>
 * <br>
 * The sequence of actions that need to be done are:
 * <ul>
 * <li>Call initialize() to setup the service.</li>
 * <li>Call connect() to connect with the GSM device.</li>
 * <li>Call sendMessage(), or readMessages() to send or receive messages from
 * the device. Call deleteMessage() to delete a message from the device's
 * memory.</li>
 * <li>Call refreshDeviceInfo() to get updated GSM device specific information.</li>
 * <li>Call disconnect() to disconnect from the GSM device.</li>
 * </ul>
 * <br>
 */
public class CService {
	/**
	 * Internal Software Name.
	 */
	public static final String _name = "jSMSEngine API";
	/**
	 * Version.
	 */
	public static final String _version = "1.2.6 (B1)";
	/**
	 * Release Date.
	 */
	public static final String _reldate = "Feb 04, 2005";

	/**
	 * Logging facilities.
	 */
	private static Logger log = Logger.getLogger("org.jsmsengine");

	/**
	 * This error value is returned when the operation was succesfull.
	 */
	public static final int ERR_OK = 0;

	/**
	 * This is a generic error, which is not classified yet. More error
	 * classifications may be introduced at a later stage.
	 */
	public static final int ERR_GENERIC_ERROR = -1;

	/**
	 * This error value is returned when the service is not initialized yet. You
	 * should call method initialize().
	 */
	public static final int ERR_NOT_INITIALIZED = -10;

	/**
	 * This error value is returned when the service is not connected to the GSM
	 * device. You should call method connect().
	 */
	public static final int ERR_NOT_CONNECTED = -11;

	/**
	 * This error value is returned when the GSM device does not support ASCII
	 * or PDU mode. This is a fatal error, in the sense that jSMSEngine can work
	 * only with GSM devices supporting ASCII or PDU Mode.
	 */
	public static final int ERR_COMM_NOT_SUPPORTED = -20;

	/**
	 * This error value is returned when the GSM device does not support HEX
	 * mode. This is a fatal error, in the sense that jSMSEngine can work only
	 * with GSM devices supporting HEX Mode when in ASCII mode. In order to get
	 * around this error, switch to PDU mode.
	 */
	public static final int ERR_CHARSET_HEX_NOT_SUPPORTED = -21;

	/**
	 * This error value is returned when the GSM device does not support the
	 * AT+CNMI command for disabling indications to TE.
	 */
	public static final int ERR_CANNOT_DISABLE_INDICATIONS = -22;

	/**
	 * This error value is returned when the specific message was not found.
	 * Double-check your message and/or memory index used.
	 */
	public static final int ERR_MESSAGE_NOT_FOUND = -30;

	/**
	 * This error value is returned when a send-message operation failed. This
	 * could be attributed to a number of reasons: Coverage problems, invalid
	 * recipient phone number, GSM device malfunction.
	 */
	public static final int ERR_SEND_FAILED = -40;

	/**
	 * This error value is returned when the specified phonebook file did not
	 * load. Recheck your XML file for errors in its structure.
	 */
	public static final int ERR_PHONEBOOK_NOT_LOADED = -50;

	/**
	 * This error value is returned when the given directory is invalid.
	 */
	public static final int ERR_INVALID_DIR = -100;

	/**
	 * This error value on attempting to connect to the GSM device without first
	 * having defined the cache directories.
	 */
	public static final int ERR_NO_CACHE = -101;

	/**
	 * This error value is returned when the GSM device asks for a PIN number,
	 * however the PIN given is invalid. Please check your PIN.
	 */
	public static final int ERR_SIM_PIN_ERROR = -102;

	public static final int ERR_BUSY = -666;
	public static final int ERR_NO_ANSWER = -777;
	public static final int ERR_NO_CARRIER = -888;

	/**
	 * This error value is returned when the specified operation is not
	 * supported by jSMSEngine API.
	 */
	public static final int ERR_NOT_SUPPORTED = -9999;

	/**
	 * Constant value for ASCII operation mode.
	 */
	public static final int MODE_ASCII = 1;

	/**
	 * Constant value for PDU operation mode.
	 */
	public static final int MODE_PDU = 2;

	/**
	 * Receive modes: Synchronous and Ascynchronous.
	 */
	public static final int RECEIVE_MODE_SYNC = 1;
	public static final int RECEIVE_MODE_ASYNC = 2;

	/**
	 * Default value for information that is not reported by the GSM device.
	 */
	public static final String DEFAULT_VALUE_NOT_REPORTED = "* N/A *";

	public static final int MAX_SMS_LEN_7BIT = 160;
	public static final int MAX_SMS_LEN_8BIT = 140;
	public static final int MAX_SMS_LEN_UNICODE = 70;
	private static final String SMS_SPLIT_SIGNATURE = "(?/$)";
	private static final int SMS_PARTS = 8;
	private static int smsSplitId = 0;

	private String cacheDir;
	private String smscNumber;
	private String simPin;
	private int operationMode;
	private int supportedModes;
	private int receiveMode;

	private CSerialDriver serialDriver;
	private boolean initialized;
	private boolean connected;
	private CPhoneBook phoneBook;
	private CDeviceInfo deviceInfo;

	private CReceiveThread receiveThread;

	/**
	 * Synchronization object for critical sections of the API.
	 */
	private Object _SYNC_ = new Object();

	/**
	 * Default constructor of the class.
	 *
	 * @param port
	 *            the serial port where the GSM device is connected (e.g.
	 *            "com1").
	 * @param baud
	 *            the connection speed (i.e. 9600, 19200 etc).
	 *
	 * <br>
	 * <br>
	 * Notes:
	 * <ul>
	 * <li>Use one of the standard values for baud. Most GSM devices work well
	 * at 9600 or 19200. Some may handle speeds up to 115200 (like Nokia mobile
	 * phone model 6210 does). The connection speed is not that important to the
	 * speed at which jSMSEngine processes messages. Personally, I work at 9200
	 * to avoid pushing the mobile. Dedicated GSM modems may handle higher
	 * speeds better than mobile phones do.</li>
	 * </ul>
	 */
	public CService(String port, int baud) {
		setInitialized(false);
		setConnected(false);
		serialDriver = new CSerialDriver(port, baud, log);
		phoneBook = new CPhoneBook();
		deviceInfo = new CDeviceInfo();
		receiveMode = RECEIVE_MODE_SYNC;
		receiveThread = new CReceiveThread();
		receiveThread.start();
		log.setLevel(Level.SEVERE);
	}

	/**
	 * Returns TRUE if the service has already been initialized.
	 *
	 * @return TRUE if the service has already been initialized.
	 */
	public boolean getInitialized() {
		return initialized;
	}

	/**
	 * Returns TRUE if the service is connected with the GSM device.
	 *
	 * @return TRUE if the service is connected with the GSM device.
	 */
	public boolean getConnected() {
		return connected;
	}

	/**
	 * Returns a CDeviceInfo object that holds information about the GSM device
	 * in use.
	 *
	 * @return a CDeviceInfo object.
	 * @see CDeviceInfo
	 */
	public CDeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	/**
	 * Sets the cache directory for messages.
	 *
	 * @param dir
	 *            The directory which will act like a cache.
	 * @return One of ERR_* values.
	 */
	public int setCacheDir(String dir) {
		if (dir == null)
			return ERR_INVALID_DIR;
		else {
			File f = new File(dir);
			if (f.exists()) {
				cacheDir = dir;
				return ERR_OK;
			} else
				return ERR_INVALID_DIR;
		}
	}

	/**
	 * Sets the Short Message Service Center (SMSC) number. Please use
	 * international format. If you don't want to set the SMSC and use the one
	 * defined in your GSM device, use an empty string parameter. Another way to
	 * do the same, is to pass a null parameter. Some phones may prefer one way
	 * or the other - please test your phone.
	 *
	 * @param smscNumber
	 *            the SMSC number.
	 */
	public void setSmscNumber(String smscNumber) {
		this.smscNumber = smscNumber;
	}

	/**
	 * Returns the Short Message Service Center (SMSC) number you have
	 * previously defined with setSmscNumber().
	 *
	 * @return the SMSC number.
	 */
	public String getSmscNumber() {
		return smscNumber;
	}

	/**
	 * Sets the SIM pin number. This is used if and when the GSM device asks for
	 * it. If you set it to null, then the API does not give any PIN to the
	 * device (in order to avoid locking it up), and returns ERR_SIM_PIN_ERROR.
	 *
	 * @param simPin
	 *            the SIM pin number.
	 */
	public void setSimPin(String simPin) {
		this.simPin = simPin;
	}

	/**
	 * Returns the SIM pin number.
	 *
	 * @return the SIM pin number.
	 */
	public String getSimPin() {
		return simPin;
	}

	/**
	 * Sets the operation mode of the GSM device
	 *
	 * @param mode
	 *            the mode of operation (one of values MODE_ASCII, MODE_PDU).
	 * @return TRUE if the change of mode succeded.
	 * @see CService#getOperationMode()
	 */
	public boolean setOperationMode(int mode) {
		boolean result;

		try {
			switch (mode) {
			case MODE_ASCII:
				serialDriver.send(CATCommands.AT_ASCII_MODE);
				if (serialDriver.getResponse().equalsIgnoreCase(
						CATCommands.AT_OK)) {
					result = true;
					operationMode = MODE_ASCII;
				} else {
					result = false;
				}
				break;
			case MODE_PDU:
				serialDriver.send(CATCommands.AT_PDU_MODE);
				if (serialDriver.getResponse().equalsIgnoreCase(
						CATCommands.AT_OK)) {
					result = true;
					operationMode = MODE_PDU;
				} else {
					result = false;
				}
				break;
			case 0:
				operationMode = 0;
				result = true;
				break;
			default:
				result = false;
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	/**
	 * Returns the operation mode of the GSM device, i.e. one of the values
	 * MODE_ASCII, MODE_PDU.
	 *
	 * @return the operation mode.
	 * @see CService#setOperationMode(int)
	 */
	public int getOperationMode() {
		return operationMode;
	}

	/**
	 * Sets the reception mode. There are two reception modes, the synchronous
	 * and the asynchronous. In synchronous mode, you should call readMessages()
	 * function on demand, where you want to check for new messages. In
	 * asynchronous mode, the engine automatically calls the received() method
	 * (which you <strong>should</strong> override) for every received message.
	 * <br>
	 * By default, the reception mode is the synchronous one.
	 *
	 * @param receiveMode
	 *            the reception mode (one of values RECEIVE_MODE_ASYNC,
	 *            RECEIVE_MODE_SYNC).
	 * @see CService#getReceiveMode()
	 */
	public void setReceiveMode(int receiveMode) {
		this.receiveMode = receiveMode;
	}

	/**
	 * Returns the reception mode.
	 *
	 * @return the reception mode (one of values RECEIVE_MODE_ASYNC,
	 *         RECEIVE_MODE_SYNC).
	 * @see CService#setReceiveMode(int)
	 */
	public int getReceiveMode() {
		return receiveMode;
	}

	/**
	 * Returns the cache directory for messages.
	 *
	 * @return the caching directory.
	 * @see CService#setCacheDir(String)
	 */
	public String getCacheDir() {
		return cacheDir;
	}

	/**
	 * Initializes the service. This should be the first method call.
	 *
	 * @return ERR_OK (for this version).
	 * @see CService#connect()
	 */
	public int initialize() {
		cacheDir = null;
		smscNumber = null;
		simPin = null;
		operationMode = 0;
		supportedModes = 0;
		setInitialized(true);
		return ERR_OK;
	}

	/**
	 * Connects to the GSM device. Opens the serial port, and sends the
	 * appropriate AT commands to initialize the operation mode of the GSM
	 * device. Retrieves information about the GSM device. This method should be
	 * called after initialize() has been called. <br>
	 * By default, jSMSEngine API sets your GSM device to PDU mode. If you want
	 * to switch to ASCII mode (I don't see any reason why, but anyway...), use
	 * the setOperationMode() method. <br>
	 * <br>
	 * Notes: <br>
	 * <ul>
	 * <li>The GSM device specific information (read by the call to
	 * refreshDeviceInfo() function is called once from this method. Since some
	 * information changes with time (such as battery or signal level), its your
	 * responsibility to call refreshDeviceInfo() periodically in order to have
	 * the latest information. Otherwise, you will get the information snapshot
	 * taken at the time of the initial connection. </li>
	 * </ul>
	 *
	 * @return One of ERR_* values.
	 * @see CDeviceInfo
	 * @see CService#refreshDeviceInfo()
	 * @see CService#disconnect()
	 * @see CService#initialize()
	 * @see CService#setOperationMode(int)
	 */
	public int connect() {
		synchronized (_SYNC_) {
			if (getInitialized()) {
				if (getCacheDir() == null)
					return ERR_NO_CACHE;
				else {
					try {
						if (serialDriver.open()) {
							try {
								Thread.sleep(2000);
							} catch (Exception e) {
							}
							serialDriver.clearBuffer();
							serialDriver.send(CATCommands.AT_ECHO_OFF);
							serialDriver.getResponse();
							serialDriver.send(CATCommands.AT_AT);
							if (serialDriver.getResponse().equalsIgnoreCase(
									CATCommands.AT_OK)) {
								if (getSimPin() != null) {
									serialDriver
											.send(CATCommands.AT_CHECK_LOGIN);
									if (serialDriver.getResponse().indexOf(
											CATCommands.AT_READY) == -1) {
										if (getSimPin() == null) {
											serialDriver.close();
											setConnected(false);
											return ERR_SIM_PIN_ERROR;
										} else {
											serialDriver
													.send(CUtils
															.substituteSymbol(
																	CATCommands.AT_LOGIN,
																	"{1}",
																	getSimPin()));
											if (serialDriver.getResponse()
													.indexOf(CATCommands.AT_OK) == -1) {
												serialDriver.close();
												setConnected(false);
												return ERR_SIM_PIN_ERROR;
											} else {
												// Pin OK - wait 20 seconds for
												// the GSM device to boot up...
												try {
													Thread.sleep(10000);
												} catch (Exception e) {
												}
												serialDriver
														.send(CATCommands.AT_AT);
												serialDriver.getResponse();
												try {
													Thread.sleep(10000);
												} catch (Exception e) {
												}
												serialDriver
														.send(CATCommands.AT_AT);
												serialDriver.getResponse();
											}
										}
									}
								}
								serialDriver.send(CATCommands.AT_ASCII_MODE);
								if (serialDriver.getResponse()
										.equalsIgnoreCase(CATCommands.AT_OK)) {
									supportedModes |= MODE_ASCII;
								}
								serialDriver.send(CATCommands.AT_PDU_MODE);
								if (serialDriver.getResponse()
										.equalsIgnoreCase(CATCommands.AT_OK)) {
									supportedModes |= MODE_PDU;
								}
								if ((supportedModes & MODE_PDU) != 0) {
									setOperationMode(MODE_PDU);
								} else if ((supportedModes & MODE_ASCII) != 0) {
									setOperationMode(MODE_ASCII);
								} else {
									setOperationMode(0);
								}
								if (operationMode == 0) {
									serialDriver.close();
									setConnected(false);
									return ERR_COMM_NOT_SUPPORTED;
								} else {
									setConnected(true);
									refreshDeviceInfo();
									if ((deviceInfo.getManufacturer()
											.toUpperCase().indexOf("ERICSSON") >= 0)
											&& (deviceInfo.getModel()
													.toUpperCase().indexOf(
															"630") >= 0)) {
										serialDriver
												.send(CATCommands.AT_ERICSSON_T630_DISABLE_INDICATIONS);
									} else if (deviceInfo.getManufacturer()
											.toUpperCase().indexOf("ERICSSON") >= 0) {
										serialDriver
												.send(CATCommands.AT_ERICSSON_DISABLE_INDICATIONS);
									} else {
										serialDriver
												.send(CATCommands.AT_DISABLE_INDICATIONS);
									}
									if (serialDriver
											.getResponse()
											.equalsIgnoreCase(CATCommands.AT_OK)) {
										if (operationMode == MODE_ASCII) {
											serialDriver
													.send(CATCommands.AT_CHARSET_HEX);
											if (serialDriver.getResponse()
													.equalsIgnoreCase(
															CATCommands.AT_OK)) {
												if (deviceInfo
														.getManufacturer()
														.toUpperCase().indexOf(
																"SIEMENS") >= 0) {
													serialDriver
															.send(CATCommands.AT_SIEMENS_SMS_STORAGE);
													serialDriver.getResponse();
												} else if (deviceInfo
														.getManufacturer()
														.toUpperCase().indexOf(
																"ERICSSON") >= 0) {
													serialDriver
															.send(CATCommands.AT_ERICSSON_SMS_STORAGE);
													serialDriver.getResponse();
												}
											} else {
												serialDriver.close();
												setConnected(false);
												return ERR_CHARSET_HEX_NOT_SUPPORTED;
											}
										} else {
											if (deviceInfo.getManufacturer()
													.toUpperCase().indexOf(
															"SIEMENS") >= 0) {
												serialDriver
														.send(CATCommands.AT_SIEMENS_SMS_STORAGE);
												serialDriver.getResponse();
											} else if (deviceInfo
													.getManufacturer()
													.toUpperCase().indexOf(
															"ERICSSON") >= 0) {
												serialDriver
														.send(CATCommands.AT_ERICSSON_SMS_STORAGE);
												serialDriver.getResponse();
											}
										}
									} else {
										serialDriver.close();
										setConnected(false);
										return ERR_CANNOT_DISABLE_INDICATIONS;
									}
								}
							} else {
								serialDriver.close();
								setConnected(false);
							}
						} else {
							setConnected(false);
						}
						return (getConnected() ? ERR_OK : ERR_NOT_CONNECTED);
					} catch (Exception e) {
						serialDriver.close();
						return ERR_NOT_CONNECTED;
					}
				}
			} else
				return ERR_NOT_INITIALIZED;
		}
	}

	/**
	 * Disconnects to the GSM device. Closes the serial port.
	 *
	 * @return ERR_OK value.
	 * @see CService#connect()
	 */
	public int disconnect() {
		synchronized (_SYNC_) {
			try {
				serialDriver.close();
			} catch (Exception e) {
			}
			setConnected(false);
			return ERR_OK;
		}
	}

	/**
	 * Loads the phonebook. The phonebook is an XML file containing associations
	 * of name and phone numbers. <br>
	 * <br>
	 * <strong>The phonebook is optional.</strong>
	 *
	 * @param phoneBookFile
	 *            The XML full-path name which keeps the phonebook.
	 * @return One of ERR_* values.
	 * @see CPhoneBook
	 * @see CService#sendMessage(COutgoingMessage)
	 * @see CService#sendMessage(LinkedList)
	 */
	public int setPhoneBook(String phoneBookFile) {
		return (phoneBook.load(phoneBookFile) ? ERR_OK
				: ERR_PHONEBOOK_NOT_LOADED);
	}

	/**
	 * Refreshes the GSM device specific information. This method is called once
	 * during connection. Its up to the developer to call it periodically in
	 * order to get the latest information.
	 *
	 * @return One of ERR_* values.
	 * @see CDeviceInfo
	 * @see CService#connect()
	 * @see CService#getDeviceInfo()
	 */
	public int refreshDeviceInfo() {
		synchronized (_SYNC_) {
			if (getConnected()) {
				try {
					deviceInfo.manufacturer = getManufacturer();
					deviceInfo.model = getModel();
					deviceInfo.serialNo = getSerialNo();
					deviceInfo.imsi = getImsi();
					deviceInfo.swVersion = getSwVersion();
					deviceInfo.batteryLevel = getBatteryLevel();
					deviceInfo.signalLevel = getSignalLevel();
					return ERR_OK;
				} catch (Exception e) {
					e.printStackTrace();
					setConnected(false);
					return ERR_NOT_CONNECTED;
				}
			} else
				return ERR_NOT_CONNECTED;
		}
	}

	/**
	 * Reads SMS from the GSM device's memory. You should call this method when
	 * you want to read messages from the device. In the MessageList object you
	 * pass, the method will add objects of type CIncomingMessage, as many of
	 * them as the messages pending to be read. The class defines which types of
	 * messages should be read. <br>
	 * <br>
	 * <strong>Notes:</strong>
	 * <ul>
	 * <li>The method <strong>does not delete</strong> the messages it reads
	 * from the GSM device. It's your responsibility to delete them, if you
	 * don't want them. Otherwise, on the next call of this function you will
	 * read the same messages.</li>
	 * </ul>
	 * <strong>IMPORTANT NOTE:</strong> This version of jSMSEngine will read
	 * and process only received messages, and not stored messages - regardless
	 * of the class you requested.
	 *
	 * @param messageList
	 *            a LinkedList object which will be loaded with the messages.
	 * @param messageClass
	 *            one of the CLASS_* values defined in CIncomingMessage class
	 *            which define what type of messages are to be read.
	 * @return One of ERR_* values.
	 * @see CIncomingMessage
	 * @see CService#deleteMessage(CIncomingMessage)
	 * @see CService#deleteMessage(int)
	 */
	public int readMessages(LinkedList messageList, int messageClass) {
		int i, j, memIndex;
		String response, line, sms, temp, originator, text, pdu;
		String day, month, year, hour, min, sec;
		BufferedReader reader;
		Date sentDate;
		Calendar cal = Calendar.getInstance();

		synchronized (_SYNC_) {
			if (getConnected()) {
				switch (operationMode) {
				case MODE_ASCII:
					try {
						serialDriver.send(CATCommands.AT_CMD_MODE);
						messageList.clear();
						serialDriver.send(CATCommands.AT_ASCII_MODE);
						response = serialDriver.getResponse();
						serialDriver.send(CATCommands.AT_CHARSET_HEX);
						response = serialDriver.getResponse();
						switch (messageClass) {
						case CIncomingMessage.CLASS_ALL:
							serialDriver.send(CUtils.substituteSymbol(
									CATCommands.AT_LIST, "{1}", "\"ALL\""));
							break;
						case CIncomingMessage.CLASS_REC_UNREAD:
							serialDriver.send(CUtils.substituteSymbol(
									CATCommands.AT_LIST, "{1}",
									"\"REC UNREAD\""));
							break;
						case CIncomingMessage.CLASS_REC_READ:
							return ERR_NOT_SUPPORTED;
						case CIncomingMessage.CLASS_STO_UNSENT:
							return ERR_NOT_SUPPORTED;
						case CIncomingMessage.CLASS_STO_SENT:
							return ERR_NOT_SUPPORTED;
						}
						response = serialDriver.getResponse();

						sms = "";
						reader = new BufferedReader(new StringReader(response));
						line = reader.readLine();
						while ((line != null) && (!line.equalsIgnoreCase("OK"))) {
							if (line.indexOf("+CMGL") == 0) {
								sms = line;
							} else if ((line.indexOf("+CMGL") == -1)
									&& (line.length() > 0)) {
								sms = sms + "~" + line;
							} else {
								sms = sms + "~" + "00";
							}

							if ((sms.indexOf("\"REC READ\"") >= 0)
									|| (sms.indexOf("\"REC UNREAD\"") >= 0)) {
								if (sms.indexOf("~") != -1) {
									i = 6;
									temp = "";
									while (sms.charAt(i) != ',') {
										temp += sms.charAt(i);
										i++;
									}
									memIndex = Integer.parseInt(temp.trim());
									i = sms.indexOf('"') + 1;
									i = sms.indexOf('"', i) + 1;
									i = sms.indexOf('"', i) + 1;
									temp = "";
									while (sms.charAt(i) != '"') {
										temp += sms.charAt(i);
										i++;
									}
									originator = temp;

									i++;
									i = sms.indexOf('"', i) + 1;
									day = sms.substring(i + 6, i + 6 + 2);
									month = sms.substring(i + 3, i + 3 + 2);
									year = sms.substring(i, i + 2);
									year = "20" + year;
									hour = sms.substring(i + 9, i + 9 + 2);
									min = sms.substring(i + 12, i + 12 + 2);
									sec = sms.substring(i + 15, i + 15 + 2);
									cal.set(Integer.parseInt(year), Integer
											.parseInt(month) - 1, Integer
											.parseInt(day), Integer
											.parseInt(hour), Integer
											.parseInt(min), Integer
											.parseInt(sec));
									sentDate = cal.getTime();

									i = sms.indexOf('~') + 1;
									text = sms.substring(i);
									if (text.equalsIgnoreCase("00")) {
										messageList.add(new CIncomingMessage(
												sentDate, originator, "",
												memIndex));
									} else {
										messageList
												.add(new CIncomingMessage(
														sentDate,
														originator,
														CGSMAlphabets
																.hex2Text(
																		text,
																		CGSMAlphabets.GSM7BITDEFAULT),
														memIndex));
									}
									deviceInfo.getStatistics().incTotalIn();
									sms = "";
								}
							} else if (sms.indexOf("\"STO SENT\"") >= 0) {
								;
							} else if (sms.indexOf("\"STO UNSENT\"") >= 0) {
								;
							}
							line = reader.readLine();
						}
						reader.close();
						return ERR_OK;
					} catch (Exception e) {
						e.printStackTrace();
						return ERR_GENERIC_ERROR;
					}
				case MODE_PDU:
					try {
						serialDriver.send(CATCommands.AT_CMD_MODE);
						messageList.clear();
						serialDriver.send(CATCommands.AT_PDU_MODE);
						response = serialDriver.getResponse();
						switch (messageClass) {
						case CIncomingMessage.CLASS_ALL:
							serialDriver.send(CUtils.substituteSymbol(
									CATCommands.AT_LIST, "{1}", "4"));
							break;
						case CIncomingMessage.CLASS_REC_UNREAD:
							serialDriver.send(CUtils.substituteSymbol(
									CATCommands.AT_LIST, "{1}", "0"));
							break;
						case CIncomingMessage.CLASS_REC_READ:
							serialDriver.send(CUtils.substituteSymbol(
									CATCommands.AT_LIST, "{1}", "1"));
							break;
						case CIncomingMessage.CLASS_STO_UNSENT:
							serialDriver.send(CUtils.substituteSymbol(
									CATCommands.AT_LIST, "{1}", "2"));
							break;
						case CIncomingMessage.CLASS_STO_SENT:
							serialDriver.send(CUtils.substituteSymbol(
									CATCommands.AT_LIST, "{1}", "3"));
							break;
						}
						response = serialDriver.getResponse();
						reader = new BufferedReader(new StringReader(response));
						line = reader.readLine().trim();
						while ((line != null) && (line.length() > 0)
								&& (!line.equalsIgnoreCase("OK"))) {
							i = line.indexOf(':');
							j = line.indexOf(',');
							memIndex = Integer.parseInt(line
									.substring(i + 1, j).trim());
							pdu = reader.readLine();
							if (isIncomingMessage(pdu)) {
								messageList.add(new CIncomingMessage(pdu,
										memIndex));
								deviceInfo.getStatistics().incTotalIn();
							}
							// else messageList.add(new COutgoingMessage(pdu,
							// memIndex));
							line = reader.readLine().trim();
						}
						reader.close();
						return ERR_OK;
					} catch (Exception e) {
						e.printStackTrace();
						return ERR_GENERIC_ERROR;
					}
				default:
					return ERR_GENERIC_ERROR;
				}
			} else
				return ERR_NOT_CONNECTED;
		}
	}

	/**
	 * Send an SMS message from the GSM device. Once connected, you can create a
	 * COutgoingMessage object with the message you want to send, and pass it to
	 * this function. <br>
	 * <br>
	 * <strong>Notes:</strong>
	 * <ul>
	 * <li>If you have set a phonebook, you can create the COutgoingMessage
	 * object with a nickname, instead of the actual phone number.</li>
	 * </ul>
	 *
	 * @param message
	 *            a COutgoingMessage containing the message you wish to send.
	 * @return One of ERR_* values.
	 * @see COutgoingMessage
	 * @see CPhoneBook
	 * @see CService#sendMessage(LinkedList)
	 * @see CService#setPhoneBook(String)
	 */
	public int sendMessage(COutgoingMessage message) {
		LinkedList messageList;
		COutgoingMessage msg;
		messageList = new LinkedList();
		int error;

		// System.out.println("���ŵ��ܳ���Ϊ��"+message.getText().length());
		/*
		 * // ���ݳ������ָ�Ϊ�������� if (message.getText().length() > 70) {
		 * String[] mArray = div(message.getText(), 68); for (int i = 0; i <
		 * mArray.length; i++) { COutgoingMessage msgTemp = null; try { msgTemp
		 * = (COutgoingMessage) BeanUtils.cloneBean(message); } catch
		 * (IllegalAccessException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (InstantiationException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch
		 * (InvocationTargetException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (NoSuchMethodException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } msgTemp.setText(1 +
		 * i + ")" + mArray[i]); synchronized (_SYNC_) {
		 * messageList.add(msgTemp); } } } else {
		 */
		synchronized (_SYNC_) {
			messageList.add(message);
		}
		// }
		// for (Iterator iterator = messageList.iterator();
		// iterator.hasNext();) {
		// COutgoingMessage m = (COutgoingMessage) iterator.next();
		// messageList.add(m);
		// }
		synchronized (_SYNC_) {
			error = sendMessage(messageList);
			if (error == ERR_OK) {
				// ����
				msg = (COutgoingMessage) messageList.get(0);
				// ??? ��ʲô�õģ�
				message.setDispatchDate(msg.getDispatchDate());
			}
			return error;
		}
	}

	/**
	 * Send an series of SMS messages from the GSM device. This method is used
	 * when you want to send more than one message as a batch. If your GSM
	 * device support the feature of keeping the GSM link open during message
	 * dispatch, this method should work faster than calling the
	 * sendMessage(COutgoingMessage) method many times. <br>
	 * Just create a LinkedList object, add as many COutgoingMessage objects you
	 * wish and call the method. <br>
	 * <br>
	 * <strong>Notes:</strong>
	 * <ul>
	 * <li>If you have set a phonebook, you can create the COutgoingMessage
	 * object with a nickname, instead of the actual phone number.</li>
	 * </ul>
	 *
	 * @param messageList
	 *            a LinkedList filled with COutgoingMessage objects.
	 * @return One of ERR_* values.
	 * @see COutgoingMessage
	 * @see CPhoneBook
	 * @see CService#sendMessage(COutgoingMessage)
	 * @see CService#setPhoneBook(String)
	 */
	public int sendMessage(LinkedList messageList) {
		LinkedList outList;
		COutgoingMessage message;
		String response, pdu;
		int i, j, error;

		messageList = this.splitLargeMessages(messageList);
		synchronized (_SYNC_) {
			if (getConnected()) {
				if (phoneBook.isLoaded()) {
					outList = phoneBook.expandPhoneBookEntries(messageList);
				} else {
					outList = messageList;
				}
				switch (operationMode) {
				case MODE_ASCII:
					try {
						serialDriver.send(CATCommands.AT_ASCII_MODE);
						response = serialDriver.getResponse();
						serialDriver.send(CATCommands.AT_KEEP_LINK_OPEN);
						response = serialDriver.getResponse();
						serialDriver.send(CATCommands.AT_CHARSET_HEX);
						response = serialDriver.getResponse();
						error = ERR_OK;
						for (i = 0; i < outList.size(); i++) {
							message = (COutgoingMessage) outList.get(i);
							serialDriver.send(CUtils.substituteSymbol(
									CATCommands.AT_SEND_MESSAGE, "{1}", message
											.getRecipient()));
							while (serialDriver.dataAvailable()) {
								serialDriver.skipBytes(1);
							}
							serialDriver.send(message.getHexText());
							serialDriver.send((char) 26);
							response = serialDriver.getResponse();
							if (response.indexOf(CATCommands.AT_OK) > -1) {
								message.setDispatchDate(new Date());
								deviceInfo.getStatistics().incTotalOut();
							} else {
								message.setDispatchDate(null);
								error = ERR_SEND_FAILED;
							}
						}
						return error;
					} catch (Exception e) {
						e.printStackTrace();
						setConnected(false);
						return ERR_NOT_CONNECTED;
					}
				case MODE_PDU:
					try {
						serialDriver.send(CATCommands.AT_PDU_MODE);
						response = serialDriver.getResponse();
						serialDriver.send(CATCommands.AT_KEEP_LINK_OPEN);
						response = serialDriver.getResponse();
						error = ERR_OK;
						for (i = 0; i < outList.size(); i++) {
							message = (COutgoingMessage) outList.get(i);
							// System.out.println("����:"+message.getText().length()+message.getText());
							pdu = message.getPDU(smscNumber);
							j = pdu.length();
							j /= 2;
							if (smscNumber == null) {
								;
							} else if (smscNumber.length() == 0) {
								j--;
							} else {
								j -= ((smscNumber.length() - 1) / 2);
								j -= 2;
							}
							serialDriver.send(CUtils.substituteSymbol(
									CATCommands.AT_SEND_MESSAGE, "\"{1}\"", ""
											+ j));
							Thread.sleep(500);
							while (serialDriver.dataAvailable()) {
								serialDriver.skipBytes(1);
							}
							serialDriver.send(pdu);
							serialDriver.send((char) 26);
							response = serialDriver.getResponse();
							if (response.indexOf(CATCommands.AT_OK) > -1) {
								message.setDispatchDate(new Date());
								deviceInfo.getStatistics().incTotalOut();
							} else {
								message.setDispatchDate(null);
								error = ERR_SEND_FAILED;
							}
						}
						return error;
					} catch (Exception e) {
						e.printStackTrace();
						setConnected(false);
						return ERR_NOT_CONNECTED;
					}
				default:
					return ERR_SEND_FAILED;
				}
			} else
				return ERR_NOT_CONNECTED;
		}
	}

	/**
	 * Deletes an SMS message from the GSM device memory. <br>
	 * <br>
	 * <strong>Notes:</strong>
	 * <ul>
	 * <li>A deleted message cannot be recovered.</li>
	 * </ul>
	 *
	 * @param message
	 *            a valid CIncomingMessage object, i.e. an object which is
	 *            previously read with readMessages() from the GSM device.
	 * @return One of ERR_* values.
	 * @see CIncomingMessage
	 * @see CService#deleteMessage(int)
	 */
	public int deleteMessage(CIncomingMessage message) {
		synchronized (_SYNC_) {
			return deleteMessage(message.getMemIndex());
		}
	}

	/**
	 * Deletes an SMS message from the GSM device memory. <br>
	 * <br>
	 * <strong>Notes:</strong>
	 * <ul>
	 * <li>A deleted message cannot be recovered.</li>
	 * <li>It is highly recommended to use the other form of the
	 * deleteMessage() method.</li>
	 * </ul>
	 *
	 * @param memIndex
	 *            the memory index of the GSM device's memory from where the
	 *            message (if there is any message there) should be deleted.
	 * @return One of ERR_* values.
	 * @see CService#deleteMessage(CIncomingMessage)
	 */
	public int deleteMessage(int memIndex) {
		String response;

		synchronized (_SYNC_) {
			if (getConnected()) {
				if (memIndex > 0) {
					try {
						serialDriver.send(CUtils.substituteSymbol(
								CATCommands.AT_DELETE_MESSAGE, "{1}", ""
										+ memIndex));
						response = serialDriver.getResponse();
						if (response.indexOf(CATCommands.AT_OK) > -1)
							return ERR_OK;
						else
							return ERR_MESSAGE_NOT_FOUND;
					} catch (Exception e) {
						e.printStackTrace();
						return ERR_GENERIC_ERROR;
					}
				} else
					return ERR_GENERIC_ERROR;
			} else
				return ERR_NOT_CONNECTED;
		}
	}

	/**
	 * Virtual method, called upon receipt of a message (Asynchronous mode
	 * only!) <br>
	 * <br>
	 * <strong>Notes:</strong>
	 * <ul>
	 * <li>If you plan to use jSMSEngine API in asynchronous mode, you should
	 * override this method, making it do your job upon message receipt.</li>
	 * </ul>
	 *
	 * @param message
	 *            the received message.
	 * @return return true if you wish the message to be deleted from the GSM
	 *         device's memory. Otherwise false.
	 * @see CService#setReceiveMode(int)
	 */
	public boolean received(CIncomingMessage message) {
		return false;
	}

	/**
	 * ���طָ����ŵ�����
	 * 
	 * @param messageLenght
	 *            ���ŵĳ���
	 * @param maxMessageLength
	 *            �������ŵ���󳤶�
	 * @return
	 */
	private int getMessageSplitCount(int messageLength, int maxMessageLength) {
		int partLength = maxMessageLength - SMS_SPLIT_SIGNATURE.length();

		return messageLength / partLength + 1;
	}

	/**
	 * Checks if the message is SMS-DELIVER (incoming) or SMS-SUBMIT
	 *
	 * @author George Karadimas
	 * @param pdu
	 *            the message pdu
	 * @return true if the message is SMS-DELIVER
	 */
	private boolean isIncomingMessage(String pdu) {
		String str;
		int index, i;

		str = pdu.substring(0, 2);
		i = Integer.parseInt(str, 16);
		index = (i + 1) * 2;

		str = pdu.substring(index, index + 2);
		i = Integer.parseInt(str, 16);
		if ((i & 0x0B) == 0)
			return true;
		else
			return false;
	}

	private void setConnected(boolean connected) {
		this.connected = connected;
	}

	private void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	private String getManufacturer() throws Exception {
		String response;
		String whatToDiscard;

		whatToDiscard = "+"
				+ CUtils.substituteSymbol(CUtils.substituteSymbol(
						CATCommands.AT_MANUFACTURER, "AT+", ""), "\r", "")
				+ ": ";
		serialDriver.send(CATCommands.AT_MANUFACTURER);
		response = serialDriver.getResponse();
		if (response.length() == 0) {
			response = "";
		} else if (response.indexOf(CATCommands.AT_OK) > -1) {
			response = CUtils.substituteSymbol(response, CATCommands.AT_OK, "");
			response = CUtils.substituteSymbol(response, "\r", "");
			response = CUtils.substituteSymbol(response, "\n", "");
			response = CUtils.substituteSymbol(response, whatToDiscard, "");
			response = CUtils.substituteSymbol(response, "\"", "");
		} else {
			response = DEFAULT_VALUE_NOT_REPORTED;
		}
		return response;
	}

	private String getModel() throws Exception {
		String response;
		String whatToDiscard;

		whatToDiscard = "+"
				+ CUtils.substituteSymbol(CUtils.substituteSymbol(
						CATCommands.AT_MODEL, "AT+", ""), "\r", "") + ": ";
		serialDriver.send(CATCommands.AT_MODEL);
		response = serialDriver.getResponse();
		if (response.length() == 0) {
			response = "";
		} else if (response.indexOf(CATCommands.AT_OK) > -1) {
			response = CUtils.substituteSymbol(response, CATCommands.AT_OK, "");
			response = CUtils.substituteSymbol(response, "\r", "");
			response = CUtils.substituteSymbol(response, "\n", "");
			response = CUtils.substituteSymbol(response, whatToDiscard, "");
			response = CUtils.substituteSymbol(response, "\"", "");
		} else {
			response = DEFAULT_VALUE_NOT_REPORTED;
		}
		return response;
	}

	private String getSerialNo() throws Exception {
		String response;
		String whatToDiscard;

		whatToDiscard = "+"
				+ CUtils.substituteSymbol(CUtils.substituteSymbol(
						CATCommands.AT_SERIALNO, "AT+", ""), "\r", "") + ": ";
		serialDriver.send(CATCommands.AT_SERIALNO);
		response = serialDriver.getResponse();
		if (response.length() == 0) {
			response = "";
		} else if (response.indexOf(CATCommands.AT_OK) > -1) {
			response = CUtils.substituteSymbol(response, CATCommands.AT_OK, "");
			response = CUtils.substituteSymbol(response, "\r", "");
			response = CUtils.substituteSymbol(response, "\n", "");
			response = CUtils.substituteSymbol(response, whatToDiscard, "");
		} else {
			response = DEFAULT_VALUE_NOT_REPORTED;
		}
		return response;
	}

	private String getImsi() throws Exception {
		String response;
		String whatToDiscard;

		whatToDiscard = "+"
				+ CUtils.substituteSymbol(CUtils.substituteSymbol(
						CATCommands.AT_IMSI, "AT+", ""), "\r", "") + ": ";
		serialDriver.send(CATCommands.AT_IMSI);
		response = serialDriver.getResponse();
		if (response.length() == 0) {
			response = "";
		} else if (response.indexOf(CATCommands.AT_OK) > -1) {
			response = CUtils.substituteSymbol(response, CATCommands.AT_OK, "");
			response = CUtils.substituteSymbol(response, "\r", "");
			response = CUtils.substituteSymbol(response, "\n", "");
			response = CUtils.substituteSymbol(response, whatToDiscard, "");
		} else {
			response = DEFAULT_VALUE_NOT_REPORTED;
		}
		return response;
	}

	private String getSwVersion() throws Exception {
		String response;
		String whatToDiscard;

		whatToDiscard = "+"
				+ CUtils.substituteSymbol(CUtils.substituteSymbol(
						CATCommands.AT_SOFTWARE, "AT+", ""), "\r", "") + ": ";
		serialDriver.send(CATCommands.AT_SOFTWARE);
		response = serialDriver.getResponse();
		if (response.length() == 0) {
			response = "";
		} else if (response.indexOf(CATCommands.AT_OK) > -1) {
			response = CUtils.substituteSymbol(response, CATCommands.AT_OK, "");
			response = CUtils.substituteSymbol(response, "\r", "");
			response = CUtils.substituteSymbol(response, "\n", "");
			response = CUtils.substituteSymbol(response, whatToDiscard, "");
			response = CUtils.substituteSymbol(response, "\"", "");
		} else {
			response = DEFAULT_VALUE_NOT_REPORTED;
		}
		return response;
	}

	private int getBatteryLevel() throws Exception {
		String response, level;
		StringTokenizer tokens;
		String whatToDiscard;

		whatToDiscard = "+"
				+ CUtils.substituteSymbol(CUtils.substituteSymbol(
						CATCommands.AT_BATTERY, "AT+", ""), "\r", "") + ": ";
		serialDriver.send(CATCommands.AT_BATTERY);
		response = serialDriver.getResponse();
		if (response.length() == 0) {
			level = "0";
		} else if (response.indexOf(CATCommands.AT_OK) > -1) {
			response = CUtils.substituteSymbol(response, CATCommands.AT_OK, "");
			response = CUtils.substituteSymbol(response, "\r", "");
			response = CUtils.substituteSymbol(response, "\n", "");
			response = CUtils.substituteSymbol(response, whatToDiscard, "");
			tokens = new StringTokenizer(response, ":,");
			tokens.nextToken();
			level = tokens.nextToken().trim();
		} else {
			level = "0";
		}
		return (Integer.parseInt(level));
	}

	private int getSignalLevel() throws Exception {
		String response, level;
		StringTokenizer tokens;
		String whatToDiscard;

		whatToDiscard = "+"
				+ CUtils.substituteSymbol(CUtils.substituteSymbol(
						CATCommands.AT_SIGNAL, "AT+", ""), "\r", "") + ": ";
		serialDriver.send(CATCommands.AT_SIGNAL);
		response = serialDriver.getResponse();
		if (response.length() == 0) {
			level = "0";
		} else if (response.indexOf(CATCommands.AT_OK) > -1) {
			response = CUtils.substituteSymbol(response, CATCommands.AT_OK, "");
			response = CUtils.substituteSymbol(response, "\r", "");
			response = CUtils.substituteSymbol(response, "\n", "");
			response = CUtils.substituteSymbol(response, whatToDiscard, "");
			tokens = new StringTokenizer(response, ":,");
			tokens.nextToken();
			level = tokens.nextToken().trim();
		} else {
			level = "0";
		}
		return (Integer.parseInt(level) * 100 / 31);
	}

	private LinkedList splitLargeMessages(LinkedList messageList) {
		LinkedList outList;
		COutgoingMessage message, newMessage;
		int i, splitIndex, messageLength, smsSplitId, smsDispatchId;
		int maxMessageLength, partLength;
		String splitText;



		// �������������
		int totalMessageCount = 0;
		for (int j = 0; j < messageList.size(); j++) {
			message = (COutgoingMessage) messageList.get(j);
			switch (message.getMessageEncoding()) {
			case CMessage.MESSAGE_ENCODING_7BIT:
				maxMessageLength = MAX_SMS_LEN_7BIT;
				break;
			case CMessage.MESSAGE_ENCODING_8BIT:
				maxMessageLength = MAX_SMS_LEN_8BIT;
				break;
			case CMessage.MESSAGE_ENCODING_UNICODE:
				maxMessageLength = MAX_SMS_LEN_UNICODE;
				break;
			default:
				maxMessageLength = 0;
				break;
			}
			message = (COutgoingMessage) messageList.get(j);
			totalMessageCount += this.getMessageSplitCount(message.getText().length(), maxMessageLength);
		}

		outList = new LinkedList();
		for (i = 0; i < messageList.size(); i++) {
			message = (COutgoingMessage) messageList.get(i);
			switch (message.getMessageEncoding()) {
			case CMessage.MESSAGE_ENCODING_7BIT:
				maxMessageLength = MAX_SMS_LEN_7BIT;
				break;
			case CMessage.MESSAGE_ENCODING_8BIT:
				maxMessageLength = MAX_SMS_LEN_8BIT;
				break;
			case CMessage.MESSAGE_ENCODING_UNICODE:
				maxMessageLength = MAX_SMS_LEN_UNICODE;
				break;
			default:
				maxMessageLength = 0;
				break;
			}
			messageLength = message.getText().length();
			if (messageLength > maxMessageLength) {
				if(message.getHeaderInformation().length() > 0) {
					partLength = maxMessageLength - SMS_SPLIT_SIGNATURE.length() - message.getHeaderInformation().length() -1;
				} else {
					partLength = maxMessageLength - SMS_SPLIT_SIGNATURE.length();
				}
				smsSplitId = getSmsSplitId();
				splitIndex = 0;
				while ((splitIndex * partLength) < messageLength) {
					int from = splitIndex * partLength;
					int to = from + partLength;
					if (to > messageLength) {
						to = messageLength;
					}
					splitText = message.getText().substring(from, to);
					smsDispatchId = smsSplitId + splitIndex;
					StringBuffer splitTextBuffer = new StringBuffer();
					splitTextBuffer.append("(");
					splitTextBuffer.append(String.valueOf(smsDispatchId+1));
					splitTextBuffer.append("/");
					splitTextBuffer.append(totalMessageCount);
					if (message.getHeaderInformation().length() > 0) {
						splitTextBuffer.append(" ");
					}
					splitTextBuffer.append(message.getHeaderInformation());
					splitTextBuffer.append(")");
					splitTextBuffer.append(splitText);

					splitText = splitTextBuffer.toString();
// splitText = SMS_SPLIT_SIGNATURE.substring(0, 1)
//							+ String.valueOf(smsDispatchId+1)
//							+ SMS_SPLIT_SIGNATURE.substring(2, 3) + splitText;

					// System.out.println("���ų��ȣ�"+splitText.length() +
					// "\t"+splitText);
					newMessage = new COutgoingMessage(message.getRecipient(),
							splitText);
					newMessage.setMessageEncoding(message.getMessageEncoding());
					//System.out.println("\tMessageEncoding:\t"+ message.getMessageEncoding());
					outList.add(newMessage);
					splitIndex++;
				}
			} else {
				outList.add(message);
			}
		}
		return outList;
	}

	private int getSmsSplitId() {
		int id;

		id = smsSplitId;
		smsSplitId++;
		if (smsSplitId > 15) {
			smsSplitId = 0;
		}
		return id << 3;
	}

	private class CReceiveThread extends Thread {
		@Override
		public void run() {
			LinkedList messageList;

			messageList = new LinkedList();
			while (true) {
				try {
					sleep(10000);
				} catch (Exception e) {
				}
				synchronized (_SYNC_) {
					if ((getConnected())
							&& (getReceiveMode() == RECEIVE_MODE_ASYNC)) {
						messageList.clear();
						readMessages(messageList, CIncomingMessage.CLASS_ALL);
						for (int i = 0; i < messageList.size(); i++) {
							CIncomingMessage message = (CIncomingMessage) messageList
									.get(i);
							if (received(message)) {
								deleteMessage(message);
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("jSMSEngine API.");
		System.out
				.println("	An open source Java API to process SMS messages from your computer.");
		System.out
				.println("	This software is distributed under the LGPL license.");
		System.out.println("");
		System.out.println("Written by Thanasis Delenikas.");
		System.out
				.println("Credits: George Karadimas, Jose M. Puyal, Robert Rippel, Indika, Wiggo Svegard, Floyd, Mohamad Nazri Shuib, Tharanga Jayawardana, Denis Wong, Sebastian Shardy, Mikel Izagirre, Giorgio Robino, Torgeir Fikse, Pino Navato, Alex Garbagnati, Brouzda Petr, Manuel Aznar Perez, Aldo Puglisi and many others for their contributed code enhancements, feedback and help.");
		System.out.println();
		System.out
				.println("Copyright (C) 2002-2005, Thanasis Delenikas, Athens / GREECE.");
		System.out
				.println("Please check http://www.jsmsengine.org for latest information.");
		System.out.println("\n");
		System.out.println(_name + " v" + _version + " { " + _reldate + " }");
		System.out.println("NOTE: This is a beta release!");
	}

	// ������ ���� ����绰����
	public int dialup(String phone, String[] musicFile) {
		int error = ERR_OK;
		String response;
		synchronized (_SYNC_) {
			if (getConnected()) {
				try {
					serialDriver.send(CUtils.substituteSymbol(
							CATCommands.AT_DIALUP, "{1}", phone));
					response = serialDriver.getResponse(30);
					if (response.length() == 0)
						return ERR_NO_ANSWER;
					if (response.indexOf(CATCommands.AT_OK) > -1) {
						// soundPlayer = new OSound();
						// soundPlayer.setMusicFile(musicFile);
						// new Thread(soundPlayer).start();
						Thread.sleep(3000);
						StringBuffer data = new StringBuffer();
						Thread respThread = new Thread(new RespListen(
								serialDriver, data));
						respThread.start();
						// while (soundPlayer.isPlay() && data.length() == 0) {
						while (data.length() == 0) {
							Thread.sleep(1000);
							serialDriver.send(CATCommands.AT_CMD_MODE);
						}
						// if (soundPlayer.isPlay())
						// soundPlayer.Stop();
						serialDriver.send(CATCommands.AT_CMD_MODE);
						return this.ERR_OK;
					}
					if (response.indexOf(CATCommands.AT_BUSY) > -1)
						return this.ERR_BUSY;
					if (response.indexOf(CATCommands.AT_NO_ANSWER) > -1)
						return this.ERR_NO_ANSWER;
					if (response.indexOf(CATCommands.AT_NO_CARRIER) > -1)
						return this.ERR_NO_CARRIER;
					return ERR_NOT_SUPPORTED;
				} catch (Exception ex) {
					ex.printStackTrace();
					setConnected(false);
					return ERR_NOT_CONNECTED;
				}
			} else
				return ERR_NOT_CONNECTED;
		}
	}

	public int hangUp() {
		int error = ERR_OK;
		String response;
		synchronized (_SYNC_) {
			if (getConnected()) {
				try {
					serialDriver.send(CATCommands.AT_HANGUP);
					// if (soundPlayer != null) {
					// soundPlayer.Stop();
					// }
					return this.ERR_OK;
				} catch (Exception ex) {
					ex.printStackTrace();
					setConnected(false);
					return ERR_NOT_CONNECTED;
				}
			} else
				return ERR_NOT_CONNECTED;
		}
	}

	public CService() {

	}

	/**
	 * ָ�����ȵ��ַ��ȡ,����һ���ַ����� ��������һ���ַ���
	 * String="niya",��2���Ƚ�ȡ,���{"ni", "ya"}
	 * 
	 * @param s
	 * @param n
	 * @return
	 */
	public static String[] div(String s, int n) {
		String[] newa = new String[s.length() / n + 1];
		int a = 0;// ͷָ��
		for (int i = 0; i < newa.length; i++) {
			if (a + n < s.length()) {
				newa[i] = s.substring(a, a + n);
			} else {
				newa[i] = s.substring(a, s.length());
			}
			a = a + n;
		}
		return newa;
	}
}

class RespListen implements Runnable {
	private StringBuffer data;
	private CSerialDriver serialDrv;

	public RespListen(CSerialDriver serialDriver, StringBuffer data) {
		this.serialDrv = serialDriver;
		this.data = data;
	}

	public void run() {
		try {
			if (serialDrv.dataAvailable()) {
				data.append(serialDrv.getResponse(1));
			}
		} catch (Exception ex) {
		}
	}
}
