package com.gws.minetoursoft.service;

import com.gws.minetoursoft.modelo.Reservas;
import com.gws.minetoursoft.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservaService {
    private ReservaRepository reservaRepository;

    @Autowired
    public void setReservaRepository(ReservaRepository reservaRepository){
        this.reservaRepository=reservaRepository;
    }

    public Reservas save ( Reservas reservas){
        return this.reservaRepository.save(reservas);
    }

    public List<Reservas> listar (){
        return this.reservaRepository.findAll();
    }
}
