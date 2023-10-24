package com.speridian.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.speridian.entity.Address;
import com.speridian.entity.Student;
import com.speridian.exception.StudentNotFoundException;

public class StudentDAOImplTest {
	private StudentDAOImpl studentDAOImpl;

	@Before
	public void setUp() throws Exception {
		studentDAOImpl = new StudentDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		studentDAOImpl = null;
	}

	@Ignore
	public void testInsertStudent() {
		int size=studentDAOImpl.viewAllStudents().size();
		Student student = new Student("riya",99,new Address("kollam","kerala"));
		student = studentDAOImpl.insertStudent(student);
		int sizeAfterInsert = studentDAOImpl.viewAllStudents().size();
		
		assertTrue(sizeAfterInsert == (size + 1));
	}

	@Test
	public void testUpdateStudent() {
		Student studentInserted = new Student("riya",99,new Address("kollam","kerala"));
		studentInserted = studentDAOImpl.insertStudent(studentInserted);
		Student modified = new Student(1,"sona",100,new Address("kollam","kerala"));
		Student received = null;
		try {
			 received = studentDAOImpl.updateStudent(modified);
		} catch(StudentNotFoundException snfe) {
			System.out.println(snfe.getMessage());
		}
		assertTrue(modified.equals(received)==true);
		
		
	}

	@Test(expected = StudentNotFoundException.class)
	public void testUpdateStudentNegative()throws StudentNotFoundException {
		Student studentInserted = new Student("riya",99,new Address("kollam","kerala"));
		studentInserted = studentDAOImpl.insertStudent(studentInserted);
		Student modified = new Student(5,"sona",100,new Address("kollam","kerala"));
		Student received = null;
	    received = studentDAOImpl.updateStudent(modified);
		
		assertTrue(modified.equals(received)==true);
		
		
	}
	@Test
	public void testDeleteStudent() {
		Student student = new Student("riya",99,new Address("kollam","kerala"));
		student = studentDAOImpl.insertStudent(student);
		Student deleted = null;
		try {
		 deleted = studentDAOImpl.deleteStudent(1);
		}catch (StudentNotFoundException snfe) {
			System.out.println(snfe.getMessage());
		}
		assertTrue(deleted != null);
	}

	@Test(expected = StudentNotFoundException.class)
	public void testDeleteStudentNegative()throws StudentNotFoundException {
		Student studentInserted = new Student("riya",99,new Address("kollam","kerala"));
		studentInserted = studentDAOImpl.insertStudent(studentInserted);
		Student received = null;
		received = studentDAOImpl.deleteStudent(2);
		assertTrue(received.equals(studentInserted)==true);
	}

	@Test
	public void testViewOneStudent() {
		Student student = new Student("riya",99,new Address("kollam","kerala"));
		student = studentDAOImpl.insertStudent(student);
		Student viewed = null;
		try {
		 viewed = studentDAOImpl.viewOneStudent(1);
		}catch (StudentNotFoundException snfe) {
			System.out.println(snfe.getMessage());
		}
		assertTrue(viewed != null);
	}
	
	@Test(expected = StudentNotFoundException.class)
	public void testStudentViewOneNegative()throws StudentNotFoundException {
		Student studentInserted = new Student("riya",99,new Address("kollam","kerala"));
		studentInserted = studentDAOImpl.insertStudent(studentInserted);
		Student received = null;
		received = studentDAOImpl.viewOneStudent(2);
		assertTrue(received.equals(studentInserted)==true);
	}
	

	@Ignore
	public void testViewAllStudents() {
		fail("Not yet implemented");
	}

}
