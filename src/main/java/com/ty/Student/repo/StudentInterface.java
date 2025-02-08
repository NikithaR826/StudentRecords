package com.ty.Student.repo;

import com.ty.Student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInterface extends JpaRepository<Student, Integer> {

    public Student getByfname(String fname);

    @Query(value = "select lname from student s where s.Id=?1", nativeQuery = true)
    public String getFname(int id);
}
