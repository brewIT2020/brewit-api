package pl.brewit.common.utils;

import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Properties;

@Singleton
public class AppPropertiesUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(AppPropertiesUtil.class);
  private static final String PROPERTIES_LOADING_ERROR = "Properties Loaded incorrectly!";

  private Properties properties;

  public AppPropertiesUtil() {
    properties = new Properties();
    ClassLoader classLoader = AppPropertiesUtil.class.getClassLoader();
    try (BufferedInputStream in =
        (BufferedInputStream) classLoader.getResourceAsStream("application.properties")) {
      properties.load(in);
      LOGGER.info(properties.getProperty("default.test.welcome", PROPERTIES_LOADING_ERROR));
    } catch (IOException e) {
      LOGGER.error("Can't load properties from 'application.properties' file");
    }
  }

  public String getValue(String key) {
    return properties.getProperty(key);
  }

  public String getValueElseDefault(String key, String defaultValue) {
    return properties.getProperty(key, defaultValue);
  }
}
