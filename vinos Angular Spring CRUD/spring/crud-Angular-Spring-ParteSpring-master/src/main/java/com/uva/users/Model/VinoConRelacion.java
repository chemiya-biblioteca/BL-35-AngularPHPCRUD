package com.uva.users.Model;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "VinoConRelacion")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VinoConRelacion {
    @Id
    @GeneratedValue
    private Integer Id;
    @Size(max = 50)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    private String denominacion;
    private String categoria;
    @Column(nullable = false)
    private Float precio;

    private int bodega_id;

    public int getBodega_id() {
        return this.bodega_id;
    }

    public void setBodega_id(int bodega_id) {
        this.bodega_id = bodega_id;
    }
    

    

    public Float getPrecio() {
        return this.precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getDenominacion() {
        return this.denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre_comercial() {
        return this.nombreComercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombreComercial = nombre_comercial;
    }

   

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public VinoConRelacion() {
    }

VinoConRelacion(String nombre_comercial, String denominacion, String categoria, Float
precio,int bodega_id) {
this.nombreComercial = nombre_comercial;
this.denominacion = denominacion;
this.categoria = categoria;
this.precio = precio;
this.bodega_id=bodega_id;

}

}
