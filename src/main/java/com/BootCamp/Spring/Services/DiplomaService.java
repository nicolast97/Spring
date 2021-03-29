package com.BootCamp.Spring.Services;

import com.BootCamp.Spring.Entities.Alumno;
import com.BootCamp.Spring.Entities.DTO.DiplomaDTO;
import com.BootCamp.Spring.Entities.Materia;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {

    public Double calcularPromedio (Alumno alumno) {
        Integer cantMaterias = alumno.getAsignaturas().size();
        Double promedio = 0.0;
        for (Materia materia : alumno.getAsignaturas()) {
            promedio += materia.getNota();
        }
        promedio = promedio / cantMaterias;
        return promedio;
    }

    public DiplomaDTO generarDiploma(String nombreAlumno, Double promedio) {
        String mensaje = "";
        if (promedio >= 9.0) {
            mensaje = "Felicitaciones por completar tu carrera con un promedio excelente!!";
        } else {
            mensaje = "Felicitaciones por completar tu carrera";
        }
        DiplomaDTO diplomaDTO = new DiplomaDTO(mensaje,promedio,nombreAlumno);
        return diplomaDTO;
    }

}
