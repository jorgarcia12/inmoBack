package com.example.casagariitaapi.services;

import com.example.casagariitaapi.models.ImagenPropiedad;
import com.example.casagariitaapi.repositories.ImagenPropiedadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenPropiedadService extends BaseService<ImagenPropiedad> {

    private final ImagenPropiedadRepository imagenPropiedadRepository;

    public ImagenPropiedadService(ImagenPropiedadRepository imagenPropiedadRepository) {
        super(imagenPropiedadRepository); // Llama a BaseService
        this.imagenPropiedadRepository = imagenPropiedadRepository;
    }

    /**
     * Obtener todas las imágenes asociadas a una propiedad por su ID.
     */
    public List<ImagenPropiedad> obtenerImagenesPorPropiedad(Long propiedadId) {
        return imagenPropiedadRepository.findByPropiedadId(propiedadId);
    }

    /**
     * Guardar una nueva imagen asociada a una propiedad.
     */
    public ImagenPropiedad guardarImagen(ImagenPropiedad imagen) {
        return super.save(imagen); // usa el save del BaseService
    }

    /**
     * Eliminar una imagen de propiedad por su ID.
     */
    public void eliminarImagen(Long id) {
        super.deleteById(id); // usa el deleteById del BaseService
    }
}
