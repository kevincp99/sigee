/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import sigee.sigee.model.evento;
import sigee.sigee.repository.Ieventorepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author KevinHP
 */


@Transactional
@Service
@RequiredArgsConstructor
public class eventoservice implements Ieventoservice{
@Autowired
    private final Ieventorepository repository;

    @Override
    public List<evento> getAllEvento() {
       return repository.findAll();
    }

    @Override
    public evento getEvento(Long idevento) {
        return repository.findById(idevento).get();
    }

    @Override
    public evento crearEvento(evento Evento) {
        return repository.save(Evento);
    }

    @Override
    public evento modificarEvento(evento Evento) {
        return repository.save(Evento);
    }


    @Override
    public evento cerrarEvento(Long idevento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void eliminarEvento(Long idevento) {
        repository.deleteById(idevento);
  }
    @Override
    public List<evento> listarEventos(String BuscarEvento) {
      if (BuscarEvento != null) {
        return repository.findAll(BuscarEvento);
      }
      return repository.findAll();
    }
     
}
