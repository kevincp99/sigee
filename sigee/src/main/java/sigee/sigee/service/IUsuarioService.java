/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.service;

import sigee.sigee.model.Usuario;
import java.util.List;

/**
 *
 * @author tecnologiaf4
 */
public interface IUsuarioService {
    
    public Usuario salvar(Usuario usuario);
    public Usuario findById(Long id);
    public Usuario findByName(String nombre);
    public List<Usuario> findAll();
    public void eliminar(Long id);
    public List<Usuario> listarUsuario(String BuscarUsuario);
}
