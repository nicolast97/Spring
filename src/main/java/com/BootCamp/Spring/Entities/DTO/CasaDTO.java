package com.BootCamp.Spring.Entities.DTO;

import com.BootCamp.Spring.Entities.Habitacion;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CasaDTO {
    private String Nombre;
    private String Direccion;
    private List<Habitacion> habitaciones;
}
