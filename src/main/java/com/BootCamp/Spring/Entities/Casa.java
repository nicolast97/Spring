package com.BootCamp.Spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Casa {
    private String direccion;
    private String nombre;
    private List<Habitacion> habitaciones;

    public Casa () {
        this.direccion = "";
        this.nombre = "";
        this.habitaciones = new ArrayList<>();
    }

}
