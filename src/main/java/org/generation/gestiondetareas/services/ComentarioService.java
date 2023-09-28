package org.generation.gestiondetareas.services;

import org.generation.gestiondetareas.models.Comentario;

import java.util.List;

public interface ComentarioService {

    Comentario crearComentario(Comentario nuevoComentario);

    Comentario buscarComentarioPorId(Long id);

    List<Comentario> listaDeComentario();

    Comentario editarComentarioPorId(Long id, Comentario comentarioActualizada);

    void borrarComentario(Long id);
}
