package com.BootCamp.Spring.Controllers;

import com.BootCamp.Spring.Entities.Casa;
import com.BootCamp.Spring.Entities.DTO.CasaDTO;
import com.BootCamp.Spring.Entities.DTO.HabitacionDTO;
import com.BootCamp.Spring.Entities.DTO.TotalMtsCuadradosDTO;
import com.BootCamp.Spring.Services.CasaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/casa")
public class CasaController {

    CasaService service = new CasaService();

    @PostMapping( value = "/totalMtsCuadrados")
    public ResponseEntity<TotalMtsCuadradosDTO> calcularTotalMetrosCuadrados(@RequestBody CasaDTO casaDTO)
    {
        TotalMtsCuadradosDTO totalMtsCuadradosDTO = new TotalMtsCuadradosDTO();
        Casa casa = service.mapDTOToEntity(casaDTO);
        totalMtsCuadradosDTO.setTotalmtsCuadrados(service.calcularMtsCuadrados(casa));

        return new ResponseEntity<>(totalMtsCuadradosDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/precio")
    public ResponseEntity<Double> calcularPrecio(@RequestBody CasaDTO casaDTO) {
        Casa casa = service.mapDTOToEntity(casaDTO);
        TotalMtsCuadradosDTO totalMtsCuadradosDTO = new TotalMtsCuadradosDTO();
        totalMtsCuadradosDTO.setTotalmtsCuadrados(service.calcularMtsCuadrados(casa));
        totalMtsCuadradosDTO.setPrecioUSD(service.calcularPrecio(totalMtsCuadradosDTO.getTotalmtsCuadrados()));
        return new ResponseEntity<>(totalMtsCuadradosDTO.getPrecioUSD(),HttpStatus.OK);
    }

    @PostMapping(value = "/habitacionMasGrande")
    public ResponseEntity<HabitacionDTO> encontrarHabitacionMasGrande (@RequestBody CasaDTO casaDTO) {
        Casa casa = service.mapDTOToEntity(casaDTO);
        HabitacionDTO habitacionMasGrande = service.encontrarHabitacionMasGrande(casa.getHabitaciones());
        return new ResponseEntity<>(habitacionMasGrande, HttpStatus.OK);
    }

    @PostMapping(value = "/areaHabitaciones")
    public ResponseEntity<List<HabitacionDTO>> encontrarAreaHabotaciones (@RequestBody CasaDTO casaDTO){
        Casa casa = service.mapDTOToEntity(casaDTO);
        ArrayList<HabitacionDTO> habitacionDTOS = (ArrayList<HabitacionDTO>) service.calcularAreaHabitaciones(casa);
        return new ResponseEntity<List<HabitacionDTO>>(habitacionDTOS, HttpStatus.OK);
    }

 }
