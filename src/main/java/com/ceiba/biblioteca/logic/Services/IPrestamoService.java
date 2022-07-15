package com.ceiba.biblioteca.logic.Services;

import com.ceiba.biblioteca.Utils.GlobalResponse;
import com.ceiba.biblioteca.dto.SolicitudPrestarLibro;

public interface IPrestamoService {
    public GlobalResponse hacerPrestamo(SolicitudPrestarLibro solicitud);

    public GlobalResponse buscarPorId(int id);
}
