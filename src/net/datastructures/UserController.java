package net.datastructures;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserController {
	
	private static HashMap<String,Course> allCourses;
	private static User person;

	public static void initialize() throws FileNotFoundException {
		allCourses = CourseParser.parseFile("CScourses.txt");
    	person = new User(allCourses, Course.allCourses);
	}
	
	public static void add(String c) {
		person.add(c);
	}
	
	public static void returnRecommendations(){
		ArrayList<String> courses = person.getRecommendations();
		
		for(String c : courses) {
			System.out.print(c + ", ");
		}
		
	}
	
}
