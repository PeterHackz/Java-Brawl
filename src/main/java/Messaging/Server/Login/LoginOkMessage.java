package com.java.brawl.sb.Messaging.Server.Login;
import java.io.DataOutputStream;

import com.java.brawl.sb.Sessions.PlayerSession;
import com.java.brawl.sb.DataStream.ByteStream;
import com.java.brawl.sb.Utils.createMessage;

public class LoginOkMessage extends ByteStream {

	private PlayerSession player;
	private ByteStream stream;
	private DataOutputStream writer;

	private int type = 20104,
				version = 1;

	public LoginOkMessage(PlayerSession plr, DataOutputStream Writer) {

		super(50);
		this.writer = Writer;
		this.player = plr;

	}

	public void encode() {

		this.writeInt(this.player.high_id);
		this.writeInt(this.player.low_id);

		this.writeInt(this.player.high_id);
		this.writeInt(this.player.low_id);

		this.writeString(this.player.token);

		new createMessage(type, version, this.getBytes()).send(this.writer);

	}

}
