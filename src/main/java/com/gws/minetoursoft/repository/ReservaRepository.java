package com.gws.minetoursoft.repository;

import com.gws.minetoursoft.modelo.Reservas;
import com.gws.minetoursoft.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reservas, Long> {
    Reservas findAllById (Long id);

}
