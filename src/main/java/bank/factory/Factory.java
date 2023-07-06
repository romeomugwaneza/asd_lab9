package bank.factory;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Factory {
    private IFactory factory;

    public Factory() {
        try (InputStream input = getClass().getResourceAsStream("/config.properties")) {
            if (input == null) {
                throw new FileNotFoundException("config.properties file not found");
            }
            Properties prop = new Properties();
            prop.load(input);

            String environment = prop.getProperty("environment");
            if (environment == null) {
                throw new IllegalStateException("environment property not set");
            }
            if (environment.equals("production")) {
                factory = new ProductionFactory();
            } else if (environment.equals("test")) {
                factory = new MockFactory();
            } else {
                throw new IllegalArgumentException("Invalid environment value: " + environment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public IFactory getFactoryInstance(){
        return  factory;
    }
}
