/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.repository;

import java.util.List;
import sigee.sigee.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maira
 */
@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {
    @Query(
            "SELECT u FROM Usuario u WHERE u.userName LIKE %?1%"
            )
            public List<Usuario> findAll(String BuscarUsuario);
    public Optional<Usuario> findByUserName(String nombre);
}
