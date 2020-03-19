/**
 * 文件名：GSMSmsUtil.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.sms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.jsmsengine.CMessage;
import org.jsmsengine.COutgoingMessage;
import org.jsmsengine.CService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smslib.AGateway;
import org.smslib.GatewayException;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.helper.CommPortIdentifier;
import org.smslib.helper.SerialPort;
import org.smslib.modem.SerialModemGateway;

import com.grgbanking.platform.module.notice.vo.SmsSettingVo;

/**
 * @author yrliang
 * 
 */
public class GSMSmsUtil {
	private static Logger logger = LoggerFactory.getLogger(GSMSmsUtil.class);
	private static CommPortIdentifier portId;
	private static Enumeration<CommPortIdentifier> portList;
	private static final String NO_DEVICE_FOUND = "  no device found";

	private static org.smslib.Service srv = null;

	private static CService smsSrv = null;

	private static void checkAndAddGateWay(String manufacturer, String model,
			Integer[] bauds) {
		logger.info("\nSearching for devices...");
		portList = CommPortIdentifier.getPortIdentifiers();
		SerialPort serialPort = null;
		try {
			while (portList.hasMoreElements()) {
				portId = portList.nextElement();
				if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
					logger.info("Found port: {}", portId.getName());
					for (int i = 0; i < bauds.length; i++) {
						serialPort = null;
						InputStream inStream;
						OutputStream outStream;
						int c;
						String response;
						serialPort = portId.open("SMSLibCommTester", 1971);
						serialPort
								.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);
						serialPort.setSerialPortParams(bauds[i],
								SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
								SerialPort.PARITY_NONE);
						inStream = serialPort.getInputStream();
						outStream = serialPort.getOutputStream();
						serialPort.enableReceiveTimeout(1000);
						c = inStream.read();
						while (c != -1) {
							c = inStream.read();
						}
						outStream.write('A');
						outStream.write('T');
						outStream.write('\r');
						Thread.sleep(1000);
						response = "";
						StringBuilder sb = new StringBuilder();
						c = inStream.read();
						while (c != -1) {
							sb.append((char) c);
							c = inStream.read();
						}
						response = sb.toString();
						if (response.indexOf("OK") >= 0) {
							outStream.write('A');
							outStream.write('T');
							outStream.write('+');
							outStream.write('C');
							outStream.write('G');
							outStream.write('M');
							outStream.write('M');
							outStream.write('\r');
							response = "";
							c = inStream.read();
							while (c != -1) {
								response += (char) c;
								c = inStream.read();
							}
							logger.info("       Trying at {}  Found: "
									+ response.replaceAll("\\s+OK\\s+", "")
											.replaceAll("\n", "").replaceAll(
													"\r", ""), bauds[i]);

							SerialModemGateway gateway = new SerialModemGateway(
									portId.getName(), portId.getName(),
									bauds[i], manufacturer, model);
							gateway.setInbound(true);
							gateway.setOutbound(true);
							gateway.setSimPin("0000");
							Service.getInstance().addGateway(gateway);
						} else {
							logger.info("       Trying at {} {}", bauds[i],
									NO_DEVICE_FOUND);
						}

					}
				}
			}
		} catch (GatewayException e) {
			logger.info(" (" + e.getMessage() + ")");
		} catch (IOException e) {
			logger.info(" (" + e.getMessage() + ")");
		} catch (InterruptedException e) {
			logger.info(" (" + e.getMessage() + ")");
		} finally {
			if (serialPort != null) {
				serialPort.close();
			}
		}
	}

	public static void startService(SmsSettingVo setting) {
		// class OutboundNotification implements IOutboundMessageNotification {
		// public void process(AGateway gateway, OutboundMessage msg) {
		// logger.info("Outbound handler called from Gateway: "
		// + gateway.getGatewayId());
		// logger.info(msg.toString());
		//
		// }
		// }
		//
		// srv = Service.getInstance();
		// SerialModemGateway gateway = new SerialModemGateway("GRG_SMS",
		// setting.getComPort(), Integer.valueOf(setting.getComBaud()),
		// setting.getManufacturer(), setting.getModel());
		// gateway.setInbound(true);
		// gateway.setOutbound(true);
		// srv.setOutboundMessageNotification(new OutboundNotification());
		// try {
		// srv.addGateway(gateway);
		// srv.startService();
		//
		// System.out.println("Modem connected.");
		// } catch(Exception ex) {
		// ex.printStackTrace();
		// }
		smsSrv = new CService(setting.getComPort(), Integer.valueOf(setting
				.getComBaud()));
		smsSrv.initialize();
		// Set the cache directory.
		smsSrv.setCacheDir(".\\");
		int status;
		status = smsSrv.connect();
		if (status == CService.ERR_OK) {
			// Set the operation mode to PDU - default is ASCII.
			smsSrv.setOperationMode(CService.MODE_PDU);

			// Set the SMSC number (set to default).
			smsSrv.setSmscNumber("");

			// Print out GSM device info...
			System.out.println("Mobile Device Information: ");
			System.out.println("	Manufacturer  : "
					+ smsSrv.getDeviceInfo().getManufacturer());
			System.out.println("	Model         : "
					+ smsSrv.getDeviceInfo().getModel());
			System.out.println("	Serial No     : "
					+ smsSrv.getDeviceInfo().getSerialNo());
			System.out.println("	IMSI          : "
					+ smsSrv.getDeviceInfo().getImsi());
			System.out.println("	S/W Version   : "
					+ smsSrv.getDeviceInfo().getSwVersion());
			System.out.println("	Battery Level : "
					+ smsSrv.getDeviceInfo().getBatteryLevel() + "%");
			System.out.println("	Signal Level  : "
					+ smsSrv.getDeviceInfo().getSignalLevel() + "%");

			// Create a COutgoingMessage object and dispatch it.
			// *** Please update the phone number with one of your choice ***
			// COutgoingMessage msg = new COutgoingMessage("+8613642649697",
			// "测试,TEST!");

			// Disconnect from GSM device.
			// smsSrv.disconnect();
		}
	}

	public static Service getService() {
		return srv;
	}

	/**
	 * 启动GSM Model Gateway
	 * 
	 * @param manufacturer
	 *            厂商
	 * @param model
	 *            型号
	 * @param bauds
	 *            波特率
	 * @return 启动成功
	 */
	public static boolean startService(String manufacturer, String model,
			Integer[] bauds) {


		logger.info("Start a serial gsm modem gateway.");
		logger.info(Library.getLibraryDescription());
		logger.info("Version: " + Library.getLibraryVersion());
		// OutboundNotification outboundNotification = new
		// OutboundNotification();
		// Service.getInstance().setOutboundMessageNotification(
		// outboundNotification);
		Service.getInstance().S.DISABLE_CMMS = true;
		checkAndAddGateWay(manufacturer, model, bauds);

		try {
			Service.getInstance().startService();
			for (AGateway agateway : Service.getInstance().getGateways()) {
				SerialModemGateway gateway = (SerialModemGateway) agateway;
				logger.info("Modem Information:");
				logger.info("  Manufacturer: " + gateway.getManufacturer());
				logger.info("  Model: " + gateway.getModel());
				logger.info("  Serial No: " + gateway.getSerialNo());
				logger.info("  SIM IMSI: " + gateway.getImsi());
				logger.info("  Signal Level: " + gateway.getSignalLevel()
						+ " dBm");
				logger.info("  Battery Level: " + gateway.getBatteryLevel()
						+ "%");

				break;
			}
			return true;
		} catch (TimeoutException e) {
			logger.error("Start gsm modem gateway error!", e);
		} catch (GatewayException e) {
			logger.error("Start gsm modem gateway error!", e);
		} catch (SMSLibException e) {
			logger.error("Start gsm modem gateway error!", e);
		} catch (IOException e) {
			logger.error("Start gsm modem gateway error!", e);
		} catch (InterruptedException e) {
			logger.error("Start gsm modem gateway error!", e);
		}
		return false;
	}

	/**
	 * 停止GSM Model Gateway
	 */
	public static void stopService() {
		try {
			Service.getInstance().stopService();
		} catch (TimeoutException e) {
			logger.error("Stop gsm modem gateway error!", e);
		} catch (GatewayException e) {
			logger.error("Stop gsm modem gateway error!", e);
		} catch (SMSLibException e) {
			logger.error("Stop gsm modem gateway error!", e);
		} catch (IOException e) {
			logger.error("Stop gsm modem gateway error!", e);
		} catch (InterruptedException e) {
			logger.error("Stop gsm modem gateway error!", e);
		}
	}

	/**
	 * 发送消息
	 * 
	 * @param mobile
	 *            手机号码
	 * @param text
	 *            发送内容
	 * @return 是否成功
	 */
	public static boolean sendMessage(String mobile, String text) {
		// OutboundMessage msg = new OutboundMessage(mobile, text);
		// msg.setEncoding(MessageEncodings.ENCUCS2);
		// msg.setStatusReport(true);
		//		System.out.println("现在发送短信...");

		String l_strMobile = mobile;
		if (l_strMobile.indexOf("+86") < 0) {
			l_strMobile = "+86" + l_strMobile;
		}
		COutgoingMessage msg = new COutgoingMessage(l_strMobile, text);

		// Character set is 7bit by default - lets make it UNICODE :)
		// We can do this, because we are in PDU mode (look at line 63).
		// When in ASCII mode,
		// this does not make ANY difference...
		msg.setMessageEncoding(CMessage.MESSAGE_ENCODING_UNICODE);

		int l_iReturn = smsSrv.sendMessage(msg);

		//		System.out.println("发送短信结束...");

		if (l_iReturn == CService.ERR_OK) {
			logger.info("Message Sent!");
			return true;
		} else {
			logger.info("Message Failed:" + l_iReturn);
			return false;
		}

		// return srv.sendMessage(msg);

	}

	/**
	 * 发送消息
	 * 
	 * @param mobile
	 *            手机号码
	 * @param text
	 *            发送内容
	 * @return 是否成功
	 */
	public static boolean queueMessage(String mobile, String text) {
		OutboundMessage msg = new OutboundMessage(mobile, text);
		Service.getInstance().queueMessage(msg);
		return true;

	}

	/**
	 * 发送多个手机号码
	 * 
	 * @param mobiles
	 *            电话
	 * @param text
	 *            内容
	 */
	public static void sendMessage(String[] mobiles, String text) {
		for (String str : mobiles) {
			sendMessage(str, text);
		}
	}


}
