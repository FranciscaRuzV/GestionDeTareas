package org.generation.gestiondetareas.controllers;

import org.generation.gestiondetareas.models.Comentario;
import org.generation.gestiondetareas.models.Tarea;
import org.generation.gestiondetareas.repositories.ComentarioRepository;
import org.generation.gestiondetareas.services.ComentarioService;
import org.generation.gestiondetareas.services.ComentarioServiceImpl;
import org.generation.gestiondetareas.services.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioRestController {

    @Autowired
    ComentarioServiceImpl comentarioService;


    @PostMapping("/nuevo")
    public Comentario crearComentario(@RequestBody Comentario nuevoComentario) {
        return comentarioService.crearComentario(nuevoComentario);
    }

    @GetMapping("/{id}")
    public Comentario ComentarioPorId(@PathVariable Long id) {
       Comentario comentarioMostrar = comentarioService.buscarComentarioPorId(id);
       return comentarioMostrar;
    }

    @GetMapping("/lista")
    public List<Comentario> listaComentarios() {
        List<Comentario> listaMostrar = comentarioService.listaDeComentario();
        return listaMostrar;
    }

    @PutMapping("/editar/{id}")
    public Comentario editarComentarioPorId(@PathVariable Long id,
                                            @RequestBody Comentario comentarioActualizada){
        Comentario comentarioEditado = comentarioService.editarComentarioPorId(id, comentarioActualizada);
        return comentarioEditado;
    }

    @DeleteMapping("/borrar")
    public String borrarComentarioPorId(@RequestParam Long id) {
        comentarioService.borrarComentario(id);
        return "El comentario ha sido borrado";
    }





}
