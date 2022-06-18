package com.java.brawl.sb.CsvReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CsvReader {

	HashMap<String, HashMap<Integer, HashMap<String, String>>> CsvData;

	public CsvReader() {
		this.CsvData = new HashMap<>();
	}

	public void loadCSV(String name, String path) {
		HashMap<Integer, HashMap<String, String>> map = new HashMap<>();
		String line = "";
		HashMap<Integer, String> header = new HashMap<>();
		int index = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(path)));
			while ((line = br.readLine()) != null) {
				if (index == 0) {
					String[] data = line.replace("\"", "").split(",");
					for (int i = 0; i < data.length; i++) {
						header.put(i, data[i]);
					}
				} else if (index > 1) {
					String[] data = line.replace("\"", "").split(",");
					HashMap<String, String> content = new HashMap<>();
					for (int i = 0; i < data.length; i++) {
						if (data[i].length()  == 0) {
							data[i] = "None";
						}
						content.put(header.get(i), data[i]);
					}
					map.put(index - 2, content);
				}
				index += 1;
			}
			this.CsvData.put(name, map);
		} catch (IOException e) {
			System.out.println("error while loading csv: " + name + "\n" + e.getMessage());
			System.exit(0);
		}
		System.out.println("[assets] loaded " + name);
	}

	public int getBrawlersCount() {
		int result = 0;
		for (int i = 0; i < this.CsvData.get("characters").size(); i++) {
			if (this.CsvData.get("characters").get(i).get("Type").equals("Hero")) {
				if (!this.CsvData.get("characters").get(i).get("Disabled").toLowerCase().equals("true") && !this.CsvData.get("characters").get(i).get("LockedForChronos").toLowerCase().equals("true")) {
					result += 1;
				}
			}
		}
		return result;
	}

	public Integer[] getBrawlersIDs() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < this.CsvData.get("characters").size(); i++) {
			if (this.CsvData.get("characters").get(i).get("Type").equals("Hero")) {
				if (!this.CsvData.get("characters").get(i).get("Disabled").toLowerCase().equals("true") && !this.CsvData.get("characters").get(i).get("LockedForChronos").toLowerCase().equals("true")) {
					list.add(i);
				}
			}
		}
		Integer[] result = new Integer[list.size()];
		list.toArray(result);
		return result;
	}

	public int getBrawlerIDByName(String name) {
		int result = 0;
		for (int i = 0; i < this.CsvData.get("characters").size(); i++) {
			if (this.CsvData.get("characters").get(i).get("Name").equals(name)) {
				break;
			}
			result += 1;
		}
		return result;
	}

	public HashMap<String, String> getBrawlerInfoByID(int id) {
		return this.CsvData.get("characters").get(id);
	}

	public int getSpecialAbilityIDByBrawlerID(int id) {
		String name = this.CsvData.get("characters").get(id).get("Name");
		for (int i = 0; i < this.CsvData.get("cards").size(); i++) {
			if (this.CsvData.get("cards").get(i).get("Target").equals(name) && this.CsvData.get("cards").get(i).get("MetaType").equals("4")) {
				return i;
			}
		}
		return 0;
	}
	
	public int getSkinIDByBrawlerID(int id) {
		String name = this.CsvData.get("characters").get(id).get("DefaultSkin");
		for (int i = 0; i < this.CsvData.get("skins").size(); i++) {
			if (this.CsvData.get("skins").get(i).get("Name").equals(name)) {
				return i;
			}
		}
		return 0;
	}

	public Integer[] getBrawlersSpecialAbilitiesIDs() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < this.CsvData.get("cards").size(); i++) {
			if (this.CsvData.get("cards").get(i).get("MetaType").equals("4")) {
				if (!this.CsvData.get("cards").get(i).get("LockedForChronos").toLowerCase().equals("true")) {
					HashMap<String, String> info = this.getBrawlerInfoByID(this.getBrawlerIDByName(this.CsvData.get("cards").get(i).get("Target")));
					if (!info.get("LockedForChronos").toLowerCase().equals("true") && !info.get("Disabled").toLowerCase().equals("true")) {
						list.add(i);
					}
				}
			}
		}
		Integer[] result = new Integer[list.size()];
		list.toArray(result);
		return result;
	}

	public int getBrawlersSpecialAbilitiesCount() {
		int result = 0;
		for (int i = 0; i < this.CsvData.get("cards").size(); i++) {
			if (this.CsvData.get("cards").get(i).get("MetaType").equals("4")) {
				if (!this.CsvData.get("cards").get(i).get("LockedForChronos").toLowerCase().equals("true")) {
					HashMap<String, String> info = this.getBrawlerInfoByID(this.getBrawlerIDByName(this.CsvData.get("cards").get(i).get("Target")));
					if (!info.get("LockedForChronos").toLowerCase().equals("true") && !info.get("Disabled").toLowerCase().equals("true")) {
						result += 1;
					}
				}
			}
		}
		return result;
	}

	public Integer[] getBrawlersUnlockIDs() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < this.CsvData.get("cards").size(); i++) {
			if (this.CsvData.get("cards").get(i).get("MetaType").equals("0")) {
				if (!this.CsvData.get("cards").get(i).get("LockedForChronos").toLowerCase().equals("true")) {
					HashMap<String, String> info = this.getBrawlerInfoByID(this.getBrawlerIDByName(this.CsvData.get("cards").get(i).get("Target")));
					if (!info.get("LockedForChronos").toLowerCase().equals("true") && !info.get("Disabled").toLowerCase().equals("true")) {
						list.add(i);
					}
				}
			}
		}
		Integer[] result = new Integer[list.size()];
		list.toArray(result);
		return result;
	}

	public Integer[] getSkinsIDs() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < this.CsvData.get("skins").size(); i++) {
			if (!this.CsvData.get("skins").get(i).get("Name").equals("None")) {
				list.add(i);
			}
		}
		Integer[] result = new Integer[list.size()];
		result = list.toArray(result);
		return result;
	}

	public int getSkinsCount() {
		int result = 0;
		for (int i = 0; i < this.CsvData.get("skins").size(); i++) {
			if (!this.CsvData.get("skins").get(i).get("Name").equals("None")) {
				result += 1;
			}
		}
		return result;
	}

	public void init(String path) {
		this.loadCSV("characters", path + "characters.csv");
		this.loadCSV("cards", path + "cards.csv");
		this.loadCSV("skins", path + "skins.csv");
	}
}
