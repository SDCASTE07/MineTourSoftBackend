package com.gws.minetoursoft.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ReservasDto {

    private String nombre;

    private String apellido;

    private  Long cedula;

    private String email;

    private Long telefono;

    private Long numeroVisitantes;

    private Date fechaReserva;
}
