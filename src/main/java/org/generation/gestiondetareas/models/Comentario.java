package org.generation.gestiondetareas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Entity
@Table(name = "comentario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Comentario {

    //⦁	id (generado automáticamente)
    //⦁	texto
    //⦁	fecha de creación


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioId;

    @NotNull
    private String comentarioTexto;

    @NotNull
    private String comentarioCreacion; //También se puede usar Date pero usa un formato muy especifico


    //Relaciones: Muchos comentarios pueden pertenecer a una tarea (relación Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;


}
