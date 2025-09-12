package com.example.casagariitaapi.models;

import com.example.casagariitaapi.models.Enums.Estado;
import com.example.casagariitaapi.models.Enums.TipoOperacion;
import com.example.casagariitaapi.models.Enums.TipoPropiedad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "propiedades")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Propiedad extends BaseModel {

    @Column(name = "titulo")
    private String titulo;

    @Lob
    @Column(name = "descripcion", columnDefinition = "MEDIUMTEXT")
    private String descripcion;


    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "sup_cubierta")
    private float supCubierta;

    @Column(name = "sup_total")
    private float supTotal;

    @Column(name = "cantidad_habitaciones")
    private int cantidadHabitaciones;

    @Column(name = "cantidad_ambientes")
    private int cantidadAmbientes;

    @Column(name = "cantidad_baños")
    private int cantidadBanos;


    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion;

    @Column(name = "tipo_operacion")
    private TipoOperacion tipoOperacion;

    @ManyToOne
    @JoinColumn(name = "agente_asignado_id")
    private Usuario agenteAsignado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_propiedad")
    private TipoPropiedad tipoPropiedad;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    @OneToMany(mappedBy = "propiedad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenPropiedad> imagenes = new ArrayList<>();



    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }
}
