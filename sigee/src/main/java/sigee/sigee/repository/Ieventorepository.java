/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sigee.sigee.model.evento;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author KevinHP
 */
@Repository
public interface Ieventorepository extends JpaRepository<evento, Long>{
          @Query(
            "SELECT e FROM evento e WHERE e.nombreEvento LIKE %?1%" +
            "OR e.tipo LIKE %?1%"
            )
            public List<evento> findAll(String BuscarEvento);
}
