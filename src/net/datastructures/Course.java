import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Course {
    String courseKey;
    String courseName;
    LinkedList<Course> Pre= new LinkedList<>();
    LinkedList<Course> Post= new LinkedList<>();


    public Course(String courseKey, String courseName){
        this.courseKey=courseKey;
        this.courseName=courseName;
    }
    public Course(String courseKey, String courseName, LinkedList<Course> Pre, LinkedList<Course> Post){
        this.courseKey=courseKey;
        this.courseName=courseName;
        this.Pre=Pre;
        this.Post=Post;
    }

    public String getCourseName() {
        return courseName;
    }
    public boolean completedPre(List<Course> coursesTaken){
        if(finishedPre(coursesTaken)){
            return true;
        }else{
            return false;
        }
    }
    public boolean finishedPre(List<Course> CoursesTaken){
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
