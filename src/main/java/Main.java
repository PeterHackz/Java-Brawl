package com.java.brawl.sb;

import com.java.brawl.sb.Utils.Logger;
import com.java.brawl.sb.Network.Server;
import com.java.brawl.sb.CsvReader.CsvReader;

public class Main {
	public static void main(String[] args) {
		Server server = new Server();
		CsvReader CsvNode = new CsvReader();
		CsvNode.init("Assets/");
		server.config(9339, CsvNode);
		server.Listen();
	}
}
