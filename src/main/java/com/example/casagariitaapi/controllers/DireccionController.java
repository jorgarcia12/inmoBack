package com.example.casagariitaapi.controllers;

import com.example.casagariitaapi.models.Direccion;
import com.example.casagariitaapi.services.DireccionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direccion")
public class DireccionController extends BaseController<Direccion> {
    public DireccionController(DireccionService direccionService) {
        super(direccionService);
    }
}
