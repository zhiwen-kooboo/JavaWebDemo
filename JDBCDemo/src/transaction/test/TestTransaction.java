package transaction.test;

import jdbc_dao.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction {
	@Test
	public void testFirst() throws SQLException {
		Connection conn = JDBCUtil.getConn();
		
		// 关闭自动提交
		conn.setAutoCommit(false);
		String sql = "select * from person";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		conn.commit();
		conn.rollback();
		while (rs.next()) {
			System.out.println(rs.getString("name") + "__" + rs.getInt("age"));
		}
	}
	
}
