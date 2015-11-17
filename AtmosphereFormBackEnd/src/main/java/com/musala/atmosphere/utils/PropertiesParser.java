package com.musala.atmosphere.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesParser {
	private static String workingDir = System.getProperty("user.dir");

	private static String separator = System.getProperty("file.separator");
	private static String defaulthPath = workingDir + separator + "videos"
			+ separator;
	private static String propertiesFile = workingDir + separator
			+ "pathConfig.properties";

	public static void setPropertyFile() {
		File configFile = new File(propertiesFile);
		File defaultDirectory = new File(defaulthPath);
		defaultDirectory.mkdir();
		try {
			if (!configFile.exists()) {
	
				configFile.createNewFile();
			
				Properties properties = new Properties();
				properties.setProperty("path", defaulthPath);
				FileOutputStream fileOut = new FileOutputStream(configFile);
				properties.store(fileOut,
						"Cofiguration for path in file system for videos");
				fileOut.close();	
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static String getVideoPath() {
		setPropertyFile();
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(propertiesFile);
			prop.load(input);	

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty("path");
	}
}
