package com.example.myapp;

public class registeredcoursesmodel {
    String name, courseId, courseInstructor,regcoursenumber;
    public registeredcoursesmodel(){}
    public registeredcoursesmodel(String name, String courseId, String courseInstructor,String regcoursenumber) {
        this.name = name;
        this.courseId = courseId;
        this.courseInstructor = courseInstructor;
        this.regcoursenumber=regcoursenumber;
    }

    public String getRegcoursenumber() {
        return regcoursenumber;
    }

    public void setRegcoursenumber(String regcoursenumber) {
        this.regcoursenumber = regcoursenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }
}
