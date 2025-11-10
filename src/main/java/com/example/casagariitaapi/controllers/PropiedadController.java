package com.example.casagariitaapi.controllers;


import com.example.casagariitaapi.models.Enums.Estado;
import com.example.casagariitaapi.models.Enums.TipoOperacion;
import com.example.casagariitaapi.models.Enums.TipoPropiedad;
import com.example.casagariitaapi.models.Propiedad;
import com.example.casagariitaapi.services.PropiedadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
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

    @PutMapping("/{id}")
    public ResponseEntity<Propiedad> update(@PathVariable Long id, @RequestBody Propiedad p) {
        log.info("Actualizando propiedad ID: {}", id);
        log.info("Divisa recibida: {}", p.getDivisa());
        log.info("Precio recibido: {}", p.getPrecio());
        Propiedad actualizada = propiedadService.actualizarPropiedad(id, p);
        return ResponseEntity.ok(actualizada);
    }

    @PatchMapping("/{id}/publicar")
    public ResponseEntity<Propiedad> togglePublicada(
            @PathVariable Long id,
            @RequestParam boolean publicada
    ) {
        Propiedad actualizada = propiedadService.togglePublicada(id, publicada);
        return ResponseEntity.ok(actualizada);
    }

    @GetMapping("/filtros")
    public ResponseEntity<List<Propiedad>> filtrar(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) BigDecimal precioMin,
            @RequestParam(required = false) BigDecimal precioMax,
            @RequestParam(required = false) TipoOperacion tipoOperacion,
            @RequestParam(required = false) TipoPropiedad tipoPropiedad,
            @RequestParam(required = false) Estado estado,
            @RequestParam(required = false) Integer habitaciones,
            @RequestParam(required = false) Integer cantidadAmbientes,
            @RequestParam(required = false) Integer cantidadBanos,

            @RequestParam(required = false) Boolean publicada,

            @RequestParam(required = false) Boolean barrioPriv,
            @RequestParam(required = false) Boolean patio,
            @RequestParam(required = false) Boolean cochera,
            @RequestParam(required = false) Boolean permuta,
            @RequestParam(required = false) Boolean servicios,
            @RequestParam(required = false) Boolean amoblado,
            @RequestParam(required = false) Boolean pileta,
            @RequestParam(required = false) Boolean aptProf
    ) {
        List<Propiedad> resultado = propiedadService.filtrarPropiedades(
                titulo,
                precioMin,
                precioMax,
                tipoOperacion,
                tipoPropiedad,
                estado,
                habitaciones,
                cantidadAmbientes,
                cantidadBanos,

                publicada,

                barrioPriv,
                patio,
                cochera,
                permuta,
                servicios,
                amoblado,
                pileta,
                aptProf
        );
        return ResponseEntity.ok(resultado);
    }


}
