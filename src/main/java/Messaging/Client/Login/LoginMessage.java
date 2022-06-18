package com.java.brawl.sb.Messaging.Client.Login;

import java.io.DataOutputStream;

import com.java.brawl.sb.Sessions.PlayerSession;
import com.java.brawl.sb.DataStream.ByteStream;
import com.java.brawl.sb.Messaging.Server.Login.LoginOkMessage;
import com.java.brawl.sb.Messaging.Server.Home.OwnHomeDataMessage;

public class LoginMessage extends ByteStream {

	private ByteStream stream;
	private PlayerSession player;
	private DataOutputStream writer;

	public LoginMessage(PlayerSession plr,  byte[] payload, DataOutputStream Writer) {
		
		super(payload);
		this.writer = Writer;
		this.player = plr;

	}

	public LoginMessage decode() {

		this.player.high_id = this.readInt();
		this.player.low_id = this.readInt();
		this.player.token = this.readString();

		// change this part if you're going to make a database.
		this.player.high_id = 0;
		this.player.low_id = 1;
		this.player.token = "token";

		return this;
	}

	public void process() {

		new LoginOkMessage(this.player, this.writer).encode();

		new OwnHomeDataMessage(this.player, this.writer).encode();

	}
}
