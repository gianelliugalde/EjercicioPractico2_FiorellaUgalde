/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gianelli.eventos.service;

import com.gianelli.eventos.domain.Rol;
import java.util.List;
/**
 *
 * @author giane
 */
public interface RolService {
    List<Rol> listar();
    Rol guardar(Rol rol);
    Rol buscarPorId(Long id);
    void eliminar(Long id);
}  

