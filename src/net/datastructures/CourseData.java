package net.datastructures;
import java.util.*;

public class CourseData {
    List<Course> CoursesTaken= new LinkedList<Course>();
    public enum Systems{ CS3013, CS4513, CS4515, CS4516};
    public enum Theory{ CS3133, CS4120, CS4123, CS4533, CS4536};
    public enum Design{CS3041, CS3431, CS3733, CS4233};
    public enum Social_Implications{CS3043, IMGD2000, IMGD2001, GOV2314, ID2314,GOV2315, ID2315};


    public CourseData(List<Course> CoursesTaken){
        this.CoursesTaken=CoursesTaken;
    }
    public boolean checkMajorSpecific(Major m, List<Course> CoursesTaken){
        int sameCourse=0;
        for(int i=0; i<m.majorSpecificCourses.size()-1;i++){
            for(int j=0; j<CoursesTaken.size()-1;j++){
                if(m.majorSpecificCourses.indexOf(i)==CoursesTaken.indexOf(j)) {
                    sameCourse++;
                }
            }
        }
        if(sameCourse==m.majorSpecificCourses.size()-1){
            return true;
        }else{
            return false;
        }
    }

    public void processClass(Course course) throws CourseTakenException{
        if(this.CoursesTaken.contains(course)){
            throw new CourseTakenException(course);
        }else {
            CoursesTaken.add(course);
        }
    }

    public List<Course> printPre(Course course){
        return course.Pre;
    }
}
