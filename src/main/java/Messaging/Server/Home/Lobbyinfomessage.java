package com.java.brawl.sb.Messaging.Server.Home;

import java.io.DataOutputStream;

import java.lang.Thread;

import com.java.brawl.sb.Sessions.PlayerSession;
import com.java.brawl.sb.DataStream.ByteStream;
import com.java.brawl.sb.Utils.createMessage;

public class LobbyInfoMessage extends ByteStream {

	private PlayerSession player;
	private ByteStream stream;
	private DataOutputStream writer;

	private int type = 23457, 
				version = 0;

	public LobbyInfoMessage(PlayerSession plr, DataOutputStream Writer) {
		
		super(100);
		this.writer = Writer;
		this.player = plr;

	}

	public void encode() {

		this.writeVInt(Thread.activeCount() - 1);
		this.writeString("Java-Brawl");
		this.writeVInt(0);

		new createMessage(type, version, this.getBytes()).send(this.writer);

	}

}
