package com.BootCamp.Spring.Entities.DTO;

import com.BootCamp.Spring.Entities.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiplomaDTO {
    private String mensaje;
    private Double promedio;
    private String nombreAlumno;
}
