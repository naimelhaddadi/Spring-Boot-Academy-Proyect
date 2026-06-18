package com.naim.academiaprogramacion;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student implements Validate{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String course;
    private double grade;
    private boolean activate;

    public Student(Long id, String name, String email,String course, double grade){
        this.id=id;
        this.name=name;
        this.email=email;
        this.course=course;
        this.grade=grade;
        this.activate=false;
        validate();
    }
    public Student(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public double getGrade() {
        return grade;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course.toUpperCase();
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    @Override
    public void validate() {
            if (grade < 0.0 || grade > 10.0) throw new DateInvalidException("Invalid grade(0-10)");
            if (!course.equals("JAVA") && !course.equals("PYTHON") && !course.equals("JAVASCRIPT"))
                throw new DateInvalidException("Invalid Course");
            if (!email.contains("@"))
                throw new DateInvalidException("Invalid Email");
        }
    }


class DateInvalidException extends RuntimeException{
    public DateInvalidException(String message){
        super(message);
    }
}
