package com.example.casagariitaapi.repositories;

import com.example.casagariitaapi.models.Enums.TipoOperacion;
import com.example.casagariitaapi.models.Propiedad;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropiedadRepository extends BaseRepository<Propiedad, Long>, JpaSpecificationExecutor<Propiedad> {
    @Query("SELECT p FROM Propiedad p WHERE p.tipoOperacion = :tipoOperacion OR p.tipoOperacion = com.example.casagariitaapi.models.Enums.TipoOperacion.AMBOS")
    List<Propiedad> findByTipoOperacionIncludingAmbos(@Param("tipoOperacion") TipoOperacion tipoOperacion);
}