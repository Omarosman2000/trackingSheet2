package net.datastructures;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Major {
    HashMap<String, String> allCourses=new HashMap<>();
    List<Course> majorSpecificCourses=new LinkedList<Course>();
    public Major(HashMap<String, String> allCourses, List<Course> majorSpecificCourses){
        this.allCourses=allCourses;
        this.majorSpecificCourses=majorSpecificCourses;
    }
    public List<Course> getMajorSpecificClasses(){
       return this.majorSpecificCourses;
    }
}
