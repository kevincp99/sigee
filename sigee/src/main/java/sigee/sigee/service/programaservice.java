/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import sigee.sigee.model.programa;
import sigee.sigee.repository.Iprogramarepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author KevinHP
 */
@Transactional
@Service
@RequiredArgsConstructor
public class programaservice implements Iprogramaservice{
    @Autowired
    private final Iprogramarepository repository;

    @Override
    public List<programa> getAllPrograma() {
       return repository.findAll();
    }

    @Override
    public programa getPrograma(Long idprograma) {
        return repository.findById(idprograma).get();
    }

    @Override
    public programa crearPrograma(programa Programa) {
        return repository.save(Programa);
    }

    @Override
    public programa modificarPrograma(programa Programa) {
        return repository.save(Programa);
    }

    
    @Override
    public void eliminarPrograma(Long idprograma) {
        repository.deleteById(idprograma);
  }
//    @Override
//    public List<programa> listarPrograma(String BuscarPrograma) {
//      if (BuscarPrograma != null) {
//        return repository.findAll(BuscarPrograma);
//      }
//      return repository.findAll();
//    }

    @Override
    public List<programa> listarPrograma() {
        return repository.findAll();
    }
     
}


