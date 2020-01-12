package testngDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	public static Properties prop;
	
	public static Properties ReadPropertyFile(String path)
	{
		try {
		File file =new File(path);
		FileInputStream fis =new FileInputStream(file);
		prop=new Properties();
		prop.load(fis);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}

}
