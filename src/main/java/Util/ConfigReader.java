package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static private Properties properties = null;
    static private final String propertyFilePath= "configs//configurations.properties";

    public ConfigReader(){

    }

    static{
        if(properties == null) {
            loadPropertyFile();
        }
    }

    private static void loadPropertyFile() {
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
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public static String getProperty(String propertyName)
    {
        return properties.getProperty(propertyName);
    }
}
