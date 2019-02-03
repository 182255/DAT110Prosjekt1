package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	private RPCClient client;

	public Sensor(RPCClient client) {
		this.client = client;
	}

	public int read() {

		int temp = 0;
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		byte[] rpcrequest = RPCUtils.marshallInteger(RPCID, temp);
		client.call(rpcrequest);
		temp = RPCUtils.unmarshallInteger(rpcrequest);

		return temp;
	}

}
