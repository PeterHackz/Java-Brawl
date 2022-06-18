package com.java.brawl.sb.Messaging.Client;

import java.io.DataOutputStream;

import com.java.brawl.sb.Sessions.PlayerSession;

import com.java.brawl.sb.DataStream.ByteStream;
import com.java.brawl.sb.Messaging.Server.ServerHelloMessage;

public class ClientHelloMessage extends ByteStream {
	
	private PlayerSession player;
	private DataOutputStream writer;

	public ClientHelloMessage(PlayerSession plr,  byte[] payload, DataOutputStream Writer) {
		
		super(payload);
		this.writer = Writer;
		this.player = plr;

	}

	public ClientHelloMessage decode() {
		return this;
	}

	public void process() {

		new ServerHelloMessage(this.player, this.writer).encode();
	}
}
