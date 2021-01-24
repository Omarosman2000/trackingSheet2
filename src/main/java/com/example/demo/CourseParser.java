package com.example.demo;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CourseParser {
    static public HashMap<String, Course> parseFile(String fileName) throws FileNotFoundException {
        HashMap<String,Course> courseGraph = new HashMap<String,Course>();
        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter(";");
        while(sc.hasNext()){
            String[] lines = sc.next().split("\\r\\n");
            String[] ids = lines[1].split("\\|");
            Course newCourse;
            if(courseGraph.containsKey(ids[0])){ // if this ID exists
                newCourse = courseGraph.get(ids[0]); // get it
                newCourse.setCourseName(ids[1]);
                newCourse.setCourseArea(Integer.parseInt(ids[2]));
            }else{
                newCourse = new Course(ids[0],ids[1], Integer.parseInt(ids[2])); //create it and put it in the hash map
                courseGraph.put(newCourse.getCourseKey(), newCourse);
            }
            if(lines.length >= 3){
                String[] courses = lines[2].split("\\*");
                for(int i = 0; i < courses.length; i++){// build a list of prerecs
                    List<Course> newPre = new LinkedList<Course>();
                    if(courses[i].length() > 9){
                        // ors (when you can choose between or more reccomended courses)
                        String[] ors = courses[i].split("/");
                        for(int j = 0; j < ors.length; j++){
                            addCourseToPre(newPre, ors[j], courseGraph);
                        }
                    }else{
                        //ands (should only be a single course)
                        addCourseToPre(newPre, courses[i], courseGraph);
                    }
                    newCourse.addPreReq(newPre);
                }
            }
           // System.out.println(newCourse.toString());
        }
        return courseGraph;
    }

    private static void addCourseToPre(List<Course> Pre, String key, HashMap<String,Course> courseGraph){
        if(!courseGraph.containsKey(key)){ 
            Course freshCourse = new Course(key);
            courseGraph.put(key, freshCourse);
        }
        Pre.add(courseGraph.get(key));
    }
}

