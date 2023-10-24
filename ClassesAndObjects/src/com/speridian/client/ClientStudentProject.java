package com.speridian.client;

import java.util.List;
import java.util.Scanner;

import com.speridian.entity.Address;
import com.speridian.entity.Student;
import com.speridian.service.StudentService;
import com.speridian.service.StudentServiceImpl;

public class ClientStudentProject {

	public static void main(String[] args) {
		int choice = -1;
		StudentService studentService = new StudentServiceImpl();
		
		int rollno = 0;
		String name = null;
		float percent = 0.0f;
		
		String city = null;
		String state = null;
		
		Student student = null;
		Address address = null;
		
		Scanner scInput = new Scanner(System.in);
		
		while(choice != 0) {
			System.out.println("1. Insert Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. View One Student");
			System.out.println("5. View All Students");
			System.out.println("0. Exit");
			
			choice = Integer.parseInt(scInput.nextLine());
			
			switch(choice) {
			case 1:
				System.out.print("Enter name: ");
				name = scInput.nextLine();
				
				System.out.print("Enter percent: ");
				percent = Float.parseFloat(scInput.nextLine());
				
				System.out.print("Enter City: ");
				city = scInput.nextLine();
				
				System.out.print("Enter State: ");
				state = scInput.nextLine();
				
				address = new Address(city, state);
				
				student = new Student(name, percent, address);
				
				student = studentService.insertStudent(student);
				
//				if(student != null) {
//					System.out.println(student);
//				}
				break;
			case 2:
				System.out.print("Enter Rollno: ");
				rollno = Integer.parseInt(scInput.nextLine());
				
				System.out.print("Enter name: ");
				name = scInput.nextLine();
				
				System.out.print("Enter percent: ");
				percent = Float.parseFloat(scInput.nextLine());
				
				System.out.print("Enter City: ");
				city = scInput.nextLine();
				
				System.out.print("Enter State: ");
				state = scInput.nextLine();
				
				address = new Address(city, state);
				
				student = new Student(rollno, name, percent, address);
				
				student = studentService.updateStudent(student);
				
				if(student != null) {
					System.out.println(student);
				}
				break;
			case 3:
				System.out.print("Enter Rollno: ");
				rollno = Integer.parseInt(scInput.nextLine());
				
				student = studentService.deleteStudent(rollno);

//				if(student != null) {
//					System.out.println(student);
//				}
				break;
				
			case 4:
				System.out.print("Enter Rollno: ");
				rollno = Integer.parseInt(scInput.nextLine());
				
				student = studentService.viewOneStudent(rollno);

				if(student != null) {
					System.out.println(student);
				}
				break;
			case 5:
				List<Student>studentList = studentService.viewAllStudents();
				System.out.println("List of all students:");
				
				for(Student stu : studentList) {
					System.out.println(stu);
					System.out.println("=================================================================");
				}
				break;
			}
		}
		System.out.println("Bye!");
		scInput.close();
	}

}
