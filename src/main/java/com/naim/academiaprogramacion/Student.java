package com.naim.academiaprogramacion;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String course;
    @Min(value=0,message = "La nota debe estar entre 0 y 10")@Max(value = 10, message = "La nota debe estar entre 0 y 10")
    private double grade;
    private boolean activate;

    public Student(Long id, String name, String email,String course, double grade){
        this.id=id;
        this.name=name;
        this.email=email;
        this.course=course;
        this.grade=grade;
        this.activate=false;
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

    }


class DateInvalidException extends RuntimeException{
    public DateInvalidException(String message){
        super(message);
    }
}
