package HelperResources;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop = new Properties();
	
    public static void main(String[] args) {
        loadFile();
    }

	protected static Properties loadFile() {
        FileInputStream input = null;

        try {
            input = new FileInputStream("src\\config.properties");
            prop.load(input);

            // Do something with the retrieved values

            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}