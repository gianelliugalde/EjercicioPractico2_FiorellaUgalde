/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gianelli.eventos.service;

import com.gianelli.eventos.domain.Usuario;
import com.gianelli.eventos.repository.UsuarioRepository;
import java.util.List;
import org.springframework.stereotype.Service;
/**
 *
 * @author giane
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CorreoService correoService;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, CorreoService correoService) {
        this.usuarioRepository = usuarioRepository;
        this.correoService = correoService;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        boolean esNuevo = (usuario.getId() == null);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        if (esNuevo) {
            correoService.enviarCorreo(
                usuarioGuardado.getEmail(),
                "Bienvenido a la plataforma",
                "Hola " + usuarioGuardado.getNombre() + ", tu usuario fue creado correctamente."
            );
        }

        return usuarioGuardado;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> buscarPorRol(String rol) {
        return usuarioRepository.findByRolNombre(rol);
    }
}