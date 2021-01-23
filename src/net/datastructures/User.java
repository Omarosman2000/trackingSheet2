package net.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class User {
	
	private LinkedList<String> coursesTaken;
	private HashMap<String, Course> allCourses;
	private LinkedList<Course> allCoursesList;
	private int numCS;
	private int num4000;
	private boolean sys;
	private boolean theory;
	private boolean design;
	private boolean imps;

	public User(HashMap<String, Course> allCourses, LinkedList<Course> allCoursesList) {
		coursesTaken = new LinkedList<String>();
		this.allCourses = allCourses;
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
	
	/**
	 * gives each of the courses a rating
	 * @return priority arrayList where most recommended appears first
	 */
	public ArrayList<Integer> getRecommendations(){
		ArrayList<Integer> classes = new ArrayList<Integer>();
		PriorityQueue<RatedCourse> pq = new PriorityQueue<RatedCourse>();

		
		pq.add(new RatedCourse("CS 3043", 2));
		pq.add(new RatedCourse("CS 2043", 2));
		pq.add(new RatedCourse("CS 1043", 2));
		pq.add(new RatedCourse("CS 1233", 3));
		pq.add(new RatedCourse("CS 3030", 3));
		pq.add(new RatedCourse("CS 2053", 1));
		pq.add(new RatedCourse("CS 3045", 4));
		pq.add(new RatedCourse("CS 2045", 2));
		pq.add(new RatedCourse("CS 1047", 1));
		pq.add(new RatedCourse("CS 1235", 0));
		pq.add(new RatedCourse("CS 3037", 2));
		pq.add(new RatedCourse("CS 2055", 1));
		
		Object[] array = pq.toArray();
		
		Arrays.sort(array);
	
		for(int i = 0; i < array.length; i++) {
			classes.add(((RatedCourse) array[i]).getRating());
		}
		
		
		return classes;
		
	}
	
	
	
	
	
}