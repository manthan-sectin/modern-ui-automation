package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;
	private final String propertyFilePath = "src/test/resources/config/config.properties";

	public ConfigReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getBaseUrl() {
		String url = properties.getProperty("baseUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("baseUrl not specified in the Configuration.properties file.");
	}

	public String getBrowser() {
		String browser = properties.getProperty("browser");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}

	public Boolean getHeadless() {
		String headless = properties.getProperty("headless");
		if (headless != null)
			return Boolean.parseBoolean(headless);
		return false;
	}
//
//	public long getTimeout() {
//		String timeout = properties.getProperty("timeout");
//		if (timeout != null)
//			return Long.parseLong(timeout);
//		else
//			throw new RuntimeException("timeout not specified in the Configuration.properties file.");
//	}
}