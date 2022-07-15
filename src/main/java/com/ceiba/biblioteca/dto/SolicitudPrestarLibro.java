package com.ceiba.biblioteca.dto;

public class SolicitudPrestarLibro {
    
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
 



    public SolicitudPrestarLibro(){}

    public SolicitudPrestarLibro(String isbn, String identificacionUsuario, int tipoUsuario) {
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isValidUser() {
        return (1 <= this.tipoUsuario && this.tipoUsuario<= 3);
    }

  
}
