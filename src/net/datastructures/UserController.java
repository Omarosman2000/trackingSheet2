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
	
	public boolean add(String c) {
		return person.add(c);
	}
	
	public static void returnRecommendations(){
		ArrayList<String> courses = person.getRecommendations();
		
		for(String c : courses) {
			System.out.print(c + ", ");
		}
		
	}
	
	public static void getRequirements() {
		GradReqs gr = person.getReqs();
		int numCS = gr.getCS();
		int num4000 = gr.get4000();
		boolean sys = gr.getSys();
		boolean theory = gr.getTheory();
		boolean design = gr.getDesign();
		boolean imps = gr.getImps();

	}
	
}
