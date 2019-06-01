package jdbc.test;

import jdbc.util.JDBCUtil;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 * 使用jUnit进行单元测试
 */

public class TestUTDemo {
	
	@org.junit.Test
	public void testQuery() {
		try {
			Connection conn = JDBCUtil.getConn();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from person");
			
			while (resultSet.next()) {
				var id = resultSet.getInt("id");
				var name = resultSet.getString("name");
				var age = resultSet.getInt("age");
				
				System.out.println(id + " " + name + " " + age);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Assert.assertNull(null);
	}
	
	@org.junit.Test
	public void testInsert() {
		try {
			Connection conn = JDBCUtil.getConn();
			Statement statement = conn.createStatement();
			
			var calendar = Calendar.getInstance();
			var second = calendar.get(Calendar.SECOND);
			int rows = statement.executeUpdate("INSERT INTO person VALUES(null," + second + ",23)");
			
			System.out.println("插入影响行数为:" + rows);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void testDelete() {
		try {
			Connection conn = JDBCUtil.getConn();
			Statement statement = conn.createStatement();
			
			int rows = statement.executeUpdate("DELETE from person where id = 2");
			
			System.out.println("删除影响行数为:" + rows);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void testUpdate() {
		try {
			Connection conn = JDBCUtil.getConn();
			Statement statement = conn.createStatement();
			
			var calendar = Calendar.getInstance();
			var second = calendar.get(Calendar.SECOND);
			int rows = statement.executeUpdate("update person set name='测试更新" + second + "' where id = 10");
			
			System.out.println("更新影响行数为:" + rows);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
