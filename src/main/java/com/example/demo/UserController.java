package com.example.demo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserController {
	
	private static HashMap<String,Course> allCourses;
	private static User person;

	public static void initialize() throws FileNotFoundException {
		allCourses = CourseParser.parseFile("CScourses.txt");
		newPerson();
	}
	
	public static void newPerson() {
		person = new User(allCourses, Course.allCourses);
	}
	
	public static boolean add(String c) {
		return person.add(c);
	}
	
	public static ArrayList<String> returnRecommendations(){
		ArrayList<String> courses = person.getRecommendations();
		ArrayList<String> output = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			output.add(courses.get(i));
		}
		return output;
	}
	
	public static String getRequirements() {
		GradReqs gr = person.getReqs();
		String output = "" + gr.getCS() + "/18 CS Courses Complete \n\n" 
						+ gr.get4000() + "/5 4000-Level Courses Complete \n\n" 
						+ "Systems Req: " + isComplete(gr.getSys()) + "\n\n"
						+ "Theory and Language Req: " + isComplete(gr.getTheory()) + "\n\n" 
						+ "Design Req: " + isComplete(gr.getDesign()) + "\n\n"
						+ "Social Implicatios Req: " + isComplete(gr.getImps()) + "";
		
		return output;

	}
	
	private static String isComplete(boolean b) {
		if(b)
			return "Complete";
		else
			return "Incomplete";
	}
	
}
