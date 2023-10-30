package com.gws.minetoursoft.controller;
import com.gws.minetoursoft.dto.ResponseDto;
import com.gws.minetoursoft.modelo.Planes;
import com.gws.minetoursoft.service.PlanesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/planes")
public class PlanesController {
    private PlanesService planesService;

    @Autowired
    private void setPlanesService(PlanesService planesService) {
        this.planesService=planesService;
    }

    @GetMapping
    public ResponseEntity<?> listarPlanes (){
        List<Planes> planes = this.planesService.listarPlanes();
        return new ResponseEntity<>(new ResponseDto(true, "registro exitoso", planes), HttpStatus.OK);
    }
    @PostMapping("/guardarPlan")
    public ResponseEntity<?> guardarPlanes(@RequestBody Planes plan){
        Planes planes = this.planesService.guardarPlanes(plan);
        return new ResponseEntity<>(new ResponseDto(true, "registro exitoso", planes), HttpStatus.OK);
    }
}
