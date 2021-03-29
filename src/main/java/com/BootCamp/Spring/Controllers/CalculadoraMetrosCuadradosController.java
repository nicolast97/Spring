package com.BootCamp.Spring.Controllers;

import com.BootCamp.Spring.Entities.Casa;
import com.BootCamp.Spring.Entities.DTO.CasaDTO;
import com.BootCamp.Spring.Entities.DTO.TotalMtsCuadradosDTO;
import com.BootCamp.Spring.Services.CalcularMetrosCuadradosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraMetrosCuadradosController {

    CalcularMetrosCuadradosService service = new CalcularMetrosCuadradosService();

    @PostMapping( value = "/totalMtsCuadrados")
    public ResponseEntity<TotalMtsCuadradosDTO> calcularTotalMetrosCuadrados(@RequestBody CasaDTO casaDTO)
    {
        TotalMtsCuadradosDTO totalMtsCuadradosDTO = new TotalMtsCuadradosDTO();
        Casa casa = new Casa(casaDTO.getNombre(),casaDTO.getDireccion(), casaDTO.getHabitaciones());
        totalMtsCuadradosDTO.setTotalmtsCuadrados(service.calcularMtsCuadrados(casa));

        return new ResponseEntity<>(totalMtsCuadradosDTO, HttpStatus.OK);
    }

}
