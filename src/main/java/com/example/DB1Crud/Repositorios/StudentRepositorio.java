package com.example.DB1Crud.Repositorios;

import com.example.DB1Crud.POJOs.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Component
@Repository
public interface StudentRepositorio extends JpaRepository<Student, Integer> {
    public ArrayList<Student> findById(int id_student);
    public void deleteById(int id_persona);
}
