package com.example.casagariitaapi.repositories;

import com.example.casagariitaapi.models.Propiedad;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PropiedadRepository extends BaseRepository<Propiedad, Long>, JpaSpecificationExecutor<Propiedad> {
}