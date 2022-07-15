package com.ceiba.biblioteca.logic.Implement;

import com.ceiba.biblioteca.Models.Dao.IPrestamoDao;
import com.ceiba.biblioteca.Models.Entity.Prestamo;
import com.ceiba.biblioteca.Utils.GlobalResponse;
import com.ceiba.biblioteca.logic.Services.IBusquedasEnPrestamos;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

public class BusquedaEnPrestamos implements IBusquedasEnPrestamos {

    @Autowired
    IPrestamoDao prestamoDao;

    @Override
    public GlobalResponse buscarPorId(long id) {
        GlobalResponse r = new GlobalResponse();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Prestamo p = prestamoDao.findById( (long) id).get();
        r.setCode(200);
        r.addValue("id", p.getId());
        r.addValue("fechaMaximaDevolucion", formato.format(p.getFechaMaximaDevolucion()));
        r.addValue("isbn", p.getIsbn());
        r.addValue("identificacionUsuario", p.getIdentificacionUsuario());
        r.addValue("tipoUsuario", p.getTipoUsuario());
        return  r;
    }
}
