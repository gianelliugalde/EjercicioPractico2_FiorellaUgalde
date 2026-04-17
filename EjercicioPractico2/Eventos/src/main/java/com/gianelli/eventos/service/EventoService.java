/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gianelli.eventos.service;

import com.gianelli.eventos.domain.Evento;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author giane
 */
public interface EventoService {
    List<Evento> listar();
    Evento guardar(Evento evento);
    Evento buscarPorId(Long id);
    void eliminar(Long id);
    List<Evento> buscarPorEstado(Boolean activo);
    List<Evento> buscarPorRangoFechas(LocalDate inicio, LocalDate fin);
    List<Evento> buscarPorNombre(String nombre);
    long contarEventosActivos();
}

