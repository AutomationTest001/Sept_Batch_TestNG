package com.itview.extraconcepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadFromPropertiesFiles {

	public static void main(String[] args) throws Exception {

		
		FileInputStream fi=new FileInputStream(".\\Configuration\\config.properties");
		
		Properties prop=new Properties();
		
		prop.load(fi);
		
		String read_url_education=prop.getProperty("url_education");
		String read_url_carHomeLoan=prop.getProperty("url_carHomeLoan");		
		String read_browser=prop.getProperty("browser");
		
		System.out.println(read_url_education);
		System.out.println(read_browser);
		System.out.println(read_url_carHomeLoan);
		
		fi.close();
		
		

	}

}
