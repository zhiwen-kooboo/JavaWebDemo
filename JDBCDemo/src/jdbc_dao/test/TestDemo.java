package jdbc_dao.test;

import jdbc_dao.dao.PersonDao;
import jdbc_dao.dao.impl.PersonDaoImpl;
import jdbc_dao.javaBeans.Person;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class TestDemo {
	
	@org.junit.Test
	public void testFindAll() {
		PersonDao dao = new PersonDaoImpl();
		ArrayList<Person> persons = null;
		try {
			persons = dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext(); ) {
			Person next = iterator.next();
			System.out.println(next.getId() + "__" + next.getName() + "__" + next.getAge());
		}
		
		Assert.assertNotEquals(0, persons.size());
	}
}
