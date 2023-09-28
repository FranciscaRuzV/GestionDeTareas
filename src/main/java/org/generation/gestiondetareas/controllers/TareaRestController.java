package org.generation.gestiondetareas.controllers;

import org.generation.gestiondetareas.models.Comentario;
import org.generation.gestiondetareas.models.Tarea;
import org.generation.gestiondetareas.models.Usuario;
import org.generation.gestiondetareas.services.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaRestController {

    @Autowired
    TareaServiceImpl tareaService;

    @GetMapping("/lista")
    public List<Tarea> enlistarTareas(){
         return tareaService.enlistarTareas();
    }


    @PostMapping("/nueva")
    public Tarea crearTarea(@RequestBody Tarea nuevaTarea) {
        return tareaService.crearTarea(nuevaTarea);
    }

    @PutMapping("/editar/{id}")
    public Tarea editarTareaPorId(@PathVariable Long id,
                                  @RequestBody Tarea tareaActualizado) {
        Tarea tareaEditado = tareaService.editarTareaPorId(id, tareaActualizado);
        return tareaEditado;
    }

    @DeleteMapping("/borrar")//localhost:8080/usuario/borrar?id=2
    public String borrarTareaPorId(@RequestParam Long id) {
        tareaService.borrarTarea(id);
        return "La tarea ha sido borrada";
    }



}
