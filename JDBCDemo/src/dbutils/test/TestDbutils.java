package dbutils.test;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class TestDbutils {
	@Test
	public void testQuery() {
		
	}
	
	@Test
	public void testInsert() throws SQLException {
		// dbUtils只是帮我们简化了CRUD，但是连接的创建还需要我们自己来
		
		QueryRunner queryRunner = new QueryRunner();
		
		// 查
		var query = queryRunner.query("", null);
		
		// 增删改
		queryRunner.update("");
	}
}
