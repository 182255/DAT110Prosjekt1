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

		return encoded;

	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate data in received and put in payload
		payload = new byte[received[0]];
		for (int i = 0; i < payload.length; i++) {
			payload[i] = received[i + 1];
		}

	}
}
