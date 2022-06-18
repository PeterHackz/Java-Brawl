package com.java.brawl.sb.Messaging;

import java.io.DataOutputStream;

import com.java.brawl.sb.Sessions.PlayerSession;

import com.java.brawl.sb.Messaging.Client.ClientHelloMessage;
import com.java.brawl.sb.Messaging.Client.Login.LoginMessage;
import com.java.brawl.sb.Messaging.Client.Battle.GoHomeFromOfflinePractiseMessage;

import com.java.brawl.sb.Messaging.Server.Home.LobbyInfoMessage;

public class createMessageByTypeForServer {

	public PlayerSession player;
	public Boolean state;

	public createMessageByTypeForServer(PlayerSession a1) {
		this.player = a1;
		this.state = false;
	}

	public void process(int type, byte[] payload, DataOutputStream writer) {

		switch (type) {
		case 10100:
			new ClientHelloMessage(this.player, payload, writer)
			.decode()
			.process();
			break;
		case 10101:
			new LoginMessage(this.player, payload, writer)
			.decode()
			.process();
			this.state = true;
			break;
		case 14109:
			new GoHomeFromOfflinePractiseMessage(this.player, payload, writer)
			.decode()
			.process();
			break;
		default:
			break;
		}

		if (this.state) {
			new LobbyInfoMessage(this.player, writer).encode();
		}

	}
}
