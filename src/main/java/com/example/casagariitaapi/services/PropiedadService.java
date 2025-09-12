package com.example.casagariitaapi.services;


import com.example.casagariitaapi.models.Propiedad;
import com.example.casagariitaapi.repositories.PropiedadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropiedadService extends BaseService<Propiedad> {

    private final PropiedadRepository propiedadRepository;

    public PropiedadService(PropiedadRepository propiedadRepository) {
        super(propiedadRepository);
        this.propiedadRepository = propiedadRepository;
    }

    @Transactional
    public Propiedad crearPropiedad(Propiedad propiedad) {
        propiedad.getImagenes().forEach(img -> img.setPropiedad(propiedad));
        return propiedadRepository.save(propiedad);
    }

    @Transactional
    public Propiedad actualizarPropiedad(Long id, Propiedad nuevaPropiedad) {
        Propiedad existente = propiedadRepository.findById(id).orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

        existente.setTitulo(nuevaPropiedad.getTitulo());
        existente.setDescripcion(nuevaPropiedad.getDescripcion());
        existente.setPrecio(nuevaPropiedad.getPrecio());
        existente.setSupCubierta(nuevaPropiedad.getSupCubierta());
        existente.setSupTotal(nuevaPropiedad.getSupTotal());
        existente.setCantidadHabitaciones(nuevaPropiedad.getCantidadHabitaciones());
        existente.setCantidadAmbientes(nuevaPropiedad.getCantidadAmbientes());
        existente.setCantidadBanos(nuevaPropiedad.getCantidadBanos());
        existente.setEstado(nuevaPropiedad.getEstado());
        existente.setTipoOperacion(nuevaPropiedad.getTipoOperacion());
        existente.setTipoPropiedad(nuevaPropiedad.getTipoPropiedad());
        existente.setDireccion(nuevaPropiedad.getDireccion());


        if (nuevaPropiedad.getImagenes() != null && !nuevaPropiedad.getImagenes().isEmpty()) {
            nuevaPropiedad.getImagenes().forEach(img -> img.setPropiedad(existente));
            existente.getImagenes().addAll(nuevaPropiedad.getImagenes());
        }
        return propiedadRepository.save(existente);
    }

}
