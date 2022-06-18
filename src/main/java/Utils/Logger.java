package com.java.brawl.sb.Utils;

public class Logger {
	public void color(String c, String output) {
		String a = "";
		String reset = "\033[0;37m";
		if (c == "red") {
			a = "\033[0;31m";
		} else if (c == "blue") {
			a = "\033[0;34m";
		} else if (c == "purple") {
			a = "\033[0;35m";
		} else if (c == "yellow") {
			a = "\033[0;33m";
		} else if (c == "cyan") {
			a = "\033[0;36m";
		} else if (c == "green") {
			a = "\033[0;32m";
		} else if (c == "white") {
			a = "\033[0;37m";
		}
		System.out.println(
			a + output + reset
		);
	}
	public void debug(String a1) {
		color("red", a1);
	}
}
