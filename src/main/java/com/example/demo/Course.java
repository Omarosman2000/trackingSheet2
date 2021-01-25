package com.example.demo;
import java.util.LinkedList;
import java.util.List;

public class Course {
    static protected LinkedList<Course> allCourses = new LinkedList<>() ;
    private String courseKey;
    private String courseName;
    private CourseArea area;
    private List<List<Course>> Pre= new LinkedList<>();
    //List<Course> Post= new LinkedList<>();


    public Course(String courseKey){
        this.courseKey=courseKey;
        allCourses.add(this);
    }
    public Course(String courseKey, String courseName, int area){
        this.courseKey=courseKey;
        this.courseName=courseName;
        setCourseArea(area);
        allCourses.add(this);
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
    public int completedPre(List<String> CoursesTaken){
        int missedCourse=0;
        for (List<Course> courseList : Pre) {
            boolean match = false;
            for(Course course : courseList) {
                for(int i = 0; i < CoursesTaken.size()&&!match; i++){//interates through the ors (or single values for ands)
                    if(course.getCourseKey().equals(CoursesTaken.get(i))){
                        match = true;
                    }
                    if(match) break; // no need to check the rest of the ors if we already have a match
                }
                if(!match) missedCourse++;
            }
        }
        return missedCourse;
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
    
    public boolean isCS() {
    	return courseKey.charAt(0) == 'C' && courseKey.charAt(1) == 'S';
    }
    
    /**
     * returns 0 (false) or 1 (true) if it is a given type ('1', '2', '3', or '4')
     * @param type '1' '2' '3' '4'
     * @return 0 or 1 if true
     */
    public int isType(char type) {
    	if (courseKey.indexOf(' ') + 1 < courseKey.length()) {
    		if(courseKey.charAt(courseKey.indexOf(' ') + 1) == type)
    			return 1;
    	}
    	return 0;
    }

}
