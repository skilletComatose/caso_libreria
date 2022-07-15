package com.ceiba.biblioteca.logic.Implement;

import com.ceiba.biblioteca.Models.Dao.IPrestamoDao;
import com.ceiba.biblioteca.Models.Entity.Prestamo;
import com.ceiba.biblioteca.Utils.AddDays;
import com.ceiba.biblioteca.Utils.GlobalResponse;
import com.ceiba.biblioteca.dto.SolicitudPrestarLibro;
import com.ceiba.biblioteca.logic.Services.IAgregarPrestamos;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class AgregarPrestamos implements IAgregarPrestamos {

    private final int USUARIO_AFILIADO = 1;
    private final int USUARIO_EMPLEADO = 2;
    private final int USUARIO_INVITADO = 3;

    @Autowired
    IPrestamoDao prestamoDao;
    @Override
    public GlobalResponse guardarPrestamo(SolicitudPrestarLibro solicitud) {

        GlobalResponse response = new GlobalResponse();
        LocalDate fechaPrestamo = LocalDate.now();

        int tipo = solicitud.getTipoUsuario();
        int days = (tipo == USUARIO_AFILIADO) ? 10 :
                   (tipo == USUARIO_EMPLEADO) ? 8  : 7;

        fechaPrestamo = AddDays.addDaysSkippingWeekends(fechaPrestamo, days);

        Prestamo p = new Prestamo(solicitud.getIsbn(),
                solicitud.getIdentificacionUsuario(),
                solicitud.getTipoUsuario(),
                fechaPrestamo);
        Prestamo saved = this.prestamoDao.save(p);
        response.setCode(200);
        response.addValue("id", saved.getId());
        response.addValue("fechaMaximaDevolucion", fechaPrestamo);
        return response;
    }
}
