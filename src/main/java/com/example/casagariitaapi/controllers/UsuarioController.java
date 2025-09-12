package com.example.casagariitaapi.controllers;


import com.example.casagariitaapi.models.Usuario;
import com.example.casagariitaapi.services.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuario")
@RestController
public class UsuarioController extends BaseController<Usuario> {

    public UsuarioController(UsuarioService usuarioService) {
        super(usuarioService);
    }
}
