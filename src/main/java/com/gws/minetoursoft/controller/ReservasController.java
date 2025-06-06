package com.gws.minetoursoft.controller;

import com.gws.minetoursoft.dto.ReservasDto;
import com.gws.minetoursoft.dto.ResponseDto;
import com.gws.minetoursoft.modelo.Reservas;
import com.gws.minetoursoft.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/registro")
public class ReservasController {
    private ReservaService reservaService;

    @Autowired
    public void setReservaService(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<?> guardarReservas(@RequestBody ReservasDto reservasDto) {
        Reservas reservas = Reservas.builder()
                .nombre(reservasDto.getNombre())
                .apellido(reservasDto.getApellido())
                .cedula(reservasDto.getCedula())
                .email(reservasDto.getEmail())
                .telefono(reservasDto.getTelefono())
                .numeroVisitantes(reservasDto.getNumeroVisitantes())
                .fechaReserva(reservasDto.getFechaReserva())
                .build();
        this.reservaService.save(reservas);
        return new ResponseEntity<>(new ResponseDto(true, "registro exitoso", reservas), HttpStatus.OK);
    }

}
