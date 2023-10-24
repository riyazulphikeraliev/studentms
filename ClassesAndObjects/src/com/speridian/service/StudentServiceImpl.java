package com.speridian.service;

import java.util.List;

import com.speridian.dao.StudentDAO;
import com.speridian.dao.StudentDAOImpl;
import com.speridian.entity.Student;
import com.speridian.exception.StudentNotFoundException;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		studentDAO = new StudentDAOImpl();
	}

	@Override
	public Student insertStudent(Student student) {
		return studentDAO.insertStudent(student);
	}

	@Override
	public Student updateStudent(Student student) {
		Student stu = null;
		try {
			stu = studentDAO.updateStudent(student);
		}catch(StudentNotFoundException snfe) {
			System.out.println(snfe.getMessage());
		}
		
		return stu;
	}

	@Override
	public Student deleteStudent(int rollno) {
		Student student = null;
		try {
			student = studentDAO.deleteStudent(rollno);
		}catch(StudentNotFoundException snfe) {
			System.out.println(snfe.getMessage());
		}
		return student;
	}

	@Override
	public Student viewOneStudent(int rollno) {
		Student student = null;
		try {
			student = studentDAO.viewOneStudent(rollno);
		}catch(StudentNotFoundException snfe) {
			System.out.println(snfe.getMessage());
		}
		return student;
	}

	@Override
	public List<Student> viewAllStudents() {
		return studentDAO.viewAllStudents();
	}

}
