package com.gws.minetoursoft.repository;

import com.gws.minetoursoft.modelo.Planes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanesRepository extends JpaRepository<Planes, Long> {
}
