package jdbc_dao.dao;

import jdbc_dao.javaBeans.Person;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PersonDao {
	ArrayList<Person> findAll() throws SQLException;
}
