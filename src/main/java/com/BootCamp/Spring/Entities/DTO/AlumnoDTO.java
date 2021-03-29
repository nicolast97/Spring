package com.BootCamp.Spring.Entities.DTO;

import com.BootCamp.Spring.Entities.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AlumnoDTO {
    private String nombre;
    private List<Materia> asignaturas;
}
