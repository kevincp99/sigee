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
    private IUsuarioRepo repo;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Usuario salvar(Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return repo.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Usuario findByName(String nombre) {
        return repo.findByUserName(nombre).orElse(null);
    }

}
