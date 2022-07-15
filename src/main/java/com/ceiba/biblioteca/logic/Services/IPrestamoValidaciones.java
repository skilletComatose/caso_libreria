package com.ceiba.biblioteca.logic.Services;

import com.ceiba.biblioteca.Utils.GlobalResponse;
import com.ceiba.biblioteca.dto.SolicitudPrestarLibro;

public interface IPrestamoValidaciones {
    public boolean noPuedePrestarMasDeUnLibro(SolicitudPrestarLibro solicitud);

    public GlobalResponse responseCuandoNoPuedePrestarMasDeUnLibro(String identificacionUsuario);

    public boolean solicitudEsIncorrecta(SolicitudPrestarLibro solicitud);

    public  GlobalResponse responseParaSolicitudIndorrecta();
}
