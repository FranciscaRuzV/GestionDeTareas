package org.generation.gestiondetareas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Usuario {

    //⦁	id (generado automáticamente)
    //⦁	nombre de usuario
    //⦁	correo electrónico


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;


    @NotNull(message = "Debe ingresar su nombre")
    private String usuarioNombre;

    @Email(message = "introdujiste un mail erróneo")
    @NotNull
    private String email;

    //Relaciones: Un usuario puede tener muchas tareas (relación Uno a Muchos)

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Tarea> tareas;


}
