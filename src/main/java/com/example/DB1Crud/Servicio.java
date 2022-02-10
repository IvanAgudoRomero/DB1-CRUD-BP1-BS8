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
        if(usuarios.isEmpty()){
            System.out.println("No hay usuarios");
        }else{
            System.out.println("Persona devuelta");
        }
        return usuarios;
    }

    public ArrayList buscarUsuario(String usuario){
        ArrayList usuarios = new ArrayList();
        usuarios = personaRepo.findByUsuario(usuario);
        if(usuarios.isEmpty()){
            System.out.println("No hay usuarios");
        }else{
            System.out.println("Usuarios devueltos");
        }
        return usuarios;
    }

    public void addPersona(Persona p)throws Exception{
        if(p == null){
            System.out.println("La persona es nula");
        }else{
            if(p.usuario==null){
                throw new Exception("Usuario no puede ser nulo");
            }
            if(p.usuario.length()>10){
                throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");
            }
            if(p.password==null){
                throw new Exception("Password no puede ser nulo");
            }
            if(p.name==null){
                throw new Exception("name no puede ser nulo");
            }
            if(p.company_email==null){
                throw new Exception("company_email no puede ser nulo");
            }
            if(p.personal_email==null){
                throw new Exception("personal_email no puede ser nulo");
            }
            if(p.city==null){
                throw new Exception("city no puede ser nulo");
            }
            if(p.created_date==null){
                throw new Exception("created_date no puede ser nulo");
            }
            personaRepo.save(p);
            System.out.println("Persona guardada");
        }
    }

    public ArrayList mostrarTodo(){
        ArrayList usuarios = (ArrayList) personaRepo.findAll();
        if(usuarios.isEmpty()){
            System.out.println("no hay usuarios");
        }
        return usuarios;
    }

    public void delete(int id_persona){
        ArrayList usuarios = buscarId(id_persona);
        if(usuarios.isEmpty()){
            System.out.println("no hay usuarios con esa id");
        }else{
            personaRepo.deleteById(id_persona);
        }
    }

    public void updatePersona(int id_persona, Persona p) throws Exception {
        addPersona(p);
        delete(id_persona);

    }
}
