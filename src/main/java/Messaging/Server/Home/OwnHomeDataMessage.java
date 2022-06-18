package com.java.brawl.sb.Messaging.Server.Home;

import java.io.DataOutputStream;

import com.java.brawl.sb.Sessions.PlayerSession;
import com.java.brawl.sb.DataStream.ByteStream;
import com.java.brawl.sb.Utils.createMessage;
import com.java.brawl.sb.Utils.EventsManager;

public class OwnHomeDataMessage extends ByteStream {

	private PlayerSession player;
	private DataOutputStream writer;

	private int type = 24101,
				version = 0;

	public OwnHomeDataMessage(PlayerSession plr, DataOutputStream Writer) {

		super(5000);
		this.writer = Writer;
		this.player = plr;

	}

	public void encode() {

		this.writeVInt(0);
		this.writeVInt(0);

		this.writeVInt(15000); // Trophies
		this.writeVInt(15000); // Highest Trophies

		this.writeVInt(0);
		this.writeVInt(95); // unlocked trophy road rewards
		this.writeVInt(99999); // exp

		this.writeDataReference(28, 0); // Profile Icon id
		this.writeDataReference(43, 0); // Player name color id

		this.writeVInt(0);

		this.writeVInt(1); // Selected skins array
		this.writeDataReference(29, this.player.skin_id);

		this.writeVInt(this.player.csv.getSkinsCount()); // Unlocked skins array
		for (int ID : this.player.csv.getSkinsIDs()) {
			this.writeDataReference(29, ID);
		}

		this.writeVInt(0);
		this.writeVInt(0);
		this.writeVInt(0);

		this.writeBoolean(false);
		this.writeVInt(1);
		this.writeBoolean(true);

		this.writeVInt(0); // token doubler count
		this.writeVInt(3600); // season end timer

		this.writeVInt(0);
		this.writeVInt(0);
		this.writeVInt(0);
		this.writeVInt(0);
		this.writeByte(8);

		this.writeBoolean(false);
		this.writeBoolean(false);
		this.writeBoolean(false);

		this.writeVInt(0); // change name cost
		this.writeVInt(0); // time left to change name

		this.writeVInt(0); // shop array
		this.writeVInt(0);
		this.writeVInt(200); // Battle Tokens
		this.writeVInt(0);

		this.writeVInt(0);

		this.writeVInt(99999); // Tickets count

		this.writeVInt(0);

		this.writeDataReference(16, this.player.brawler_id); // Selected Brawler

		this.writeString("LB"); // region
		this.writeString("S.B"); // supported cc

		this.writeVInt(0);
		this.writeVInt(0);
		this.writeVInt(0);
		this.writeVInt(0);

		this.writeVInt(2019049);
		this.writeVInt(100); // Tokens for a brawl box
		// SHOP BRAWL BOX
		this.writeVInt(10);
		// SHOP BIGBOX
		this.writeVInt(30);
		this.writeVInt(3);
		// SHOP MEGABOX
		this.writeVInt(80);
		this.writeVInt(10);
		// SHOP TOKENDOUBLER
		this.writeVInt(50);
		this.writeVInt(1000);

		this.writeVInt(500);

		this.writeVInt(50);
		this.writeVInt(999900);

		this.writeVInt(1);
		this.writeVInt(1);

		int[][] events = EventsManager.events;

		// event slots ids
		this.writeVInt(events.length + 1);
		for (int x = 0; x < events.length + 1 ; x++) {
			this.writeVInt(x);
		}
		// end

		// EventSlots
		this.writeVInt(events.length); // count
		for (int index = 0; index < events.length; index++) {
			this.writeVInt(index + 1);
			this.writeVInt(index + 1); // index
			this.writeVInt(0); // new event timer
			this.writeVInt(99999); // timer
			this.writeVInt(0); // New event reward ammount
			this.writeDataReference(15, events[index][0]); // map ID
			this.writeVInt(3); // status
			this.writeString();
			this.writeVInt(0);
			this.writeVInt(0); // pp game played
			this.writeVInt(0); // pp games left
			this.writeVInt(events[index].length - 1); // Modifiers count
			for (int m  = 1; m < events[index].length; m++) {
				this.writeVInt(events[index][m]); // Modifier ID
			}
			this.writeVInt(16); // special event difficulty level
		}
		// end
		this.writeVInt(0); // next event slots array
		// shop
		this.writeVInt(8);
		int[] i_1 = {20, 35, 75, 140, 290, 480, 800, 1250};
		for (int i : i_1) {
			this.writeVInt(i);
		}
		this.writeVInt(8);
		int[] i_2 = {1, 2, 3, 4, 5, 10, 15, 20};
		for (int i : i_2) {
			this.writeVInt(i);
		}
		this.writeVInt(3);
		int[] i_3 = {10, 30, 80};
		for (int i : i_3) {
			this.writeVInt(i);
		}
		this.writeVInt(3);
		int[] i_4 = {6, 20, 60};
		for (int i : i_4) {
			this.writeVInt(i);
		}
		this.writeVInt(4);
		int[] i_5 = {20, 50, 140, 280};
		for (int i : i_5) {
			this.writeVInt(i);
		}
		this.writeVInt(4);
		int[] i_6 = {150, 400, 1200, 2600};
		for (int i : i_6) {
			this.writeVInt(i);
		}
		// end
		this.writeVInt(0);
		this.writeVInt(200);
		this.writeVInt(20);

		this.writeVInt(8640);
		this.writeVInt(10);
		this.writeVInt(5);

		this.writeVInt(6);

		this.writeVInt(50);
		this.writeVInt(604800);

		this.writeBoolean(true);

		this.writeVInt(0); // array

		this.writeVInt(1); // menu theme
		this.writeInt(1);
		this.writeInt(41000000); // theme id

		this.writeInt(this.player.high_id);
		this.writeInt(this.player.low_id);

		this.writeVInt(0); // array
		this.writeBoolean(true);
		this.writeVInt(0);
		this.writeVInt(0);
		// player data
		this.writeVInt(this.player.high_id);
		this.writeVInt(this.player.low_id);

		this.writeVInt(this.player.high_id);
		this.writeVInt(this.player.low_id);

		this.writeVInt(this.player.high_id);
		this.writeVInt(this.player.low_id);

		this.writeString("S.B"); // Player name
		this.writeVInt(1); // name state
		this.writeInt(0);
		this.writeVInt(8);

		// Unlocked Brawlers & Resources Array

		int brawlers_count = this.player.csv.getBrawlersCount();
		Integer[] brawlers_ids = this.player.csv.getBrawlersIDs();

		this.writeVInt(brawlers_count + 4);

		for (int ID : this.player.csv.getBrawlersUnlockIDs()) {
			this.writeDataReference(23, ID);
			this.writeVInt(1);
		}

		this.writeDataReference(5, 1);
		this.writeVInt(0); // brawl boxes

		this.writeDataReference(5, 8);
		this.writeVInt(99999); // gold

		this.writeDataReference(5, 9);
		this.writeVInt(0); // big boxes

		this.writeDataReference(5, 10);
		this.writeVInt(99999); // star points

		// Brawlers Trophies array
		this.writeVInt(brawlers_count);
		for (int ID : brawlers_ids) {
			this.writeDataReference(16, ID);
			this.writeVInt(99999);
		}

		// Brawlers Rank Trophies array
		this.writeVInt(brawlers_count);
		for (int ID : brawlers_ids) {
			this.writeDataReference(16, ID);
			this.writeVInt(99999);
		}

		this.writeVInt(0);

		// Brawlers PowerPoints array
		this.writeVInt(brawlers_count);
		for (int ID : brawlers_ids) {
			this.writeDataReference(16, ID);
			this.writeVInt(0);
		}

		// Brawlers levels array
		this.writeVInt(brawlers_count);
		for (int ID : brawlers_ids) {
			this.writeDataReference(16, ID);
			this.writeVInt(8);
		}

		// unlocked/selected special abilities array
		this.writeVInt(this.player.csv.getBrawlersSpecialAbilitiesCount());
		for (int ID : this.player.csv.getBrawlersSpecialAbilitiesIDs()) {
			this.writeDataReference(23, ID);
			if (ID == this.player.sp_id) {
				this.writeVInt(2);
			} else {
				this.writeVInt(1);
			}
		}

		this.writeVInt(0);

		this.writeVInt(99999); // gems
		this.writeVInt(0);
		this.writeVInt(1);
		for (int i = 0; i < 8; i++) {
			this.writeVInt(0);
		}
		this.writeVInt(2); // Tutorial state
		this.writeVInt(0);

		new createMessage(type, version, this.getBytes()).send(this.writer);

	}

}
