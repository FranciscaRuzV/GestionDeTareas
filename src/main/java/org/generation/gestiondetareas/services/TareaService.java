package org.generation.gestiondetareas.services;

import org.generation.gestiondetareas.models.Comentario;
import org.generation.gestiondetareas.models.Tarea;

import java.util.List;

public interface TareaService {

    Tarea crearTarea(Tarea nuevaTarea);

    List<Tarea> enlistarTareas();

    Tarea editarTareaPorId(Long id, Tarea tareaActualizada);

    void borrarTarea(Long id);


}
