package com.naim.academiaprogramacion;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@Service
@ControllerAdvice
public class StudentService{

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    //Show all the students
    public List<Student> showStudents(){
        return studentRepository.findAll();
    }
    //Show a student with the same email
    public Student emailStudent (String email){
        return studentRepository.findAll().stream()
                .filter(n->n.getEmail().equals(email))
                .findFirst()
                .orElse(null)
                ;
    }
    //filter by course
    public Student courseFilter(String course){
        return studentRepository.findAll().stream()
                .filter(n->n.getCourse().equals(course.toUpperCase()))
                .findAny()
                .orElse(null);
    }
    //grades ordered from top
    public List<Student> topGrades(long n){
        return studentRepository.findAll().stream()
                .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                .limit(n).collect(Collectors.toList());
    }
    //stats
    public List<StudentStats> stats(){
        int total=(int)studentRepository.findAll().stream().count();
        double average= studentRepository.findAll().stream().mapToDouble(Student::getGrade).average().orElse(0.0);
        int passing=(int)studentRepository.findAll().stream().filter(n->n.getGrade()>=5.0).count();

         List<StudentStats> stats = List.of(
                new StudentStats(total,average,passing));

         return stats;
    }


    //add new student
    public Student addStudent(Student student){
        if(student.isActivate()){
            System.out.println("Is already in");
        }else{
            student.isActivate();
        }
        return studentRepository.save(student);
    }

    //modify the grade
    public Student modifyGrade(String email,double grade){
        Student student=emailStudent(email);
        studentRepository.findAll().stream().filter(n->n.getEmail().equals(email));
        student.setGrade(grade);

        return studentRepository.save(student);
    }
    //delete by email
    public void deleteStudent(String email){
        Student student=emailStudent(email);
        studentRepository.deleteById(student.getId());
    }


}
