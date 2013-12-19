package com.study.gg.transaction.Servicescommon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesNetwork {
	static Properties prop = new Properties();
	public static String getTransacAddr() throws FileNotFoundException, IOException
	{
		prop.load(new FileInputStream("network.properties"));
		return prop.getProperty("addrtransact");
	}
	public static void setTransacAddresse(String host)throws FileNotFoundException, IOException{
		prop.load(new FileInputStream("network.properties"));
		prop.setProperty("addrtransact", host);
	}
}
