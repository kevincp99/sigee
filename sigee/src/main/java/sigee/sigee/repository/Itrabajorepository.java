/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sigee.sigee.model.trabajo;

/**
 *
 * @author KevinHP
 */
@Repository
public interface Itrabajorepository extends JpaRepository<trabajo, Long>{
    @Query(
            "SELECT t FROM trabajo t WHERE t.titulo LIKE %?1%" +
            "OR t.autor LIKE %?1%" +
            "OR t.correo LIKE %?1%"
            )
    public List<trabajo> findAll(String BuscarTrabajo);
}
