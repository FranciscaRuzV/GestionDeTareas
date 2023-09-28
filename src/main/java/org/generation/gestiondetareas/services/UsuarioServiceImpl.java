package org.generation.gestiondetareas.services;

import jakarta.transaction.Transactional;
import org.generation.gestiondetareas.models.Usuario;
import org.generation.gestiondetareas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listaDeUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Boolean existe = usuarioRepository.existsById(id);

        if (existe) {
            Usuario usuarioEscogido = usuarioRepository.findById(id).get();
            return usuarioEscogido;
        }else {
            System.out.println("El id es inváñido o no existe");
            return null;
        }

    }

    @Override
    public Usuario guardarUsuario(Usuario usuarioNuevo) {

        return usuarioRepository.save(usuarioNuevo);
    }

    @Override
    public void borrarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado) {
        Boolean existe = usuarioRepository.existsById(id);

        if (existe){
            Usuario usuarioSeleccionado = usuarioRepository.findById(id).get();
            usuarioSeleccionado.setUsuarioNombre(usuarioActualizado.getUsuarioNombre());
            usuarioSeleccionado.setEmail(usuarioActualizado.getEmail());
            System.out.println("El usuario ha sido actualizado");
            return usuarioRepository.save(usuarioSeleccionado);
        }else{
            System.out.println("El usuario no existe o el id es inválido");
            return null;
        }
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        Usuario usuarioPorNombre = usuarioRepository.findUsuarioByUsuarioNombre(nombre);
        return usuarioPorNombre;
    }



}
