package com.naim.academiaprogramacion;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    //Show all the students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.showStudents();
    }
    //Show a student with the same email
    @GetMapping("/students/{email}")
    public Student getStudentEmail(String email){
        return studentService.emailStudent(email);
    }
    //filter by course
    @GetMapping("/students/course/{course}")
    public Student getStudentsCourse(String course){
        return studentService.courseFilter(course);
    }
    //grades ordered from top
    @GetMapping("/students/top/{n}")
    public List<Student> topGrades(long n){
        return studentService.topGrades(n);
    }
    //students stats
    @GetMapping("/students/stats")
    public List<StudentStats> stats (){
        return studentService.stats();
    }
    //Add new students
    @PostMapping("/students")
    public Student addStudent1(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    //Modifygrade
    @PutMapping("/students/{email/grade}")
    public Student modifyGrade(@PathVariable String email, @RequestBody double grade){
        return studentService.modifyGrade(email,grade);
    }
    //delete by email

    @DeleteMapping("/students/{email}")
    public void deleteStudent1 (@PathVariable String email){
        studentService.deleteStudent(email);
    }
}


