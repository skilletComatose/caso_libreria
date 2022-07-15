package com.ceiba.biblioteca.logic.Implement;

import com.ceiba.biblioteca.Utils.GlobalResponse;
import com.ceiba.biblioteca.dto.SolicitudPrestarLibro;
import com.ceiba.biblioteca.logic.Services.IUsuarionValidaciones;

public class UsuarioValidacionesImpl  implements IUsuarionValidaciones {

    @Override
    public boolean validarSiEsUsuarioValido(SolicitudPrestarLibro solicitud) {
        return solicitud.isValidUser();
    }

    @Override
    public GlobalResponse responseParaUsuarioInvalido() {
        GlobalResponse response = new GlobalResponse();
        response.setCode(400);
        response.addValue("mensaje", "Tipo de usuario no permitido en la biblioteca");
        return response;
    }
}
