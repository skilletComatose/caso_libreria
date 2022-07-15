package com.ceiba.biblioteca.logic.Services;

import com.ceiba.biblioteca.Utils.GlobalResponse;
import com.ceiba.biblioteca.dto.SolicitudPrestarLibro;

public interface IUsuarionValidaciones {

    public boolean validarSiEsUsuarioValido(SolicitudPrestarLibro solicitud);

    public GlobalResponse responseParaUsuarioInvalido();
}
