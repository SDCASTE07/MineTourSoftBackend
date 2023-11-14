package com.gws.minetoursoft.service;

import com.google.zxing.WriterException;
import com.gws.minetoursoft.conf.QRCodeGenerator;
import com.gws.minetoursoft.modelo.Reservas;
import com.gws.minetoursoft.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;

@Service
public class ReservaService {

    private JavaMailSender emailSender;

    @Autowired
    public ReservaService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

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

    public Reservas obtenerByid (Long id, Boolean estado) throws MessagingException, IOException, WriterException {
        Reservas reserva = this.reservaRepository.findAllById(id);
            Reservas reservas = Reservas.builder()
                    .id(reserva.getId())
                    .creadoEn(reserva.getCreadoEn())
                    .nombre(reserva.getNombre())
                    .apellido(reserva.getApellido())
                    .cedula(reserva.getCedula())
                    .email(reserva.getEmail())
                    .telefono(reserva.getTelefono())
                    .numeroVisitantes(reserva.getNumeroVisitantes())
                    .fechaReserva(reserva.getFechaReserva())
                    .confirmacion(estado)
                    .build();
            this.reservaRepository.save(reservas);
            String cuerpo =reserva.getNombre().concat(reserva.getApellido()) + " - " + reserva.getCedula()+" - " + reserva.getNumeroVisitantes() +" - " + reserva.getFechaReserva();
            this.enviarCorreo(reserva.getEmail(),"Reserva Confirmada", cuerpo);
            return reservas;
    }

    public void enviarCorreo(String destinatario, String asunto, String cuerpo) throws MessagingException, IOException, WriterException {
        byte[] qrCodeBytes = QRCodeGenerator.generateQRCode(cuerpo, 300, 300);
        String qrCodeBase64 = java.util.Base64.getEncoder().encodeToString(qrCodeBytes);
        String cuerpoConQR = "<html><body><p>" + cuerpo + "</p><img src='data:image/png;base64," + qrCodeBase64 + "'/></body></html>";


        try {
            MimeMessage mensaje = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);

            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(cuerpoConQR, true);

            emailSender.send(mensaje);
        } catch (MessagingException e) {
            throw new MessagingException("Error al enviar el correo: " + e.getMessage());
        }
    }
}
