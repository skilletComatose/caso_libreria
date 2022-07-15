package com.ceiba.biblioteca.logic.Implement;

import com.ceiba.biblioteca.Models.Dao.IPrestamoDao;
import com.ceiba.biblioteca.Models.Entity.Prestamo;
import com.ceiba.biblioteca.Utils.GlobalResponse;
import com.ceiba.biblioteca.dto.SolicitudPrestarLibro;
import com.ceiba.biblioteca.logic.Services.IPrestamoValidaciones;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PrestamoValidaciones implements IPrestamoValidaciones {
    private final int USUARIO_INVITADO = 3;
    @Autowired
    IPrestamoDao prestamoDao;
    @Override
    public boolean noPuedePrestarMasDeUnLibro(SolicitudPrestarLibro solicitud) {
        Optional<Prestamo> haveOne = prestamoDao.findByIdentificacionUsuario(solicitud.getIdentificacionUsuario());
        return haveOne.isPresent() && solicitud.getTipoUsuario() == USUARIO_INVITADO;
    }

    @Override
    public GlobalResponse responseCuandoNoPuedePrestarMasDeUnLibro(String identificacionUsuario) {
        GlobalResponse response = new GlobalResponse();
        response.setCode(400);
        response.addValue("mensaje",
                            "El usuario con identificación " +
                            identificacionUsuario +" ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo");

        return response;
    }

    @Override
    public boolean solicitudEsIncorrecta(SolicitudPrestarLibro solicitud) {
        int tipoUsuarioDigito = String.valueOf(solicitud.getTipoUsuario()).length();
        return (tipoUsuarioDigito > 1) ||  (solicitud.getIdentificacionUsuario().length() >10) ||(solicitud.getIsbn().length() >10);
    }

    @Override
    public GlobalResponse responseParaSolicitudIndorrecta() {
        GlobalResponse r = new GlobalResponse();
        r.setCode(400);
        r.addValue("error","Tamaño de variables incorrecto");
        return r;
    }


}
