/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import sigee.sigee.model.convocatoria;
import sigee.sigee.repository.Iconvocatoriarepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author KevinHP
 */
@Transactional
@Service
@RequiredArgsConstructor
public class convocatoriaservice implements Iconvocatoriaservice{
    @Autowired
    private final Iconvocatoriarepository _repository;

    @Override
    public List<convocatoria> getAllConvocatoria() {
       return _repository.findAll();
    }

    @Override
    public convocatoria getConvocatoria(Long idconvocatoria) {
        return _repository.findById(idconvocatoria).get();
    }

    @Override
    public convocatoria crearConvocatoria(convocatoria Convocatoria) {
        return _repository.save(Convocatoria);
    }

    @Override
    public convocatoria modificarConvocatoria(convocatoria Convocatoria) {
        return _repository.save(Convocatoria);
    }

    
    @Override
    public void eliminarConvocatoria(Long idconvocatoria) {
        _repository.deleteById(idconvocatoria);
  }
    @Override
    public List<convocatoria> listarConvocatoria(String BuscarConvocatoria) {
      if (BuscarConvocatoria != null) {
        return _repository.findAll(BuscarConvocatoria);
      }
      return _repository.findAll();
    }
     
}


