package no.hvl.dat110.rpc;

import java.util.Arrays;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length()];

		encoded[0] = rpcid;
		for (int i = 1; i < str.length() - 1; i++) {
			encoded[i] = (byte) str.charAt(i);
		}

		// TODO: marshall RPC identifier and string into byte array

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = null;

		// TODO: unmarshall String contained in data into decoded
		for (int i = 1; i < data.length; i++) {
//			data[i]
		}

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		// TODO: marshall RPC identifier in case of void type

		if (true) {
			throw new RuntimeException("not yet implemented");
		}

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

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array

		if (true) {
			throw new RuntimeException("not yet implemented");
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data

		if (true) {
			throw new RuntimeException("not yet implemented");
		}

		return decoded;

	}
}
