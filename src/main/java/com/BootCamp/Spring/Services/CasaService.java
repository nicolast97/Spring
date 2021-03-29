package com.BootCamp.Spring.Services;

import com.BootCamp.Spring.Entities.Casa;
import com.BootCamp.Spring.Entities.DTO.CasaDTO;
import com.BootCamp.Spring.Entities.DTO.HabitacionDTO;
import com.BootCamp.Spring.Entities.Habitacion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasaService {

    public Double calcularMtsCuadrados (Casa casa) {

        Double areaTotal = 0.0;
        ArrayList<Habitacion> habitacions = (ArrayList<Habitacion>) casa.getHabitaciones();
        for (Habitacion habitacion : habitacions) {
            Double areaHabitacion = habitacion.getAncho() * habitacion.getLargo();
            areaTotal += areaHabitacion;
        }
        return areaTotal;
    }

    public Double calcularPrecio (Double metrosCuadrados) {
        return metrosCuadrados * 800.00;
    }

    public HabitacionDTO encontrarHabitacionMasGrande (List<Habitacion> habitacions) {
        double mayorsuperficie = 0.0;
        Habitacion habitacionMasGrande = null;
        for (Habitacion habitacion : habitacions) {
            Double superficieHabitacion = habitacion.getAncho() * habitacion.getLargo();
            if (mayorsuperficie < superficieHabitacion) {
                habitacionMasGrande = habitacion;
                mayorsuperficie = superficieHabitacion;
            }
        }
        return mapEntityToDTO(habitacionMasGrande);
    }

    public List<HabitacionDTO> calcularAreaHabitaciones (Casa casa) {
        ArrayList<HabitacionDTO> superficies = new ArrayList<>();
        for (Habitacion habitacion : casa.getHabitaciones()) {
            HabitacionDTO dto = new HabitacionDTO();
            dto.setNombre(habitacion.getNombre());
            dto.setAncho(habitacion.getAncho());
            dto.setLargo(habitacion.getLargo());
            dto.setArea(habitacion.getAncho() * habitacion.getLargo());
            superficies.add(dto);
        }
        return superficies;
    }

    public Casa mapDTOToEntity (CasaDTO dto) {
        ArrayList<Habitacion> habitacions = new ArrayList<>();
        Casa casa = new Casa();
        casa.setNombre(dto.getNombre());
        casa.setDireccion(dto.getNombre());
        for (HabitacionDTO habitacionDTO : dto.getHabitaciones()) {
            Habitacion habitacion = new Habitacion();
            habitacion.setNombre(habitacionDTO.getNombre());
            habitacion.setAncho(habitacionDTO.getAncho());
            habitacion.setLargo(habitacionDTO.getLargo());
            casa.getHabitaciones().add(habitacion);
        }
        return casa;
    }

    public HabitacionDTO mapEntityToDTO (Habitacion habitacion) {
        HabitacionDTO dto = new HabitacionDTO();
        dto.setNombre(habitacion.getNombre());
        dto.setAncho(habitacion.getAncho());
        dto.setLargo(habitacion.getLargo());
        return dto;
    }

    public CasaDTO mapEntityToDTO (Casa casa) {
        CasaDTO casaDTO = new CasaDTO();
        casaDTO.setNombre(casa.getNombre());
        casaDTO.setDireccion(casa.getDireccion());
        ArrayList<HabitacionDTO> habitacionDTOS = new ArrayList<>();
        for (Habitacion habitacion : casa.getHabitaciones()) {
            HabitacionDTO habitacionDTO = new HabitacionDTO();
            habitacionDTO.setNombre(habitacion.getNombre());
            habitacionDTO.setAncho(habitacion.getAncho());
            habitacionDTO.setLargo(habitacion.getLargo());
            habitacionDTOS.add(habitacionDTO);
        }
        casaDTO.setHabitaciones(habitacionDTOS);
        return casaDTO;
    }

}
