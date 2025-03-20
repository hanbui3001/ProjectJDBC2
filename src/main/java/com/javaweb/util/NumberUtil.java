package com.javaweb.util;

public class NumberUtil {
	public static boolean checkNumber(String value) {
		try {
			Long check = Long.parseLong(value);
		}catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
}
