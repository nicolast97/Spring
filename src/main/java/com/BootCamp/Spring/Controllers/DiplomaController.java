package com.BootCamp.Spring.Controllers;

import com.BootCamp.Spring.Entities.Alumno;
import com.BootCamp.Spring.Entities.DTO.AlumnoDTO;
import com.BootCamp.Spring.Entities.DTO.DiplomaDTO;
import com.BootCamp.Spring.Services.DiplomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {

    DiplomaService service = new DiplomaService();

    @PostMapping(value = "/promedio")
    public ResponseEntity<DiplomaDTO> calcularPromedio (@RequestBody AlumnoDTO alumnoDTO) {
        Alumno alumno = new Alumno(alumnoDTO.getNombre(),alumnoDTO.getAsignaturas());
        DiplomaDTO diplomaDTO = service.generarDiploma(alumno.getNombre(), service.calcularPromedio(alumno));
        return new ResponseEntity<DiplomaDTO>(diplomaDTO, HttpStatus.ACCEPTED);
    }

}
