/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gianelli.eventos.controllers;

import com.gianelli.eventos.domain.Usuario;
import com.gianelli.eventos.service.RolService;
import com.gianelli.eventos.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author giane
 */
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final RolService rolService;

    public UsuarioController(UsuarioService usuarioService, RolService rolService) {
        this.usuarioService = usuarioService;
        this.rolService = rolService;
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.listar());
        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("listaRoles", rolService.listar());
        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario,
                                 @RequestParam("rolId") Long rolId) {
        usuario.setRol(rolService.buscarPorId(rolId));
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        model.addAttribute("listaRoles", rolService.listar());
        return "usuarios/formulario";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalleUsuario(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        return "usuarios/detalle";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }
}