package com.naulitraders.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class EnvironmentUtil {

	private EnvironmentUtil() {

	}
	
	private static Properties properties;
	
	static {
		// load the properties file from {workDir}/conf/application.properties
		File file = new File(EnvironmentUtil.getWorkDirectoryPath() + "/conf/application.properties");
		
		try (InputStream in = new FileInputStream(file)) {
			properties = new Properties();
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getWorkDirectoryPath() {
		// System.getEnv returns environment variables like PATH
		return System.getProperty("workDir");
	}

	public static String getPropertyValue(String propertyKey) {
		return properties.getProperty(propertyKey);
	}

}
