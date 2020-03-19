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
	This class keeps information and statistics about the usage of the
	GSM device. Information held in this object is updated automatically
	from jSMSEngine API during the initial connection. From then on, its
	up to the programmer to call the necessary refresh function in order
	to get refreshed info if needed.
	<br><br>
	The class contains an object of the subclass named CStatistics, which
	holds counters for the traffic of SMS messages (in/out). These counters
	are updated automatically, when the in/out operations are performed,
	so they are always up to date.

	@see		CService#refreshDeviceInfo
	@see		CService#getDeviceInfo
*/
public class CDeviceInfo
{
	protected String manufacturer;
	protected String model;
	protected String serialNo;
	protected String imsi;
	protected String swVersion;
	protected int batteryLevel;
	protected int signalLevel;
	protected CStatistics statistics;

	/**
		Returns the manufacturer of the device.

		@return  the manufacturer of the device.
	*/
	public String getManufacturer() { return manufacturer; }

	/**
		Returns the model of the device.

		@return  the model of the device.
	*/
	public String getModel() { return model; }

	/**
		Returns the serial no of the device.

		@return  the serial no of the device.
	*/
	public String getSerialNo() { return serialNo; }

	/**
		Returns the IMSI (International Mobile Subscriber Identity) of the device.
		This information depends on the device and/or the smartcard and is not
		always available.

		@return  the IMSI of the device.
	*/
	public String getImsi() { return imsi; }

	/**
		Returns the software version of the device.

		@return  the software version of the device.
	*/
	public String getSwVersion() { return swVersion; }

	/**
		Returns the battery level of the device. A value of 100 means fully
		charged battery. A value of 0 means empty battery.

		@return  the battery level of the device.
	*/
	public int getBatteryLevel() { return batteryLevel; }

	/**
		Returns the signal status of the device. A value of 100 means full signal.
		A value of 0 means no signal.
		<br>
		<strong>
			Note: the scale is logarithmic, not linear!
		</strong>

		@return  the signal status of the device.
	*/
	public int getSignalLevel() { return signalLevel; }

	/**
		Returns the statistics object which keeps statistics for incoming /
		outgoing messages.

		@return  a CStatistics objects.
	*/
	public CStatistics getStatistics() { return statistics; }

	/**
		Default constructor of the class.
	*/
	public CDeviceInfo()
	{
		manufacturer = "";
		model = "";
		serialNo = "";
		imsi = "";
		swVersion = "";
		batteryLevel = 0;
		signalLevel = 0;
		statistics = new CStatistics();
	}

	/**
		This subclass keeps counters for incoming / outgoing messages.

		@see		CService#refreshDeviceInfo()
		@see		CService#getDeviceInfo()
	*/
	public class CStatistics
	{
		protected int totalIn;
		protected int totalOut;

		/**
			Default constructor of the class.
		*/
		public CStatistics()
		{
			totalIn = 0;
			totalOut = 0;
		}

		/**
			Returns the total number of incoming messages processed
			by jSMSEngine.

			@return  the number of incoming messages.
		*/
		public int getTotalIn() { return totalIn; }

		/**
			Returns the total number of outgoing messages dispatched
			by jSMSEngine.

			@return  the number of outgoing messages.
		*/
		public int getTotalOut() { return totalOut; }

		protected void incTotalIn() { totalIn ++; }
		protected void incTotalOut() { totalOut ++;} 
	} 
}
