package net.datastructures;

<<<<<<< Updated upstream

import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter course name: ");
        String courseName =input.nextLine();
        System.out.println(courseName);

            if(courseName == null){
                System.out.println("Invalid course name! ");
            }

=======
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) { 
        
        try {
            CourseParser.parseFile("CScourses.txt");
            System.out.println("success?");
        }catch(FileNotFoundException e){
            System.out.println("failed");
        }
>>>>>>> Stashed changes

    }
}
