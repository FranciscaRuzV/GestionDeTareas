package org.generation.gestiondetareas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tarea")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Tarea {

    //⦁	id (generado automáticamente)
    //⦁	título
    //⦁	descripción
    //⦁	fecha de vencimiento


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tareaId;

    @NotNull
    private String tareaNombre;

    @NotNull
    private String tareaDescricion;

    @NotNull
    private String tareaVencimiento; //También se puede usar Date ...

    //Relaciones: Una tarea puede ser asignada a un usuario (relación Muchos a Uno),
    // una tarea puede tener muchos comentarios (relación Uno a Muchos)

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

}
