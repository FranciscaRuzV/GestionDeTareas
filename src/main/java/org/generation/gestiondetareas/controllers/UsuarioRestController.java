package org.generation.gestiondetareas.controllers;

import org.generation.gestiondetareas.models.Usuario;
import org.generation.gestiondetareas.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/lista")
    public List<Usuario> listaUsuarios() {
        List<Usuario> listaMostrar = usuarioService.listaDeUsuarios();
        return listaMostrar;
    }

    @GetMapping("/nombre/{nombre}")
    public Usuario buscarPorNombre(@PathVariable String nombre){
        Usuario usuarioElegido = usuarioService.buscarUsuarioPorNombre(nombre);
        System.out.println(usuarioElegido);
        return usuarioElegido;
    }

    @PostMapping("/nuevo")
    public Usuario guardarNuevoUsuario(@RequestBody Usuario usuarioNuevo) {
        Usuario usuarioParaGuardar = usuarioService.guardarUsuario(usuarioNuevo);
        return usuarioParaGuardar;
    }

    @PutMapping("/editar/{id}")
    public Usuario editarUsuarioPorId(@PathVariable Long id,
                                      @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id, usuarioActualizado);
        return usuarioEditado;
    }


    @DeleteMapping("/borrar")//localhost:8080/usuario/borrar?id=2
    public String borrarUsuarioPorId(@RequestParam Long id) {
        usuarioService.borrarUsuario(id);
        return "El usuario ha sido borrado";
    }






}
