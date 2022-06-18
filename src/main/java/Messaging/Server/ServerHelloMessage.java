package com.java.brawl.sb.Messaging.Server;
import java.io.DataOutputStream;

import com.java.brawl.sb.Sessions.PlayerSession;
import com.java.brawl.sb.DataStream.ByteStream;
import com.java.brawl.sb.Utils.createMessage;

public class ServerHelloMessage extends ByteStream {

	private PlayerSession player;
	private ByteStream stream;
	private DataOutputStream writer;

	private int type = 20100, 
				version = 0;

	public ServerHelloMessage(PlayerSession plr, DataOutputStream Writer) {
		
		super(28);
		this.writer = Writer;
		this.player = plr;

	}

	public void encode() {

		this.writeInt(24);
		for (var index = 0; index < 24; index++) {
			this.writeByte(0xFF);
		}

		new createMessage(type, version, this.getBytes()).send(this.writer);

	}

}
