package com.example.casagariitaapi.repositories;


import com.example.casagariitaapi.models.ImagenPropiedad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenPropiedadRepository extends BaseRepository<ImagenPropiedad, Long> {
    List<ImagenPropiedad> findByPropiedadId(Long propiedadId);
}
