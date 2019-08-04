package com.naulitraders.utility;

public final class EnvironmentUtil {
	
	private EnvironmentUtil() {
		
	}
	
	public static String getWorkDirectoryPath() {
		// System.getEnv returns environment variables like PATH
		return System.getProperty("workDir");
	}

}

