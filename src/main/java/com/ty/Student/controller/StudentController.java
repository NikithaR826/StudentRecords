package com.ty.Student.controller;

import com.ty.Student.Service.StudentService;
import com.ty.Student.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List> getAllStudents(){
        List<Student> str= studentService.getStudents();
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @PostMapping("/student/save")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student){
//       Student status=studentService.upsert(student);
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
    public ResponseEntity<String> updateStudentFname(@PathVariable int id,@PathVariable String fname)
    {
        Boolean updated= studentService.updatefname(id,fname);
        if(updated) {
            return new ResponseEntity<>("Student Updated" , HttpStatus.OK);
        }
        else  {
            return new ResponseEntity<>("Student Not Updated" , HttpStatus.OK);
        }
    }


}
