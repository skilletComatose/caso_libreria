package com.ceiba.biblioteca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.biblioteca.Utils.GlobalResponse;
import com.ceiba.biblioteca.dto.SolicitudPrestarLibro;
import com.ceiba.biblioteca.logic.Services.IPrestamoService;

@RestController
@RequestMapping("/prestamo")
public class PrestamoControlador {

    @Autowired
    IPrestamoService prestamoService;

    @PostMapping("")
    public ResponseEntity<?> prestamoLibroUsuarioAfiliado(@RequestBody SolicitudPrestarLibro solicitud){
        GlobalResponse r = this.prestamoService.hacerPrestamo(solicitud);
        return ResponseEntity.status(r.getCode()).body(r.getResponse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPrestamoLibroUsuarioAfiliadoById(@PathVariable int id){
        GlobalResponse r = this.prestamoService.buscarPorId(id);
        return ResponseEntity.status(r.getCode()).body(r.getResponse());
    }
}

