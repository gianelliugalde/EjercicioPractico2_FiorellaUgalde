/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gianelli.eventos.controllers;

import com.gianelli.eventos.service.EventoService;
import com.gianelli.eventos.service.UsuarioService;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author giane
 */

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final EventoService eventoService;
    private final UsuarioService usuarioService;

    public ConsultaController(EventoService eventoService, UsuarioService usuarioService) {
        this.eventoService = eventoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String mostrarConsultas() {
        return "consultas/lista";
    }

    @GetMapping("/eventos-activos")
    public String verEventosActivos(Model model) {
        model.addAttribute("titulo", "Eventos activos");
        model.addAttribute("resultadosEventos", eventoService.buscarPorEstado(true));
        return "consultas/resultados-eventos";
    }

    @GetMapping("/eventos-por-nombre")
    public String verEventosPorNombre(@RequestParam String nombre, Model model) {
        model.addAttribute("titulo", "Eventos por nombre");
        model.addAttribute("resultadosEventos", eventoService.buscarPorNombre(nombre));
        return "consultas/resultados-eventos";
    }

    @GetMapping("/eventos-por-fecha")
    public String verEventosPorFecha(@RequestParam String inicio,
                                     @RequestParam String fin,
                                     Model model) {
        model.addAttribute("titulo", "Eventos por rango de fechas");
        model.addAttribute("resultadosEventos",
                eventoService.buscarPorRangoFechas(LocalDate.parse(inicio), LocalDate.parse(fin)));
        return "consultas/resultados-eventos";
    }
}

