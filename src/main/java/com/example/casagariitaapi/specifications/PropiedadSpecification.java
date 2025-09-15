package com.example.casagariitaapi.specifications;

import com.example.casagariitaapi.models.Enums.Estado;
import com.example.casagariitaapi.models.Enums.TipoOperacion;
import com.example.casagariitaapi.models.Enums.TipoPropiedad;
import com.example.casagariitaapi.models.Propiedad;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PropiedadSpecification {

    public static Specification<Propiedad> filtro(
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
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (titulo != null && !titulo.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("titulo")), "%" + titulo.toLowerCase() + "%"));
            }

            if (precioMin != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("precio"), precioMin));
            }

            if (precioMax != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("precio"), precioMax));
            }

            if (tipoOperacion != null) {
                predicates.add(cb.equal(root.get("tipoOperacion"), tipoOperacion));
            }

            if (tipoPropiedad != null) {
                predicates.add(cb.equal(root.get("tipoPropiedad"), tipoPropiedad));
            }

            if (estado != null) {
                predicates.add(cb.equal(root.get("estado"), estado));
            }

            if (habitaciones != null) {
                predicates.add(cb.equal(root.get("cantidadHabitaciones"), habitaciones));
            }

            if (cantidadAmbientes != null) {
                predicates.add(cb.equal(root.get("cantidadAmbientes"), cantidadAmbientes));
            }

            if (cantidadBanos != null) {
                predicates.add(cb.equal(root.get("cantidadBanos"), cantidadBanos));
            }

            if (publicada != null) {
                predicates.add(cb.equal(root.get("publicada"), publicada));
            }

            if (barrioPriv != null) {
                predicates.add(cb.equal(root.get("barrioPriv"), barrioPriv));
            }

            if (patio != null) {
                predicates.add(cb.equal(root.get("patio"), patio));
            }

            if (cochera != null) {
                predicates.add(cb.equal(root.get("cochera"), cochera));
            }

            if (permuta != null) {
                predicates.add(cb.equal(root.get("permuta"), permuta));
            }

            if (servicios != null) {
                predicates.add(cb.equal(root.get("servicios"), servicios));
            }

            if (amoblado != null) {
                predicates.add(cb.equal(root.get("amoblado"), amoblado));
            }

            if (pileta != null) {
                predicates.add(cb.equal(root.get("pileta"), pileta));
            }

            if (aptProf != null) {
                predicates.add(cb.equal(root.get("aptProf"), aptProf));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
