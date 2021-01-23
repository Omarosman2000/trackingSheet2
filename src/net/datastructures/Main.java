package net.datastructures;


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


    }
}
