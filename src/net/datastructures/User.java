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
		this.allCoursesList = allCoursesList;
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
	
	/**
	 * gives each of the courses a rating
	 * @return priority arrayList where most recommended appears first
	 */
	public ArrayList<Integer> getRecommendations(){
		ArrayList<Integer> classes = new ArrayList<Integer>();
		PriorityQueue<RatedCourse> pq = new PriorityQueue<RatedCourse>();
		
		for(Course c: allCoursesList) {
			if(!coursesTaken.contains(c)) {
				int rating = 0;
				if(c.isCS()) {
					rating++;
					if(c.is4000())
						rating++;
				}

				switch(c.getCourseArea()) {
					case SYSTEMS:
						if(sys = false){
							rating++;
						}
					case THEORYANDLANG:
						if(theory = false){
							rating++;
						}
					case DESIGN:
						if(design = false){
							rating++;
						}
					case SOCIALIMPS:
						if(imps = false){
							rating++;
						}
					case NONE:
					default:
				}


				
				
				
				pq.add(new RatedCourse(c.getCourseKey(), rating));
			}
		}
		
		Object[] array = pq.toArray();
		
		Arrays.sort(array);
	
		for(int i = 0; i < array.length; i++) {
			classes.add(((RatedCourse) array[i]).getRating());
		}
		
		
		return classes;
		
	}
	
	
	
	
	
}