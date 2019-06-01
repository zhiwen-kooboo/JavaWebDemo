package jdbc.test;

import jdbc.util.JDBCUtil;

import java.sql.*;

public class MainTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String a = "1";
		try {
			// 1、获取连接连接
			conn = JDBCUtil.getConn();
			
			// 2、创建statement
			statement = conn.createStatement();
			
			// 3、执行查询
			resultSet = statement.executeQuery("select * from person");
			
			// 4、遍历出所有数据
			while (resultSet.next()) {
				var id = resultSet.getInt("id");
				var name = resultSet.getString("name");
				var age = resultSet.getInt("age");
				
				System.out.println(id + "__" + name + "__" + age);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5、关闭资源
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
