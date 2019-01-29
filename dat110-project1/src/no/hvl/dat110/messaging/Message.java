package no.hvl.dat110.messaging;

import java.util.Arrays;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
//		if (payload[0] >= 0 && payload[0] <= 127) {
//			this.payload = payload; // TODO: check for length within boundary
//		}
		this.payload = payload;
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = new byte[128];
		encoded[0] = (byte) payload.length;
		// TODO
		// encapulate/encode the payload of the message
		for (int i = 0; i < payload.length; i++) {
			encoded[i + 1] = payload[i];
		}

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return encoded;

	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate data in received and put in payload
		payload = new byte[received.length];
		payload[0] = (byte) received.length;
		for (int i = 1; i < received.length; i++) {
			payload[i] = received[i];
		}
//		throw new RuntimeException("not yet implemented");

	}
}
