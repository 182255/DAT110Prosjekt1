package no.hvl.dat110.messaging;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection {

	private DataOutputStream outStream; // for writing bytes to the TCP connection
	private DataInputStream inStream; // for reading bytes from the TCP connection
	private Socket socket; // socket for the underlying TCP connection

	public Connection(Socket socket) {

		try {

			this.socket = socket;

			inStream = new DataInputStream(socket.getInputStream());

			outStream = new DataOutputStream(socket.getOutputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {

		// TODO
		// encapsulate the data contained in the message and write to the output stream
		try {
			outStream.write(message.encapsulate(), 0, 128);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public Message receive() {

		byte[] recvbuf = new byte[128];
		Message message = new Message();

		// TODO
		// read a segment from the input stream and decapsulate into message
		try {
			inStream.read(recvbuf, 0, 128);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message.decapsulate(recvbuf);

		return message;

	}

	// close the connection by closing streams and the underlying socket
	public void close() {

		try {

			outStream.close();
			inStream.close();

			socket.close();
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}