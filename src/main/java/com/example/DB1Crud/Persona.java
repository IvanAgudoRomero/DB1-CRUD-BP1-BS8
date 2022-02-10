package com.example.DB1Crud;

import com.example.DB1Crud.dto.PersonaInputDTO;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    int id_persona;

    @NonNull
    @Column(name = "usuario")
    String usuario;

    @NonNull
    @Column(name = "password")
    String password;

    @NonNull
    @Column(name = "name")
    String name;

    @NonNull
    @Column(name = "surname")
    String surname;

    @NonNull
    @Column(name = "company_email")
    String company_email;

    @NonNull
    @Column(name = "personal_email")
    String personal_email;

    @NonNull
    @Column(name = "city")
    String city;

    @NonNull
    @Column(name = "active")
    boolean active;

    @NonNull
    @Column(name = "created_date")
    Date created_date;

    @NonNull
    @Column(name = "imagen_url")
    String imagen_url;

    @NonNull
    @Column(name = "termination_date")
    Date termination_date;

    public Persona(PersonaInputDTO personaDTO) {
        setId_persona(personaDTO.getId_persona());
        setUsuario(personaDTO.getUsuario());
        setPassword(personaDTO.getPassword());
        setName(personaDTO.getName());
        setSurname(personaDTO.getSurname());
        setCompany_email(personaDTO.getCompany_email());
        setPersonal_email(personaDTO.getPersonal_email());
        setCity(personaDTO.getCity());
        setActive(personaDTO.isActive());
        setCreated_date(personaDTO.getCreated_date());
        setImagen_url(personaDTO.getImagen_url());
        setTermination_date(personaDTO.getTermination_date());
    }

    public Persona() {
    }


}
