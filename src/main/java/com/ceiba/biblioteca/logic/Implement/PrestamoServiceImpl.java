package com.ceiba.biblioteca.logic.Implement;
import com.ceiba.biblioteca.logic.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceiba.biblioteca.Utils.GlobalResponse;
import com.ceiba.biblioteca.dto.SolicitudPrestarLibro;

@Service
public class PrestamoServiceImpl implements IPrestamoService  {


    @Autowired
    IUsuarionValidaciones usuarionValidaciones;

    @Autowired
    IPrestamoValidaciones prestamoValidaciones;

    @Autowired
    IAgregarPrestamos agregarPrestamos;

    @Autowired
    IBusquedasEnPrestamos busquedasEnPrestamos;
    @Override
    public GlobalResponse hacerPrestamo(SolicitudPrestarLibro solicitud) {

        if(this.prestamoValidaciones.solicitudEsIncorrecta(solicitud)){
            return this.prestamoValidaciones.responseParaSolicitudIndorrecta();
        }

        if(!this.usuarionValidaciones.validarSiEsUsuarioValido(solicitud)){
            return this.usuarionValidaciones.responseParaUsuarioInvalido();
        }


        if(this.prestamoValidaciones.noPuedePrestarMasDeUnLibro(solicitud)){
            return this.prestamoValidaciones.responseCuandoNoPuedePrestarMasDeUnLibro(solicitud.getIdentificacionUsuario());
        }

        return this.agregarPrestamos.guardarPrestamo(solicitud);
        
        
    }
    @Override
    public GlobalResponse buscarPorId(int id) {
        return this.busquedasEnPrestamos.buscarPorId(id);
    }
    
}
