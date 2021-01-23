package net.datastructures;


import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){
    	
    	// Create a Hash of All WPI Courses
    	HashMap<String,Course> courseGraph = CourseParser.parseFile("CScourses.txt");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter course name: ");
        String courseName =input.nextLine();
        System.out.println(courseName);

            if(courseName == null){
                System.out.println("Invalid course name! ");
            }


    }
}
