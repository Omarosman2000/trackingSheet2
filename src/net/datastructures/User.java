package net.datastructures;

import java.util.HashMap;
import java.util.LinkedList;

public class User {
	
	private LinkedList<String> coursesTaken;
	private HashMap<String, Course> allCourses;
	private int numCS;
	private int num4000;
	private boolean sys;
	private boolean theory;
	private boolean design;
	private boolean imps;

	public User() {
		coursesTaken = new LinkedList<String>();
		numCS = 0;
		num4000 = 0;
		sys = false;
		theory = false;
		design = false;
		imps = false;
	}
	
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
			if(c.charAt(3) == '4')
				num4000++;
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
	
	public int getCS() {
		return numCS;
	}
	public int get4000() {
		return num4000;
	}
	public boolean hasSys() {
		return sys;
	}
	public boolean hasTheory() {
		return theory;
	}
	public boolean hasDesign() {
		return design;
	}
	public boolean hasImps() {
		return imps;
	}
	
	
}