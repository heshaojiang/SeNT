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

import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.smslib.helper.CommPortIdentifier;
import org.smslib.helper.SerialPort;
import org.smslib.helper.SerialPortEvent;
import org.smslib.helper.SerialPortEventListener;

/**
	This class handles the operation the serial port.
	<br><br>
	This class contains all the necessary (low-level) functions that handle COMM API
	and are responsible for the serial communication with the GSM device.
	<br><br>
	Comments left to be added in next release.
*/
class CSerialDriver  implements SerialPortEventListener
{
	/**
		Timeout period for the phone to respond to jSMSEngine.
	*/
	private static final int RECV_TIMEOUT = 30 * 1000;

	/**
		Input/Output buffer size for serial communication.
	*/
	private static final int BUFFER_SIZE = 8192;

	/**
		Delay (20ms) after each character sent. Seems that some mobile phones
		get confused if you send them the commands without any delay, even
		in slow baud rate.
	*/
	private static final int DELAY_BETWEEN_CHARS = 20;

	private String port;
	private int baud;
	private int dataBits;
	private int stopBits;
	private int parity;

	private CommPortIdentifier portId;
	private SerialPort serialPort;
	private InputStream inStream;
	private OutputStream outStream;

	private Logger log;

	public CSerialDriver(String port, int baud, Logger log)
	{
		this.port = port;
		this.baud = baud;
		this.log = log;
		dataBits = SerialPort.DATABITS_8;
		stopBits = SerialPort.STOPBITS_1;
		parity = SerialPort.PARITY_NONE;
	}

	public void setPort(String port) { this.port = port; }
	public String getPort() { return port; }
	public int getBaud() { return baud; }
	public int getDataBits() { return dataBits; }
	public int getStopBits() { return stopBits; }
	public int getParity() { return parity; }

	public boolean open() throws Exception
	{
		throw new RuntimeException("*****************************");
//		boolean result = false;
//		Enumeration portList;
//
//		log.log(Level.INFO, "Connecting...");
//		portList = CommPortIdentifier.getPortIdentifiers();
//		while (portList.hasMoreElements())
//		{
//			portId = (CommPortIdentifier) portList.nextElement();
//			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
//				if (portId.getName().equalsIgnoreCase(getPort()))
//				{
//					serialPort = (SerialPort) portId.open("jSMSEngine", 1000);
//					inStream = serialPort.getInputStream();
//					outStream = serialPort.getOutputStream();
//					serialPort.notifyOnDataAvailable(true);
//					serialPort.notifyOnOutputEmpty(true);
//					serialPort.notifyOnBreakInterrupt(true);
//					serialPort.notifyOnFramingError(true);
//					serialPort.notifyOnOverrunError(true);
//					serialPort.notifyOnParityError(true);
//					serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
//					serialPort.addEventListener(this);
//					serialPort.setSerialPortParams(getBaud(), getDataBits(), getStopBits(), getParity());
//					serialPort.setInputBufferSize(BUFFER_SIZE);
//					serialPort.setOutputBufferSize(BUFFER_SIZE);
//					serialPort.enableReceiveTimeout(RECV_TIMEOUT);
//					result = true;
//				}
//		}
//		return result;
	}

	public void close()
	{
		log.log(Level.INFO, "Disconnecting...");
		try { serialPort.close(); } catch (Exception e) {}
	}

	public void serialEvent(SerialPortEvent event)
	{
		throw new RuntimeException("*****************************");
//		switch(event.getEventType())
//		{
//			case SerialPortEvent.BI:
//				break;
//			case SerialPortEvent.OE:
//				log.log(Level.SEVERE, "COMM-ERROR: Overrun Error!");
//				break;
//			case SerialPortEvent.FE:
//				log.log(Level.SEVERE, "COMM-ERROR: Framing Error!");
//				break;
//			case SerialPortEvent.PE:
//				log.log(Level.SEVERE, "COMM-ERROR: Parity Error!");
//				break;
//			case SerialPortEvent.CD:
//				break;
//			case SerialPortEvent.CTS:
//				break;
//			case SerialPortEvent.DSR:
//				break;
//			case SerialPortEvent.RI:
//				break;
//			case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
//				break;
//			case SerialPortEvent.DATA_AVAILABLE:
//				break;
//		}
	}
	public void clearBuffer() throws Exception
	{
		while (dataAvailable()) {
			inStream.read();
		}
	}

	public void send(String s) throws Exception
	{
		log.log(Level.INFO, "TE: " + s);
		for (int i = 0; i < s.length(); i ++)
		{
			try { Thread.sleep(DELAY_BETWEEN_CHARS); } catch (Exception e) {}
			outStream.write((byte) s.charAt(i));
			outStream.flush();
		}
	}

	public void send(char c) throws Exception
	{
		outStream.write((byte) c);
		outStream.flush();
	}

	public void skipBytes(int numOfBytes) throws Exception
	{
		int count, c;

		count = 0;
		while (count < numOfBytes)
		{
			c = inStream.read();
			if (c != -1) {
				count ++;
			}
		}
	}

	public boolean dataAvailable() throws Exception
	{
		return (inStream.available() > 0 ? true : false);
	}


	public String getResponse() throws Exception
	{
		final int RETRIES = 3;
		final int WAIT_TO_RETRY = 1000;
		StringBuffer buffer;
		int c, retry;

		retry = 0;
		buffer = new StringBuffer(256);

		while (retry < RETRIES)
		{
			try
				{
					while (true)
					{
						c = inStream.read();
						if (c == -1)
						{
							buffer.delete(0, buffer.length());
							break;
						}

					//由于window系统同linux系统的换行符不同，导致后边判断错误，统一换行符 贾连城
//--------------------------
						if(c==10){
							if(buffer.length() > 0 &&
							   buffer.charAt(buffer.length()-1)==13){
							}
							else{
								c=13;
								buffer.append((char)c);
							}
						}
						else{
							buffer.append((char) c);
						}
//--------------------------
/*
						if ((buffer.toString().indexOf("OK\r") > -1) ||
							((buffer.toString().indexOf("ERROR") > -1) && (buffer.toString().indexOf("\r") > -1))) break;
*/
						if  ((buffer.toString().indexOf("OK\r") > -1) ||
							((buffer.toString().indexOf("ERROR") > -1) && (buffer.toString().lastIndexOf("\r") > buffer.toString().indexOf("ERROR")) ||
							((buffer.toString().indexOf("CPIN")  > -1) && (buffer.toString().indexOf("\r", buffer.toString().indexOf("CPIN")) > -1)))) {
							break;
						}
					}
					retry = RETRIES;
				}
			catch (Exception e)
			{
				if (retry < RETRIES)
				{
					Thread.sleep(WAIT_TO_RETRY);
					retry ++;
				}
				else throw e;
			}
		}
		log.log(Level.INFO, "ME: " + buffer);
		while ((buffer.charAt(0) == 13) || (buffer.charAt(0) == 10)) {
			buffer.delete(0, 1);
		}
		return buffer.toString();
	}
        public String getResponse(int retries) throws Exception
        {
                int RETRIES = retries;
                final int WAIT_TO_RETRY = 1000;
                StringBuffer buffer;
                int c, retry;

                retry = 0;
                buffer = new StringBuffer(256);

                while (retry < RETRIES)
                {
                        try
                                {
                                        while (true)
                                        {
                                            //serialPort.enableReceiveTimeout(3000);

                                                c = inStream.read();
                                                //serialPort.enableReceiveTimeout(RECV_TIMEOUT);

                                                if (c == -1)
                                                {
                                                        //buffer.delete(0, buffer.length());
                                                        break;
                                                }
					//由于window系统同linux系统的换行符不同，导致后边判断错误，统一换行符 贾连城
//--------------------------
                                                if(c==10){
                                                        if(buffer.length() > 0 &&
                                                           buffer.charAt(buffer.length()-1)==13){
                                                        }
                                                        else{
                                                                c=13;
                                                                buffer.append((char)c);
                                                        }
                                                }
                                                else{
                                                        buffer.append((char) c);
                                                }
//--------------------------
/*
                                                if ((buffer.toString().indexOf("OK\r") > -1) ||
                                                        ((buffer.toString().indexOf("ERROR") > -1) && (buffer.toString().indexOf("\r") > -1))) break;
*/
                                                if  ((buffer.toString().indexOf("OK\r") > -1) ||
                                                        ((buffer.toString().indexOf("ERROR") > -1) && (buffer.toString().lastIndexOf("\r") > buffer.toString().indexOf("ERROR")) ||
                                                        ((buffer.toString().indexOf("CPIN")  > -1) && (buffer.toString().indexOf("\r", buffer.toString().indexOf("CPIN")) > -1)))){
                                                      while ((buffer.charAt(0) == 13) || (buffer.charAt(0) == 10)) {
														buffer.delete(0, 1);
													}
                                                      return buffer.toString();
                                                  }
                                                if((buffer.toString().indexOf("BUSY\r") > -1) ||
                                                    (buffer.toString().indexOf("NO ANSWER\r") > -1) ||
                                                    (buffer.toString().indexOf("NO CARRIER\r") > -1) ||
                                                    (buffer.length()>0 && c == -1) ){
                                                     while ((buffer.charAt(0) == 13) || (buffer.charAt(0) == 10)) {
														buffer.delete(0, 1);
													}
                                                     return buffer.toString();
                                                }
                                        }
                                        retry = RETRIES;
                                }
                        catch (Exception e)
                        {
                                if (retry < RETRIES)
                                {
                                        Thread.sleep(WAIT_TO_RETRY);
                                        retry ++;
                                }
                                else throw e;
                        }
                }
                log.log(Level.INFO, "ME: " + buffer);
                while (buffer.length()>0 && ((buffer.charAt(0) == 13) || (buffer.charAt(0) == 10))) {
					buffer.delete(0, 1);
				}
                return buffer.toString();
        }
}



