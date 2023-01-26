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
    private final Iconvocatoriarepository repository;

    @Override
    public List<convocatoria> getAllConvocatoria() {
       return repository.findAll();
    }

    @Override
    public convocatoria getConvocatoria(Long idconvocatoria) {
        return repository.findById(idconvocatoria).get();
    }

    @Override
    public convocatoria crearConvocatoria(convocatoria Convocatoria) {
        return repository.save(Convocatoria);
    }

    @Override
    public convocatoria modificarConvocatoria(convocatoria Convocatoria) {
        return repository.save(Convocatoria);
    }

    
    @Override
    public void eliminarConvocatoria(Long idconvocatoria) {
        repository.deleteById(idconvocatoria);
  }
    @Override
    public List<convocatoria> listarConvocatoria(String BuscarConvocatoria) {
      if (BuscarConvocatoria != null) {
        return repository.findAll(BuscarConvocatoria);
      }
      return repository.findAll();
    }

    @Override
    public Object findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}


