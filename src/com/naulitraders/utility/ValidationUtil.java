package com.naulitraders.utility;

public final class ValidationUtil {

	public static void validateNullOrEmpty(String name, String value) {
		if (value == null || value.trim() == "") {
			throw new IllegalArgumentException(name + " cannot be empty");
		}
	}

	public static void validatePhoneNumber(long number) {
		int count = 0;
		while (number != 0) {
			number = number / 10;
			++count;
		}
		if (count != 10) {
			throw new IllegalArgumentException("The phone number should be of 10 digits");
		}
	}
	
	public static void validateVehNumber(String vehNum) {
		if (vehNum == null || vehNum.trim() == "") {
			throw new IllegalArgumentException(vehNum + " cannot be empty");
		}
	}

}
