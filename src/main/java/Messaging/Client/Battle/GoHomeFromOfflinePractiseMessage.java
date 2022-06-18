package com.java.brawl.sb.Messaging.Client.Battle;

import java.io.DataOutputStream;

import com.java.brawl.sb.Sessions.PlayerSession;

import com.java.brawl.sb.DataStream.ByteStream;
import com.java.brawl.sb.Messaging.Server.Home.OwnHomeDataMessage;

public class GoHomeFromOfflinePractiseMessage extends ByteStream {

	private PlayerSession player;
	private DataOutputStream writer;

	public GoHomeFromOfflinePractiseMessage(PlayerSession plr,  byte[] payload, DataOutputStream Writer) {
		
		super(payload);
		this.writer = Writer;
		this.player = plr;

	}

	public GoHomeFromOfflinePractiseMessage decode() {
		return this;
	}

	public void process() {

		new OwnHomeDataMessage(this.player, this.writer).encode();
	}
}
