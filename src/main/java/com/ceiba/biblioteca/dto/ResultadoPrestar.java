package com.ceiba.biblioteca.dto;

public class ResultadoPrestar {
    private int id;
    private String fechaMaximaDevolucion;
    
    

    public ResultadoPrestar(int id, String fechaMaximaDevolucion) {
        this.id = id;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }
    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }
    
    
}
