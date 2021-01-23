package net.datastructures;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Course {
    String courseKey;
    String courseName;
    CourseArea area;
    List<Course> Pre= new LinkedList<>();
    //List<Course> Post= new LinkedList<>();


    public Course(String courseKey, String courseName){
        this.courseKey=courseKey;
        this.courseName=courseName;
    }
    public Course(String courseKey, String courseName, List<Course> Pre, int area){
        this.courseKey=courseKey;
        this.courseName=courseName;
        this.Pre=Pre;
        switch(area){
            case(0):
                this.area= CourseArea.NONE;
                break;
            case(1):
                this.area= CourseArea.SYSTEMS;
                break;
            case(2):
                this.area= CourseArea.THEORYANDLANG;
                break;
            case(3):
                this.area= CourseArea.DESIGN;
                break;
            case(4):
                this.area= CourseArea.SOCIALIMPS;
                break;
            default:
                this.area= CourseArea.NONE;
        }
        //this.Post=Post;
    }

    public String getCourseName() {
        return courseName;
    }
    public boolean completedPre(List<Course> CoursesTaken){
        int sameCourse=0;
        for(int i=0; i<this.Pre.size()-1;i++){
            for(int j=0; j<CoursesTaken.size()-1;j++){
                if(this.Pre.indexOf(i)==CoursesTaken.indexOf(j)) {
                    sameCourse++;
                }
            }
        }
        if(sameCourse==this.Pre.size()-1){
            return true;
        }else{
            return false;
        }
    }

}
