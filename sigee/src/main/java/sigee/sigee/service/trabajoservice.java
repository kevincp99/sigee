/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.service;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sigee.sigee.model.trabajo;
import sigee.sigee.repository.Itrabajorepository;

/**
 *
 * @author KevinHP
 */
@Transactional
@Service
@RequiredArgsConstructor
public class trabajoservice implements Itrabajoservice{
    @Autowired
    private final Itrabajorepository repository;
    @Override
    public List<trabajo> getAllTrabajo() {
       return repository.findAll();
    }

    @Override
    public trabajo getTrabajo(Long idtrabajo) {
        return repository.findById(idtrabajo).get();
    }

    @Override
    public trabajo crearTrabajo(trabajo Trabajo) {
        return repository.save(Trabajo);
    }

    @Override
    public trabajo modificarTrabajo(trabajo Trabajo) {
        return repository.save(Trabajo);
    }

    
    @Override
    public void eliminarTrabajo(Long idtrabajo) {
        repository.deleteById(idtrabajo);
  }
    @Override
    public List<trabajo> listarTrabajo(String BuscarTrabajo) {
      if (BuscarTrabajo != null) {
        return repository.findAll(BuscarTrabajo);
      }
      return repository.findAll();
    }

}
