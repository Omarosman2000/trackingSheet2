package net.datastructures;

import java.util.HashMap;
import java.util.LinkedList;

public class User {
	
	private LinkedList<String> coursesTaken;
	private HashMap<String, Course> allCourses;
	private
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
	
	/* public User(LinkedList<String> courses) {
		numCS = 0;
		num4000 = 0;
		sys = false;
		theory = false;
		design = false;
		imps = false;
		coursesTaken = courses;
	}
	*/
	
	public void add(String c) {
		if(allCourses.containsKey(c)) {
			coursesTaken.add(c);
			updateReqs(c);
		}
	}
	
	public void delete(String c) {
		coursesTaken.remove(c);
	}
	
	public LinkedList<String> returnCourses(){
		return coursesTaken;
	}
	
	private void updateReqs(String c) {
		
		if(c.charAt(0) == 'C' && c.charAt(1) == 'S') {
			numCS++;
			
			if(c.charAt(2) == '4') {
				num4000++;
			}
		}
		
		Course cour = allCourses.get(c);
		
		switch(cour.getCourseArea()){
            case SYSTEMS:
                sys = true;
            case THEORYANDLANG:
                theory = true;
            case DESIGN:
                design = true;
            case SOCIALIMPS:
                imps = true;
            case NONE:
            default:
        }
		
	}
	
}