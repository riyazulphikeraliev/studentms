package com.speridian.dao;

import java.util.List;

import com.speridian.entity.Student;
import com.speridian.exception.StudentNotFoundException;

public interface StudentDAO {
	
	public Student insertStudent(Student student);
	public Student updateStudent(Student student)throws StudentNotFoundException;
	public Student deleteStudent(int rollno)throws StudentNotFoundException;
	public Student viewOneStudent(int rollno)throws StudentNotFoundException;
	public List<Student>viewAllStudents();
}