package net.datastructures;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException; // Import the IOException class to handle errors
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        

        Scanner input = new Scanner(System.in);
        System.out.println("Enter course name: ");
        String courseName =input.nextLine();
        System.out.println(courseName);

        if(courseName == null){
            System.out.println("Invalid course name! ");
        }


    }
}
