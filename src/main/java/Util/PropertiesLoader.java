package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {


        public static Properties loadProperties(String filePath) {
            Properties properties = new Properties();
            try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                properties.load(fileInputStream);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException("Properties file not found: " + filePath, ex);
            } catch (IOException ex) {
                throw new RuntimeException("Error loading properties from file: " + filePath, ex);
            }
            return properties;
        }
    }



