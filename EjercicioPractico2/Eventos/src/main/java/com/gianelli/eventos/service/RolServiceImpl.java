/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gianelli.eventos.service;

import com.gianelli.eventos.domain.Rol;
import com.gianelli.eventos.repository.RolRepository;
import java.util.List;
import org.springframework.stereotype.Service;
/**
 *
 * @author giane
 */
@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol buscarPorId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }
}

