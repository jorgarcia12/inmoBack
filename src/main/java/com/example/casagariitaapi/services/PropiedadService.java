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
}
