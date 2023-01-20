/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.repository;

import sigee.sigee.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maira
 */
@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByUserName(String nombre);
}
