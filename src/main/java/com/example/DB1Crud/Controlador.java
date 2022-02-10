package com.example.DB1Crud;

import com.example.DB1Crud.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class Controlador {
    @Autowired
    Servicio servicio;

    @GetMapping("buscarId/{id_persona}")//hay que llamar al parametro de la url igual que la variable que se declara en la signatura del método
    public ArrayList buscaId(@PathVariable int id_persona){
        System.out.println("La id recogida en la URL es esta: "+id_persona);
        ArrayList usuarios = new ArrayList();
        usuarios = servicio.buscarId(id_persona);
        return usuarios;
    }

    @GetMapping("buscarNombre/{usuario}")
    public ArrayList buscaNombre(@PathVariable String usuario){
        System.out.println("El nombre recogido en la URL es este: "+usuario);
        ArrayList usuarios = new ArrayList();
        usuarios = servicio.buscarUsuario(usuario);
        return (ArrayList) usuarios.stream()
                .map(i -> new PersonaOutputDTO((Persona) i))
                .collect(Collectors.toList());
    }
    @GetMapping("showAll")
    public ArrayList mostrarTodo(){
        ArrayList usuarios = servicio.mostrarTodo();
        return (ArrayList) usuarios.stream()
                .map(i -> new PersonaOutputDTO((Persona) i))
                .collect(Collectors.toList());
    }

    @PostMapping("/addPersona")
    public void addPersona(@RequestBody Persona p) throws Exception {
        System.out.println(p.toString());
        servicio.addPersona(p);
    }

    @DeleteMapping("/deletePersona/{id_persona}")
    public void deletePersona(@PathVariable int id_persona){
        servicio.delete(id_persona);
    }

    @PutMapping("/updatePersona/{id_persona}")
    public void updatePersona(@PathVariable int id_persona, @RequestBody Persona p) throws Exception {
        servicio.updatePersona(id_persona, p);
    }

}
