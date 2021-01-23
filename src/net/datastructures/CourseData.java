package net.datastructures;
import java.util.*;

public class CourseData {
    List<Course> CoursesTaken= new LinkedList<Course>();


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

   /* public void processClass(Course course) throws CourseTakenException{
        if(this.CoursesTaken.contains(course)){
            throw new CourseTakenException(course);
        }else {
            CoursesTaken.add(course);
        }
    }

    public List<Course> printPre(Course course){
        if(!this.CoursesTaken.contains(course)){
            System.out.println("Course was not found");
            throw new CourseNotFoundException(course);
        }else {
            return course.Pre;
        }
    }*/
}
