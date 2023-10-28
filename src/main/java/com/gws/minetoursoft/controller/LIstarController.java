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
@RequestMapping(value = "/api")
public class LIstarController {
    private ReservaService reservaService;

    @Autowired
    public void setReservaService(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar (){
        List<Reservas> reservas= this.reservaService.listar();
        return new ResponseEntity<>(new ResponseDto(true, "exitoso", reservas), HttpStatus.OK);
    }

}
