package org.generation.gestiondetareas.services;

import jakarta.transaction.Transactional;
import org.generation.gestiondetareas.models.Comentario;
import org.generation.gestiondetareas.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService{

    @Autowired
    ComentarioRepository comentarioRepository;


    @Override
    public Comentario crearComentario(Comentario nuevoComentario) {
        return comentarioRepository.save(nuevoComentario);
    }

    @Override
    public Comentario buscarComentarioPorId(Long id) {
        Boolean existe = comentarioRepository.existsById(id);

        if (existe) {
            Comentario comentarioEscogido = comentarioRepository.findById(id).get();
            return comentarioEscogido;
        } else {
            System.out.println("El id es inválido o no existe");
            return null;
        }

    }

    @Override
    public List<Comentario> listaDeComentario() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario editarComentarioPorId(Long id, Comentario comentarioActualizada) {
         Boolean existe = comentarioRepository.existsById(id);
         if (existe) {
             Comentario comentarioSeleccionada = comentarioRepository.findById(id).get();
             comentarioSeleccionada.setComentarioCreacion(comentarioActualizada.getComentarioCreacion());
             comentarioSeleccionada.setComentarioTexto(comentarioActualizada.getComentarioTexto());
             System.out.println("El comentario ha sido actualizado");
             return comentarioRepository.save(comentarioSeleccionada);
         }else {
             System.out.println("El comentario no existe o el id es inválido");
             return null;
         }
    }

    @Override
    public void borrarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }


}
