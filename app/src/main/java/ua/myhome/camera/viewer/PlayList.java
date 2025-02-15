package ua.myhome.camera.viewer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PlayList {
    private static final Properties properties = new Properties();

    public PlayList() throws IOException {
        InputStream appProperties = getClass().getClassLoader().getResourceAsStream("application.properties");
        properties.load(appProperties);
    }

    public Set<String> getProperties() {
        return properties.stringPropertyNames();
    }

    public String getPropertyValue(String property) {
        return properties.getProperty(property);
    }
}
