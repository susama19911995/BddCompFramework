package Properties;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyConfig {

	static Properties prop = new Properties();
	public static String readProperty(String key) throws Exception {
		FileInputStream input = new FileInputStream("F:\\PWCTestProject\\oyoHotelBooking\\src\\test\\java\\Properties\\test1.properties");
		
		prop.load(input);
		
		return prop.get(key).toString();
	}

}
