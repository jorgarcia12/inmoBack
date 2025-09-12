package com.example.casagariitaapi.repositories;


import com.example.casagariitaapi.models.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
}
