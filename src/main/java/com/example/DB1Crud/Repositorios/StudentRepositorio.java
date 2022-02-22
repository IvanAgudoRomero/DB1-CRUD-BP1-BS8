package com.example.DB1Crud.Repositorios;

import com.example.DB1Crud.POJOs.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface StudentRepositorio extends JpaRepository<Student, Integer> {
    //public Optional<Student> findById(int id_student);
    //@Query("delete from student where student.id_student=?1")
    //public void deleteById(int id_persona);
}
