package com.example.DB1Crud.Servicios;

import com.example.DB1Crud.DTOs.input.StudentInputDTO;
import com.example.DB1Crud.Excepciones.NotFoundException;
import com.example.DB1Crud.POJOs.Student;
import com.example.DB1Crud.Repositorios.StudentRepositorio;
import com.example.DB1Crud.Excepciones.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServicio {
    @Autowired
    StudentRepositorio studentRepositorio;

    public ArrayList buscarId(int id_student){
        ArrayList estudiantes = studentRepositorio.findById(id_student);
        return estudiantes;
    }

    public ArrayList mostrarTodo(){
        ArrayList students = new ArrayList(studentRepositorio.findAll());
        if(students.isEmpty()){
            throw new NotFoundException("No hay usuarios");
        }
        return students;
    }

    public void addStudent(StudentInputDTO student)throws Exception{
        if(student==null){
            throw new UnprocessableEntityException("El estudiante es nulo");
        }else{
            Student st = new Student(student);
            studentRepositorio.save(st);
            System.out.println("Estudiante guardado");
        }
    }

    public void delete(int id_student) {
        studentRepositorio.deleteById(id_student);
    }

    public void updateStudent(int id_student, Student s) throws Exception{
       // addStudent(s);
        delete(id_student);
    }
}
