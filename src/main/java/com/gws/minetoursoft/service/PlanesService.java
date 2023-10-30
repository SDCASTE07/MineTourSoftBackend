package com.gws.minetoursoft.service;

import com.gws.minetoursoft.modelo.Planes;
import com.gws.minetoursoft.repository.PlanesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanesService {
    private PlanesRepository planesRepository;

    @Autowired
    private void setPlanesRepository(PlanesRepository planesRepository){
        this.planesRepository=planesRepository;
    }
    public List<Planes> listarPlanes(){
        return this.planesRepository.findAll();
    }
    public Planes guardarPlanes(Planes planes){
        return this.planesRepository.save(planes);
    }
}
