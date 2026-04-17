/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gianelli.eventos.service;

import com.gianelli.eventos.domain.Evento;
import com.gianelli.eventos.repository.EventoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
/**
 *
 * @author giane
 */

@Service
public class EventoServiceImpl implements EventoService {

    private final EventoRepository eventoRepository;

    public EventoServiceImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento guardar(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        eventoRepository.deleteById(id);
    }

    @Override
    public List<Evento> buscarPorEstado(Boolean activo) {
        return eventoRepository.findByActivo(activo);
    }

    @Override
    public List<Evento> buscarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return eventoRepository.findByFechaBetween(inicio, fin);
    }

    @Override
    public List<Evento> buscarPorNombre(String nombre) {
        return eventoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public long contarEventosActivos() {
        return eventoRepository.countByActivoTrue();
    }
}

