package net.datastructures;


import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException{
    	
    	// Create a Hash of All WPI Courses
    	HashMap<String,Course> courseGraph = CourseParser.parseFile("CScourses.txt");
    	
    	User person = new User();
    	
    	// Take in User Input
    	Scanner input = new Scanner(System.in);
        System.out.println("Enter course ID: ");
        String courseID = input.nextLine();

            if(!courseGraph.containsKey(courseID)){
                System.out.println("Invalid course name!");
            }
            
         


    }
}
