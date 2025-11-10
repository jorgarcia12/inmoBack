package com.example.casagariitaapi.services;


import com.example.casagariitaapi.models.Enums.Estado;
import com.example.casagariitaapi.models.Enums.TipoOperacion;
import com.example.casagariitaapi.models.Enums.TipoPropiedad;
import com.example.casagariitaapi.models.Propiedad;
import com.example.casagariitaapi.repositories.PropiedadRepository;


import com.example.casagariitaapi.specifications.PropiedadSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
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
        log.info("Actualizando propiedad ID: {}", id);
        log.info("Divisa recibida: {}", nuevaPropiedad.getDivisa());
        log.info("Precio recibido: {}", nuevaPropiedad.getPrecio());
        Propiedad existente = propiedadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

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
        existente.setPublicada(nuevaPropiedad.isPublicada());
        existente.setDivisa(nuevaPropiedad.getDivisa());

        if (nuevaPropiedad.getImagenes() != null && !nuevaPropiedad.getImagenes().isEmpty()) {
            nuevaPropiedad.getImagenes().forEach(img -> img.setPropiedad(existente));
            existente.getImagenes().addAll(nuevaPropiedad.getImagenes());
        }

        return propiedadRepository.save(existente);
    }

    @Transactional
    public Propiedad togglePublicada(Long id, boolean publicada) {
        Propiedad existente = propiedadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));
        existente.setPublicada(publicada);
        return propiedadRepository.save(existente);
    }

    @Transactional
    public List<Propiedad> filtrarPropiedades(
            String titulo,
            BigDecimal precioMin,
            BigDecimal precioMax,
            TipoOperacion tipoOperacion,
            TipoPropiedad tipoPropiedad,
            Estado estado,
            Integer habitaciones,
            Integer cantidadAmbientes,
            Integer cantidadBanos,
            Boolean publicada,
            Boolean barrioPriv,
            Boolean patio,
            Boolean cochera,
            Boolean permuta,
            Boolean servicios,
            Boolean amoblado,
            Boolean pileta,
            Boolean aptProf
    ) {
        Specification<Propiedad> spec = PropiedadSpecification.filtro(
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

        return propiedadRepository.findAll(spec);
    }


}
