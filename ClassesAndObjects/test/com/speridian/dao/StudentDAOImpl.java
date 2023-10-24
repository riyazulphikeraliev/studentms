package com.speridian.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.speridian.entity.Student;
import com.speridian.exception.StudentNotFoundException;

public class StudentDAOImpl implements StudentDAO {
	private static Map<Integer, Student>students = new HashMap<>();
	
	@Override
	public Student insertStudent(Student student) {
		students.put(student.getRollno(), student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) throws StudentNotFoundException {
		if(students.containsKey(student.getRollno())) {
			students.put(student.getRollno(), student);
		}else {
			throw new StudentNotFoundException("Record of this student doesn't exist");
		}
		return student;
	}

	@Override
	public Student deleteStudent(int rollno) throws StudentNotFoundException {
		Student student = null;
		if(students.containsKey(rollno)) {
			student = students.get(rollno);
			students.remove(rollno);
		}else {
			throw new StudentNotFoundException("Record of this student doesn't exist");
		}
		return student;
	}

	@Override
	public Student viewOneStudent(int rollno) throws StudentNotFoundException {
		Student student = null;
		if(students.containsKey(rollno)) {
			student = students.get(rollno);
		}else {
			throw new StudentNotFoundException("Record of this student doesn't exist");
		}
		return student;
	}

	@Override
	public List<Student> viewAllStudents() {
		Collection<Student>studentCollection = students.values();
		List<Student>studentList = new ArrayList<>();
		studentList.addAll(studentCollection);
		return studentList;
	}
}