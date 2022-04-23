package com.example.myapp;

public class ViewCourseModel {
    private String course_name;
    private String course_number;
    private String course_instructor;
    private int credit_hour;



    public ViewCourseModel(String course_name, String course_number, String course_instructor, int credit_hour) {
        this.course_name = course_name;
        this.course_number = course_number;
        this.course_instructor = course_instructor;
        this.credit_hour = credit_hour;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_number() {
        return course_number;
    }

    public void setCourse_number(String course_number) {
        this.course_number = course_number;
    }

    public String getCourse_instructor() {
        return course_instructor;
    }

    public void setCourse_instructor(String course_instructor) {
        this.course_instructor = course_instructor;
    }

    public int getCredit_hour() {
        return credit_hour;
    }

    public void setCredit_hour(int credit_hour) {
        this.credit_hour = credit_hour;
    }

}
