package jdbc.util;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	static String driver_class = null;
	static String mysql_url = null;
	static String mysql_user = null;
	static String mysql_password = null;
	
	static {
		// 1、创建一个属性配置对象
		Properties prop = new Properties();
		InputStream is = null;
		is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		// 2、导入输入流
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver_class = prop.getProperty("DRIVER_CLASS");
		mysql_url = prop.getProperty("MYSQL_URL");
		mysql_user = prop.getProperty("MYSQL_USER");
		mysql_password = prop.getProperty("MYSQL_PASSWORD");
	}
	
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		// 1、注册jdbc驱动
		// Class.forName(driver_class);
		
		// 2、连接数据库
		return DriverManager.getConnection(
				mysql_url,
				mysql_user,
				mysql_password);
	}
}
