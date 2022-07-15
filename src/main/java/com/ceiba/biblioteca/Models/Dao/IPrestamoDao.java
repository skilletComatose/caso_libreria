package com.ceiba.biblioteca.Models.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.Models.Entity.Prestamo;

@Repository
public interface IPrestamoDao extends CrudRepository<Prestamo,Long> {
    
    public Optional<Prestamo> findById(Long id);

    public Optional<Prestamo> findByIdentificacionUsuario(String identificacion);

    @Override
    public <S extends Prestamo> S save(S prestamo);
}
