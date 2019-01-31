package no.hvl.dat110.messaging;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	// connect to messaging server
	public Connection connect() {

		Socket clientSocket;
		Connection connection = null;

		// TODO
		// create TCP socket for client and connection

		try {
			clientSocket = new Socket(server, port);
			connection = new Connection(clientSocket);	
//			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
//			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			

		} catch (Exception e) {
			e.printStackTrace();
		}

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return connection;
	}
}
