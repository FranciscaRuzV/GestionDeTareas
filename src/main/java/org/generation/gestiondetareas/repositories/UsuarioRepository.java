package org.generation.gestiondetareas.repositories;

import org.generation.gestiondetareas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioByUsuarioNombre(String nombreUsuario);


}
