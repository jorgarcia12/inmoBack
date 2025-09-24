package com.example.casagariitaapi.controllers;

import com.example.casagariitaapi.models.ImagenPropiedad;
import com.example.casagariitaapi.services.ImagenPropiedadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/imagen_propiedad")
@RestController
public class ImagenPropiedadController extends BaseController<ImagenPropiedad> {

    private final ImagenPropiedadService imagenPropiedadService;

    public ImagenPropiedadController(ImagenPropiedadService imagenPropiedadService) {
        super(imagenPropiedadService);
        this.imagenPropiedadService = imagenPropiedadService;
    }

    // Endpoint para eliminar imagen por ID
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        imagenPropiedadService.eliminarImagen(id);
        return ResponseEntity.noContent().build();
    }

}

