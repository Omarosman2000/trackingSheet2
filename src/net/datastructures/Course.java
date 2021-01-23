package net.datastructures;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Course {
    String courseKey;
    String courseName;
    CourseArea area;
    List<List<Course>> Pre= new LinkedList<>();
    //List<Course> Post= new LinkedList<>();


    public Course(String courseKey){
        this.courseKey=courseKey;
    }
    public Course(String courseKey, String courseName, int area){
        this.courseKey=courseKey;
        this.courseName=courseName;
        setCourseArea(area);
    }
    public Course(String courseKey, String courseName, List<List<Course>> Pre, int area){
        this.courseKey=courseKey;
        this.courseName=courseName;
        this.Pre=Pre;
        setCourseArea(area);
        //this.Post=Post;
    }
    public void addPreReq(List<Course> newPre){
        Pre.add(newPre);
    }
    public void setCourseName(String name){
        courseName = name;
    }
    public void setCourseArea(int area){
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
    }
    public String getCourseName() {
        return courseName;
    }
    public String getCourseKey() {
        return courseKey;
    }
    public CourseArea getCourseArea(){
        return area;
    }
    public boolean completedPre(List<Course> CoursesTaken){//this needs fix because the ors will break it -- nick
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
    public String toString(){
        String str = courseKey +'|' +courseName +'|'+area+'\n';
        for(int i = 0; i < Pre.size(); i++){
            for(int j = 0; j < Pre.get(i).size(); j++){
                str += Pre.get(i).get(j).getCourseKey();
                if(j+1 < Pre.get(i).size())
                    str += '/';
            }
            if(i+1 < Pre.size())
                    str += '*';
        }
        return str;
    }

}
