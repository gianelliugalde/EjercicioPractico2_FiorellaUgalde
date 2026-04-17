/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gianelli.eventos.controllers;

import com.gianelli.eventos.domain.Rol;
import com.gianelli.eventos.service.RolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author giane
 */
@Controller
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public String listarRoles(Model model) {
        model.addAttribute("listaRoles", rolService.listar());
        return "roles/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles/formulario";
    }

    @PostMapping("/guardar")
    public String guardarRol(@ModelAttribute Rol rol) {
        rolService.guardar(rol);
        return "redirect:/roles";
    }

    @GetMapping("/editar/{id}")
    public String editarRol(@PathVariable Long id, Model model) {
        model.addAttribute("rol", rolService.buscarPorId(id));
        return "roles/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRol(@PathVariable Long id) {
        rolService.eliminar(id);
        return "redirect:/roles";
    }
}

