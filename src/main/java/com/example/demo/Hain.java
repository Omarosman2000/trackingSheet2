package com.example.demo;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Hain {

    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException{

    	UserController.initialize();
    	UserController.add("CS 1102");
    	/*UserController.add("MA 1022");
    	UserController.add("CS 2022");
    	UserController.add("MA 1021");
    	UserController.add("MA 2611");
    	UserController.add("CS 2223");
    	UserController.add("CS 2303");
    	UserController.add("CS 3043");
    	UserController.add("CS 2119");
    	UserController.add("CS 2102");
    	*/
    	for(String s: UserController.returnRecommendations()) {
    		System.out.print(s + ", ");
    	}
    	UserController.getRequirements();

    }
}
