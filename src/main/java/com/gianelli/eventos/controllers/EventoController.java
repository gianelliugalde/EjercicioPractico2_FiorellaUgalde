/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gianelli.eventos.controllers;

import com.gianelli.eventos.domain.Evento;
import com.gianelli.eventos.service.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author giane
 */
@Controller
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public String listarEventos(Model model) {
        model.addAttribute("listaEventos", eventoService.listar());
        return "eventos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("evento", new Evento());
        return "eventos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEvento(@ModelAttribute Evento evento) {
        eventoService.guardar(evento);
        return "redirect:/eventos";
    }

    @GetMapping("/editar/{id}")
    public String editarEvento(@PathVariable Long id, Model model) {
        model.addAttribute("evento", eventoService.buscarPorId(id));
        return "eventos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        eventoService.eliminar(id);
        return "redirect:/eventos";
    }
}

