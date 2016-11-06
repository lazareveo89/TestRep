package com.test.filestatistics.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectToDb {
	private static Properties props = new Properties();
	private static File file = new File("./config/config.properties");
	
	public static Connection getConnection() throws IOException, SQLException {
		FileInputStream fis = new FileInputStream(file);
		props.load(fis);
		Connection conn = DriverManager.getConnection(
				props.getProperty("jdbc.url"),
				props.getProperty("jdbc.username"),
				props.getProperty("jdbc.password"));
		return conn;
	}
}