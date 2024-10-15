package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfiguration {
	private  Properties properties;
	private final String propertyFilePath = "configs//database.properties";

	public DatabaseConfiguration() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("database.properties not found at " + propertyFilePath);
		}
	}
	public String getDatabaseUserName() {
		String databaseUserName = properties.getProperty("databaseUserName");
		if (databaseUserName.length()>0)
			return databaseUserName;
		else
			throw new RuntimeException("database UserName not specified in the database.properties file.");
	}
	public String getDatabasePassword() {
		String databasePassword = properties.getProperty("databasePassword");
		if (databasePassword.length()>0)
			return databasePassword;
		else
			throw new RuntimeException("database Password not specified in the database.properties file.");
	}
	public String getDatabaseURL() {
		String databaseURL = properties.getProperty("databaseURL");
		if (databaseURL.length()>0)
			return databaseURL;
		else
			throw new RuntimeException("database URL not specified in the database.properties file.");
	}
	public String getOptName() {
		String optName = properties.getProperty("optName");
		if (optName.length()>0)
			return optName;
		else
			throw new RuntimeException("opt name not specified in the database.properties file.");
	}
	public String getOptNamePrefix() {
		String optNamePrefix = properties.getProperty("idAttributePrefix");
		if (optNamePrefix.length()>0)
			return optNamePrefix;
		else
			throw new RuntimeException("opt name prefix not specified in the database.properties file.");
	}
	
	public String getOptNamePrefix2() {
		String optNamePrefix = properties.getProperty("idAttributePrefix2");
		if (optNamePrefix.length()>0)
			return optNamePrefix;
		else
			throw new RuntimeException("opt name prefix not specified in the database.properties file.");
	}

}
