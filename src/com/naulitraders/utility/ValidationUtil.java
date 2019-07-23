package com.naulitraders.utility;

public final class ValidationUtil {
	
	public static void validateNullOrEmpty(String name, String value) {
		if(value == null || value.trim() == "") {
			throw new IllegalArgumentException(name + " cannot be empty");
		}
	}

}
