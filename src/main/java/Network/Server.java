package com.java.brawl.sb.Network;

import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import com.java.brawl.sb.Utils.Logger;
import com.java.brawl.sb.CsvReader.CsvReader;
import com.java.brawl.sb.Sessions.ClientSession;

public class Server {

	public int serverPort;
	public CsvReader CsvNode;
	public void config(int port, CsvReader CsvNode) {
		serverPort = port;
		this.CsvNode = CsvNode;
	}

	public void Listen() {
		Logger console = new Logger();
		try {

			ServerSocket server = new ServerSocket(serverPort);

			console.color(
				"white", "[socket] server listening on port: " + serverPort
			);
			while (server.isBound()) {
				Socket client = server.accept();
				new Thread(() -> {
					console.color(
						"cyan", "[socket] new connection: " + client.getRemoteSocketAddress()
					);
					new ClientSession(client, this.CsvNode).createSession();
				}).start();
				
			}
		} catch (IOException e) {
			console.color(
				"red", "[error] failed in creating the socket server: " + e.getMessage()
			);
		}
	}
}
