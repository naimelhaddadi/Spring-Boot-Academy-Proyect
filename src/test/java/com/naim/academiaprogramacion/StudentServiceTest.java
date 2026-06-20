package com.naim.academiaprogramacion;

import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class StudentServiceTest {
    @ExtendWith(MockitoExtension.class)
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;



    @Test
    public void getAll() {
        when(studentRepository.findAll()).thenReturn(List.of(new Student()));
        List<Student> result=studentService.showStudents();
        assertNotNull(result);
        assertEquals(1,result.size());
    }
    @Test
    //when i add a student with an existing eemail
    public void addStudent(){
        //arrange
        Student existing = new Student();
        existing.setEmail("naim@gmail.com");
        when(studentRepository.findAll()).thenReturn(List.of(existing));
        //Act
        Student newEmail= new Student();
        newEmail.setEmail("naim@gmail.com");
        //Assert
        assertThrows(DateInvalidException.class, () -> studentService.addStudent(newEmail));



    }

    @Test
    public void modifyGrade(){
        Student studentExist= new Student();
        studentExist.setEmail("");
        Student newGrade= new Student();
        when(studentRepository.findAll()).thenReturn(List.of());
        assertThrows(DateInvalidException.class, () -> studentService.modifyGrade(studentExist.getEmail(), newGrade.getGrade()));

    }

    @Test
    public void modifyGrade1(){
        Student emailExisting = new Student();
        when(studentRepository.findAll()).thenReturn(List.of(emailExisting));
        when(studentRepository.save(any(Student.class))).thenReturn(emailExisting);
        emailExisting.setEmail("naim@gmail.com");

        Student result= studentService.modifyGrade("naim@gmail.com",10);


        assertEquals(10,result.getGrade());


    }

}
