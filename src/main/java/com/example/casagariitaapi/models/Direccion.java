package com.example.casagariitaapi.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "direccion")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Direccion extends BaseModel {

    @Column(name = "calle")
    private String calle;
    @Column(name = "numeracion")
    private String numeracion;
    @Column(name = "piso_departamento")
    private String pisoDepartamento;
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "cod_postal")
    private String codPostal;
    @Column(name = "pais")
    private String pais;
    @Column(name = "latitud")
    private Double lat;
    @Column(name = "longitud")
    private Double lon;
    @Column(name = "place_id", length = 100, unique = true)
    private String placeId;
    @Column(name = "formatted_address", length = 500)
    private String formattedAddress;


}
