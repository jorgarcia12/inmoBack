package com.example.casagariitaapi.controllers;


import com.example.casagariitaapi.models.Propiedad;
import com.example.casagariitaapi.services.PropiedadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/propiedad")
@RestController
public class PropiedadController extends BaseController<Propiedad> {

    private final PropiedadService propiedadService;

    public PropiedadController(PropiedadService propiedadService) {
        super(propiedadService);
        this.propiedadService = propiedadService;
    }


    @Override
    @PostMapping
    public ResponseEntity<Propiedad> create(@RequestBody Propiedad p) {
        Propiedad creada = propiedadService.crearPropiedad(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }
}
