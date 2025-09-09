package com.programs.javads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ComparatorStudentExample {

	
	public static void main(String[] args) {
		Student s1 = new Student(3, "naga");
		Student s2 = new Student(2, "siva");
		Student s3 = new Student(1, "bhavani");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		Iterator<Student> listIterator = list.listIterator();
		while(listIterator.hasNext()) {
			Student stud = listIterator.next();
			System.out.println("id: " +stud.id);
		}
		
		Collections.sort(list, new StudentIdComparator());
		
		Iterator<Student> listIterator2 = list.listIterator();
		while(listIterator2.hasNext()) {
			Student stud = listIterator2.next();
			System.out.println("id: " +stud.id);
		}
	}
	public static class Student {
		int id;
		String name;
		
		public Student(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}
	
	public static class StudentIdComparator implements Comparator<Student> {

		@Override
		public int compare(Student	o1, Student o2) {
			if(o1.id == o2.id) {
				return 0;
			} else if(o1.id < o2.id) {
				return -1;
			} else {
				return 1;
			}
		}
		
	}
}
