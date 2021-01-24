package com.example.demo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class UserController {
	
	private static HashMap<String,Course> allCourses;
	private static User person;

	public static void initialize() throws FileNotFoundException {
		allCourses = CourseParser.parseFile("CScourses.txt");
    	person = new User(allCourses, Course.allCourses);
	}
	
	public static boolean add(String c) {
		return person.add(c);
	}
	
	public static ArrayList<String> returnRecommendations(){
		ArrayList<String> courses = person.getRecommendations();
		return courses;
		
	}
	
	public static GradReqs getRequirements() {
		GradReqs gr = person.getReqs();
		return gr;

	}
	
	
	
	
	
	
}
