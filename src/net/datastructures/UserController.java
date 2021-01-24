package net.datastructures;

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
	
	public static void returnRecommendations(){
		ArrayList<String> courses = person.getRecommendations();
		
		for(int i = 0; i < 10; i++) {
			System.out.print(courses.get(i) + ", ");
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
		System.out.println();
		String output = "" + numCS + "/18 CS Courses Complete \n" 
						+ num4000 + "/5 4000-Level Courses Complete \n" 
						+ "Systems Req: " + isComplete(sys) + "\n"
						+ "Theory and Language Req: " + isComplete(theory) + "\n" 
						+ "Design Req: " + isComplete(design) + "\n"
						+ "Social Implicatios Req: " + isComplete(imps) + "";
		
		System.out.println(output);

	}
	
	private static String isComplete(boolean b) {
		if(b)
			return "Complete";
		else
			return "Incomplete";
	}
	
}
