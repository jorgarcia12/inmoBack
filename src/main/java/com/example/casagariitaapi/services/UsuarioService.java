package com.example.casagariitaapi.services;


import com.example.casagariitaapi.models.Usuario;
import com.example.casagariitaapi.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario> {
    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }
}
