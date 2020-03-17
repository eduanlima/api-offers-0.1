package br.com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDB {
	public Properties getPropertiesDB() {
		
		Properties properties = new Properties();
		
		String fileDbProperties = "src/resources/db.properties";
		
		try{
			InputStream inputStream = new FileInputStream(fileDbProperties);
			properties.load(inputStream);
		}
		catch(IOException error){
			throw new RuntimeException(error);
		}
		
		return properties;
	}
}
