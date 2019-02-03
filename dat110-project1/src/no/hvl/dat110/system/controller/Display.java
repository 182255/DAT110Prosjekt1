package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;
	private RPCClient client;
	
	public Display(RPCClient client) {
		this.client = client;
	}

	public void write(String message) {

		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
		byte[] rpcrequest = RPCUtils.marshallString(RPCID, message);
		client.call(rpcrequest);
		
//		throw new RuntimeException("not yet implemented");
	}
}
