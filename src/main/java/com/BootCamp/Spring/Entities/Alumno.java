package com.BootCamp.Spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Alumno {

    private String nombre;
    private List<Materia> asignaturas;

}
