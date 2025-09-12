package com.example.casagariitaapi.controllers;

import com.example.casagariitaapi.models.ImagenPropiedad;
import com.example.casagariitaapi.services.ImagenPropiedadService;
import com.example.casagariitaapi.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/imagen_propiedad")
@RestController
public class ImagenPropiedadController extends BaseController<ImagenPropiedad> {

    public ImagenPropiedadController(ImagenPropiedadService imagenPropiedadService) {
        super(imagenPropiedadService);
    }
}
