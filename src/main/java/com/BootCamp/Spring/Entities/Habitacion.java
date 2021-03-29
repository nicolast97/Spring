package com.BootCamp.Spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Habitacion {
    private String nombre;
    private Double Ancho;
    private Double Largo;
}
