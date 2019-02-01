package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length()];

		// TODO: marshall RPC identifier and string into byte array
		encoded[0] = rpcid;
		for (int i = 0; i < encoded.length; i++) {
			encoded[i] = (byte) str.charAt(i);
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = new String(data);
		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[128];
		// TODO: marshall RPC identifier in case of void type
		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		// TODO: marshall RPC identifier and string into byte array
		byte[] encoded = new byte[4];
		encoded = ByteBuffer.allocate(4).putInt(x).array();
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data

		decoded = ByteBuffer.wrap(data).getInt();

		return decoded;

	}
}
