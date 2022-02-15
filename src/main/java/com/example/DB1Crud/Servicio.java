package com.example.DB1Crud;

import com.example.DB1Crud.infrastructure.repository.jpa.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio {
    @Autowired
    PersonaRepositorio personaRepo;

    public ArrayList buscarId(int id_persona){
        ArrayList usuarios = new ArrayList();
        usuarios = personaRepo.findById(id_persona);
        System.out.println("usuarios en el arraylist: "+usuarios);
        if(usuarios==null){
            throw new NotFoundException("No hay usuarios");
        }else{
            System.out.println("Persona devuelta");
        }
        return usuarios;
    }

    public ArrayList buscarUsuario(String usuario){
        ArrayList usuarios = new ArrayList();
        usuarios = personaRepo.findByUsuario(usuario);
        if(usuarios==null){
            throw new NotFoundException("No hay usuarios");
        }else{
            System.out.println("Usuarios devueltos");
        }
        return usuarios;
    }

    public void addPersona(Persona p)throws Exception{
        boolean error = false;
        if(p == null){
            System.out.println("La persona es nula");
        }else{
            if(p.usuario==null){
                throw new UnprocessableEntityException("Usuario no puede ser nulo");
            }
            if(p.usuario.length()>10){
                throw new UnprocessableEntityException("Longitud de usuario no puede ser superior a 10 caracteres");
            }
            if(p.password==null){
                throw new UnprocessableEntityException("Password no puede ser nulo");
            }
            if(p.name==null){
                throw new UnprocessableEntityException("name no puede ser nulo");
            }
            if(p.company_email==null){
                throw new UnprocessableEntityException("company_email no puede ser nulo");
            }
            if(p.personal_email==null){
                throw new UnprocessableEntityException("personal_email no puede ser nulo");
            }
            if(p.city==null){
                throw new UnprocessableEntityException("city no puede ser nulo");
            }
            if(p.created_date==null){
                throw new UnprocessableEntityException("created_date no puede ser nulo");
            }

            personaRepo.save(p);
            System.out.println("Persona guardada");

        }
    }

    public ArrayList mostrarTodo(){
        ArrayList usuarios = new ArrayList(personaRepo.findAll());
        //ArrayList usuarios = (ArrayList) personaRepo.findAll();
        if(usuarios.isEmpty()){
            throw new NotFoundException("No hay usuarios");
        }
        return usuarios;
    }

    public void delete(int id_persona){
        ArrayList usuarios = buscarId(id_persona);
        if(usuarios==null){
            throw new NotFoundException("No hay usuarios");
        }else{
            personaRepo.deleteById(id_persona);
        }
    }

    public void updatePersona(int id_persona, Persona p) throws Exception {
        addPersona(p);        //Primerso se añade y despues se borra porque en el metodo de añadir persona
        delete(id_persona);   //se comprueba que exista para evitar que se borren los datos al pasar una persona nula
    }
}
