package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCStub;
import no.hvl.dat110.rpc.RPCUtils;
import no.hvl.dat110.system.display.DisplayImpl;

public class Display extends RPCStub {

	private byte RPCID = 1;
	private RPCClient client;
	
	public Display(RPCClient client) {
		this.client = client;
	}

	public Display() {
		// TODO Auto-generated constructor stub
	}

	public void write(String message) {

		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
		DisplayImpl display = new DisplayImpl();
		byte[] rpcrequest = RPCUtils.marshallString(RPCID, message);
		display.invoke(rpcrequest);
		String temp = RPCUtils.unmarshallString(rpcrequest);
		System.out.println("Temperature: " + temp);
//		throw new RuntimeException("not yet implemented");
	}
}
