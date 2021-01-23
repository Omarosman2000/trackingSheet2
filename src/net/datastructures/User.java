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
                break;
            case THEORYANDLANG:
                theory = true;
                break;
            case DESIGN:
                design = true;
                break;
            case SOCIALIMPS:
                imps = true;
                break;
            case NONE:
            default:
        }
		
	}
	
	/**
	 * gives each of the courses a rating
	 * @return priority arrayList where most recommended appears first
	 */
	public ArrayList<String> getRecommendations(){
		ArrayList<String> classes = new ArrayList<String>();
		PriorityQueue<RatedCourse> pq = new PriorityQueue<RatedCourse>();
		
		
		// gives ratings for courses
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
						if(!sys){
							rating++;
						}
						break;
					case THEORYANDLANG:
						if(!theory){
							rating++;
						}
						break;
					case DESIGN:
						if(!design){
							rating++;
						}
						break;
					case SOCIALIMPS:
						if(!imps){
							rating++;
						}
						break;
					case NONE:
					default:
						
					rating = rating - c.completedPre(coursesTaken);
				}
				pq.add(new RatedCourse(c.getCourseKey(), rating));
			}
		}
		
		Object[] array = pq.toArray();
		
		Arrays.sort(array);
	
		for(int i = 0; i < array.length; i++) {
			classes.add(((RatedCourse) array[i]).getID());
		}
		
		
		return classes;
		
	}
	
	
	
	
	
}