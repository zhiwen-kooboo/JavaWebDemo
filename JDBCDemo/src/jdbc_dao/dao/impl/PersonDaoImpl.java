package jdbc_dao.dao.impl;

import jdbc_dao.dao.PersonDao;
import jdbc_dao.javaBeans.Person;
import jdbc_dao.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

public class PersonDaoImpl implements PersonDao {
	@Override
	public ArrayList<Person> findAll() throws SQLException {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement statement = null;
		var persons = new ArrayList<Person>();
		
		try {
			statement = conn.prepareStatement("select * from person where id > ?");
			statement.setInt(1, 3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet resultSet = statement.executeQuery();
		
		
		while (resultSet.next()) {
			var person = new Person();
			person.setId(resultSet.getInt("id"));
			person.setName(resultSet.getString("name"));
			person.setAge(resultSet.getInt("age"));
			
			persons.add(person);
		}
		
		return persons;
	}
}
