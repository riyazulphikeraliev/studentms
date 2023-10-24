package com.speridian.entity;

import java.util.Objects;

public class Student {
	private static int rno;
	
	private int rollno;
	private String name;
	private float percent;
	
	private Address address;
	
	{
		this.rollno = ++rno;
	}
	
	public Student(int rollno, String name, float percent, Address address) {
		this.rollno = rollno;
		this.name = name;
		this.percent = percent;
		this.address = address;
	}

	public Student(String name, float percent) {
		this.name = name;
		this.percent = percent;
	}

	public Student(String name, float percent, Address address) {
		this.name = name;
		this.percent = percent;
		this.address = address;
	}


	public int getRollno() {
		return rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	public void print() {
		System.out.println(rollno);
		System.out.println(name);
		System.out.println(percent);
		address.print();
	}
		
	@Override
	public int hashCode() {
		return rollno;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && Objects.equals(name, other.name)
				&& Float.floatToIntBits(percent) == Float.floatToIntBits(other.percent) && rollno == other.rollno;
	}

	public static void getCount() {
		System.out.println("Total objects here: " + rno);
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", percent=" + percent + ", address=" + address + "]";
	}
}