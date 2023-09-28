package org.generation.gestiondetareas.services;

import jakarta.transaction.Transactional;
import org.generation.gestiondetareas.models.Comentario;
import org.generation.gestiondetareas.models.Tarea;
import org.generation.gestiondetareas.models.Usuario;
import org.generation.gestiondetareas.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TareaServiceImpl implements TareaService {

    @Autowired
    TareaRepository tareaRepository;


    @Override
    public Tarea crearTarea(Tarea nuevaTarea) {
        return tareaRepository.save(nuevaTarea);
    }

    @Override
    public List<Tarea> enlistarTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea editarTareaPorId(Long id, Tarea tareaActualizada) {
        Boolean existe = tareaRepository.existsById(id);

       if (existe) {
           Tarea tareaSelecionada = tareaRepository.findById(id).get();
           tareaSelecionada.setTareaNombre(tareaActualizada.getTareaNombre());
           tareaSelecionada.setTareaDescricion(tareaActualizada.getTareaDescricion());
           tareaSelecionada.setTareaVencimiento(tareaActualizada.getTareaVencimiento());
           System.out.println("La tarea ha sido actualizada");
           return tareaRepository.save(tareaSelecionada);
       }else {
           System.out.println("La tarea no existe o el id es inválido");
           return null;
       }
    }

    @Override
    public void borrarTarea(Long id) {
        tareaRepository.deleteById(id);
    }


}
