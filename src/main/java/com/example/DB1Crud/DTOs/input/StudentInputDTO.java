package com.example.DB1Crud.DTOs.input;

import com.example.DB1Crud.Excepciones.NotFoundException;
import com.example.DB1Crud.POJOs.Student;
import com.example.DB1Crud.Repositorios.*;
import com.example.DB1Crud.Servicios.PersonaServicio;
import com.example.DB1Crud.Servicios.ProfesorServicio;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class StudentInputDTO{
    /*
    @Autowired
    PersonaRepositorio personaRepositorio; //igual solo se puede llamar desde un sitio o solo se le puede hacer un autowired?

    PersonaServicio ps;

    @Autowired
    ProfesorRepositorio profesorRepositorio;
*/
    PersonaServicio personaServicio = new PersonaServicio();
    ProfesorServicio profesorServicio = new ProfesorServicio();

    Integer id_student;
    Integer id_persona;
    Integer num_hours_week;
    String coments;
    Integer id_profesor;
    String branch;
    List estudios;

    public Student estudiante() throws NotFoundException {
        Student estudiante = new Student();
        estudiante.setId_student(this.getId_student());
        estudiante.setPersona(personaServicio.buscarId(this.getId_persona()).orElseThrow(() -> new NotFoundException()));
        estudiante.setNum_hours_week(this.getNum_hours_week());
        estudiante.setComents(this.getComents());
        estudiante.setProfesor(profesorServicio.buscarId(this.getId_profesor()).orElseThrow(() -> new NotFoundException()));
        estudiante.setBranch(this.getBranch());
        estudiante.setEstudios(this.getEstudios());
        return estudiante;
        //recibir input dto por el controlador que solo tiene atributos primitivos no objetos
        //lo que se recibe en el controlador se mapea a un objeto de la capa de dominio si es profesor a partir de la id obtener el profesor entero y luego persistirlo
    }
}
/*
* Cómo hago para devolver una persona a partir de su id desde aquí?
* */