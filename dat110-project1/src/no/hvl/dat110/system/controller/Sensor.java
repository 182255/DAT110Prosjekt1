package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCStub;
import no.hvl.dat110.rpc.RPCUtils;
import no.hvl.dat110.system.sensor.SensorImpl;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	private RPCClient client;

	public Sensor(RPCClient client) {
		this.client = client;
	}

	public int read() {

		SensorImpl sensor = new SensorImpl();
		int temp = 0;
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		byte[] rpcrequest = RPCUtils.marshallVoid(RPCID);
		byte[] reply = sensor.invoke(rpcrequest);
		temp = RPCUtils.unmarshallInteger(reply);

		return temp;
	}

}
