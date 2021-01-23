package net.datastructures;

import java.util.LinkedList;

public class User {
	
	private LinkedList<String> coursesTaken;
	int numCS;
	int num4000;
	boolean sys;
	boolean theory;
	boolean design;
	boolean imps;

	public User() {
		coursesTaken = new LinkedList<String>();
		numCS = 0;
		num4000 = 0;
		sys = false;
		theory = false;
		design = false;
		imps = false;
	}
	
	public User(LinkedList<String> courses) {
		numCS = 0;
		num4000 = 0;
		sys = false;
		theory = false;
		design = false;
		imps = false;
		coursesTaken = courses;
	}
	
	public void add(String c) {
		coursesTaken.add(c);
	}
	
	public void delete(String c) {
		coursesTaken.remove(c);
	}
	
	public LinkedList<String> returnCourses(){
		return coursesTaken;
	}
	
	private void updateReqs(String c) {
		//if
		
	}
	
}