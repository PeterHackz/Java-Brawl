package com.java.brawl.sb.Sessions;

import com.java.brawl.sb.CsvReader.CsvReader;

public class PlayerSession {
	
	public int high_id, low_id, map_id, sp_id, brawler_id, skin_id;
	
	public String token, name;
	public CsvReader csv;
	
	public PlayerSession(CsvReader CsvNode) {
		this.name = "";
		this.token = "";
		this.low_id = 0;
		this.high_id = 0;
		this.brawler_id = 0;
		this.csv = CsvNode;
		this.sp_id = this.csv.getSpecialAbilityIDByBrawlerID(this.brawler_id);
		this.skin_id = this.csv.getSkinIDByBrawlerID(this.brawler_id);
	}
	
}
