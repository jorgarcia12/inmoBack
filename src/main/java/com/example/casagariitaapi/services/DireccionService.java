package com.example.casagariitaapi.services;

import com.example.casagariitaapi.models.Direccion;
import com.example.casagariitaapi.repositories.DireccionRepository;
import org.springframework.stereotype.Service;

@Service
public class DireccionService extends BaseService<Direccion> {
    public DireccionService(DireccionRepository repository) {
        super(repository);
    }
}
