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
	
	public static void newPerson() {
		person = new User(allCourses, Course.allCourses);
	}
	
	public static boolean add(String c) {
		return person.add(c);
	}
	
	public static ArrayList<String> returnRecommendations(){
		ArrayList<String> courses = person.getRecommendations();
		
		return courses;
		
	}
	
	public static String getRequirements() {
		GradReqs gr = person.getReqs();
		int numCS = gr.getCS();
		int num4000 = gr.get4000();
		boolean sys = gr.getSys();
		boolean theory = gr.getTheory();
		boolean design = gr.getDesign();
		boolean imps = gr.getImps();
		String output = "" + numCS + "/18 CS Courses Complete \n\n" 
						+ num4000 + "/5 4000-Level Courses Complete \n\n" 
						+ "Systems Req: " + isComplete(sys) + "\n\n"
						+ "Theory and Language Req: " + isComplete(theory) + "\n\n" 
						+ "Design Req: " + isComplete(design) + "\n\n"
						+ "Social Implicatios Req: " + isComplete(imps) + "";
		
		return output;

	}
	
	private static String isComplete(boolean b) {
		if(b)
			return "Complete";
		else
			return "Incomplete";
	}
	
	
	
	
	
	
}
