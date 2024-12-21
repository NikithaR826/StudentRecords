package com.ty.Student.Service;

import com.ty.Student.entities.Student;
import com.ty.Student.repo.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentInterface studentInterface;

    public List<Student> getStudents(){
        return studentInterface.findAll();
    }


    public Student save(Student student){
        return studentInterface.save(student);
    }

    public Student getById(int Id){
        return studentInterface.getReferenceById(Id);
    }

    public Student getByfname(String fname){
        if(fname!=null)
        {
            return studentInterface.getByfname(fname);
        }
        return null;
    }

    public String deleteStudent(int id){
        boolean exists= studentInterface.existsById(id);
        if(!exists)
        {
            return "Student not Found";
        }
        else studentInterface.deleteById(id);
        return "Student Deleted";
    }

    public String deleteAllStudent(){
        studentInterface.deleteAll();
        return "Deleted All records";
    }

    public String updatefname(int id, String fname) {
        boolean exists = studentInterface.existsById(id);
        if (exists) {
            Student s = studentInterface.getReferenceById(id);
            s.setFname(fname);
            studentInterface.save(s);
            return "Fname updated";
        }
        return null;

    }






}
