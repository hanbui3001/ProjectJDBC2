package com.javaweb.util;

public class StringUtil {
	private String string;
	public static boolean checkString(String string) {
		if(string != null && !string.equals("")) {
			return true;
		}
		return false;
	}
}
