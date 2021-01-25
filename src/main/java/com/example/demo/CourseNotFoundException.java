package com.example.demo;
public class CourseNotFoundException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Course course;

    CourseNotFoundException(Course course) {
        this.course = course;
    }

    Course getCourse() {
        return this.course;
    }
}
