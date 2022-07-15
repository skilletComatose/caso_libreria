package com.ceiba.biblioteca.logic.Configuration;
import com.ceiba.biblioteca.logic.Implement.AgregarPrestamos;
import com.ceiba.biblioteca.logic.Implement.BusquedaEnPrestamos;
import com.ceiba.biblioteca.logic.Implement.PrestamoValidaciones;
import com.ceiba.biblioteca.logic.Implement.UsuarioValidacionesImpl;
import com.ceiba.biblioteca.logic.Services.IAgregarPrestamos;
import com.ceiba.biblioteca.logic.Services.IBusquedasEnPrestamos;
import com.ceiba.biblioteca.logic.Services.IPrestamoValidaciones;
import com.ceiba.biblioteca.logic.Services.IUsuarionValidaciones;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrestamoServiceConfiguration {

    @Bean
    public IAgregarPrestamos agregarPrestamos(){
        return  new AgregarPrestamos();
    }

    @Bean
    public IPrestamoValidaciones validarprestamo(){
        return  new PrestamoValidaciones();
    }

    @Bean
    public IUsuarionValidaciones validacionesDeUsuario(){
        return  new UsuarioValidacionesImpl();
    }

    @Bean
    public  IBusquedasEnPrestamos buscarPrestamos(){
        return  new BusquedaEnPrestamos();
    }
}
