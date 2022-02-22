package com.example.DB1Crud.Controladores;

import com.example.DB1Crud.DTOs.input.StudentInputDTO;
import com.example.DB1Crud.DTOs.output.SimpleStudentOutputDTO;
import com.example.DB1Crud.Excepciones.NotFoundException;
import com.example.DB1Crud.POJOs.Student;
import com.example.DB1Crud.DTOs.output.StudentOutputDTO;
import com.example.DB1Crud.Servicios.StudentServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class ControladorStudent {
    @Autowired
    StudentServicio studentServicio;

    @GetMapping("student/buscarId/{id_student}")
    public List<StudentOutputDTO> buscarId(@PathVariable int id_student, @RequestParam String outputType){
        if(outputType==""){
            outputType="simple";
        }
        if(outputType.equals("simple")){
            Optional<Student> estudiantes = studentServicio.buscarId(id_student);
            return (List) estudiantes.stream()
                    .map(i -> new SimpleStudentOutputDTO((Student) i))
                    .collect(Collectors.toList());
        }else if(outputType.equals("full")){
            Optional<Student> estudiantes = studentServicio.buscarId(id_student);

            return (List) estudiantes.stream()
                    .map(i -> new StudentOutputDTO((Student) i))
                    .collect(Collectors.toList());
        }else {
            throw new NotFoundException("No se encuentra una solicitud con ese parámetro");
        }
    }

    @GetMapping("student/showAll")
    public List<StudentOutputDTO> mostrarTodo(){
        List<Student> estudiantes = studentServicio.mostrarTodo();
        return (List) estudiantes.stream()
                .map(i -> new StudentOutputDTO((Student) i))
                .collect(Collectors.toList());
    }

    @PostMapping("student/addStudent")
    public void addStudent(@RequestBody StudentInputDTO s) throws Exception{
        //Student st = new Student();
        System.out.println(s.toString());
        studentServicio.addStudent(s);
    }

    @DeleteMapping("student/deleteStudent/{id_student}")
    public void deletePersona(@PathVariable int id_student){
        studentServicio.delete(id_student);
    }

    @PutMapping("persona/updateStudent/{id_student}")
    public void updateStudent(@PathVariable int id_student, @RequestBody StudentInputDTO s) throws Exception{
        studentServicio.updateStudent(id_student, s);
    }
}
