package org.generation.gestiondetareas.repositories;

import org.generation.gestiondetareas.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {


}
