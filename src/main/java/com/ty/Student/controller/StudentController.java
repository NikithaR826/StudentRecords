package com.ty.Student.controller;

import com.ty.Student.Service.StudentService;
import com.ty.Student.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private static final Logger logger = LogManager.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentService.Service2 service2;

    @GetMapping("/students")
    public ResponseEntity<List> getAllStudents(){
        List<Student> str= studentService.getStudents();
        service2.print();
        logger.info("StudentCOntroller");
        return new ResponseEntity<>(str, HttpStatus.OK);
    }


    @PostMapping("/student/save")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }
    @GetMapping("/{fname}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String fname){

        return new ResponseEntity<>(studentService.getByfname(fname),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);

    }

    @DeleteMapping("/student/deleteAll")
    public ResponseEntity<String> deleteStudents()
    {
        return new ResponseEntity<>(studentService.deleteAllStudent(), HttpStatus.OK);
    }

    @PutMapping("/student/{id}/{fname}")
    public ResponseEntity<String> updateStudentFname(@PathVariable int id, @PathVariable String fname) {
        String updated = studentService.updatefname(id, fname);


        if(updated==null) {
            return new ResponseEntity<>("Student not found or update failed", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        }
    }

}
