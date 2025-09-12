package com.example.casagariitaapi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "imagen_propiedad")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenPropiedad extends BaseModel {

    @Column(name = "direccion_url")
    private String url;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propiedad_id")
    @JsonIgnore
    private Propiedad propiedad;
}
