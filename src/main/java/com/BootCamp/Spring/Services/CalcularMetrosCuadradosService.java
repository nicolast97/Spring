package com.BootCamp.Spring.Services;

import com.BootCamp.Spring.Entities.Casa;
import com.BootCamp.Spring.Entities.DTO.TotalMtsCuadradosDTO;
import com.BootCamp.Spring.Entities.Habitacion;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class CalcularMetrosCuadradosService {

    public Double calcularMtsCuadrados (Casa casa) {

        Double areaTotal = 0.0;
        ArrayList<Habitacion> habitacions = (ArrayList<Habitacion>) casa.getHabitaciones();
        for (Habitacion habitacion : habitacions) {
            Double areaHabitacion = habitacion.getAncho() * habitacion.getLargo();
            areaTotal += areaHabitacion;
        }
        return areaTotal;
    }

}
