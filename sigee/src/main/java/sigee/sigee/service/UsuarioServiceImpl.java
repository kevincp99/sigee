/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.service;

import sigee.sigee.model.Usuario;
import sigee.sigee.repository.IUsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author tecnologiaf4
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepo repository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Usuario salvar(Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return repository.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario findByName(String nombre) {
        return repository.findByUserName(nombre).orElse(null);
    }
    
    @Override
    public List<Usuario> listarUsuario(String BuscarUsuario) {
      if (BuscarUsuario != null) {
        return repository.findAll(BuscarUsuario);
      }
      return repository.findAll();
    }
}
