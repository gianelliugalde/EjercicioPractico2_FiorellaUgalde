/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gianelli.eventos.service;

import com.gianelli.eventos.domain.Usuario;
import java.util.List;

/**
 *
 * @author giane
 */
public interface UsuarioService {

    List<Usuario> listar();

    Usuario guardar(Usuario usuario);

    Usuario buscarPorId(Long id);

    void eliminar(Long id);

    List<Usuario> buscarPorRol(String rol);
}
