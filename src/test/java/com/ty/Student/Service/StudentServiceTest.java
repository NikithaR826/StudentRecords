package com.ty.Student.Service;

import com.ty.Student.entities.Student;
import com.ty.Student.repo.StudentInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentInterface studentInterface;

    @InjectMocks
    StudentService studentService;

    Student student1;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getByfname() {
        student1 = new Student();
        student1.setFname("Nikitha");
        when(studentInterface.getByfname(anyString())).thenReturn(student1);
        Student student = studentService.getByfname("nikitha");
        Assertions.assertEquals(student.getFname(),"Nikitha");

    }

    @Test
    void getByname(){

        when(studentInterface.getByfname(anyString())).thenReturn(null);
        Student student= studentService.getByfname("Raavi");
        Assertions.assertNull(student);

    }

    @Test
    void deleteById() {
        when(studentInterface.existsById(anyInt())).thenReturn(true);
        String result = studentService.deleteStudent(10);
        Assertions.assertEquals("Student Deleted", result);
    }

    @Test
    void deleteById_StudentNotFound() {
        when(studentInterface.existsById(anyInt())).thenReturn(false);
        String result = studentService.deleteStudent(12);
        Assertions.assertEquals("Student not Found", result);
    }



}
