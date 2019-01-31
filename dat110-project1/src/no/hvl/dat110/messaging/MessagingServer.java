package no.hvl.dat110.messaging;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MessagingServer {

	private ServerSocket welcomeSocket;
	private Socket connectSocket;

	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// accept an incoming connection from a client
	public Connection accept() {

		Connection connection = null;

		// TODO
		// accept TCP connection on welcome socket and create connection
		try {
			connectSocket = welcomeSocket.accept();
			connection = new Connection(connectSocket);
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectSocket.getOutputStream());
			
			inFromClient.readLine();
			outToClient.flush();
			outToClient.close();
			inFromClient.close();
//			connectSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return connection;

	}

	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
