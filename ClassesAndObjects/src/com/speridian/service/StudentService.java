package com.speridian.service;

import java.util.List;

import com.speridian.entity.Student;

public interface StudentService {

	public Student insertStudent(Student student);
	public Student updateStudent(Student student);
	public Student deleteStudent(int rollno);
	public Student viewOneStudent(int rollno);
	public List<Student>viewAllStudents();
}
