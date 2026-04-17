/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gianelli.eventos.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author giane
 */
@Entity
@Table(name = "evento")
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 150)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "activo")
    private Boolean activo = true;

    public Evento() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

