package br.com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDB {
	public Properties getPropertiesDB() {
		
		Properties properties = new Properties();
		
		String fileDbProperties = "db.properties";
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileDbProperties);
	
		try{
			properties.load(inputStream);
		}
		catch(IOException error){
			throw new RuntimeException(error);
		}
		
		return properties;
	}
}
