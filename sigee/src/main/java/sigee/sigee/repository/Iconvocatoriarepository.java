/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.repository;
import sigee.sigee.model.convocatoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author KevinHP
 */
@Repository
public interface Iconvocatoriarepository extends JpaRepository<convocatoria, Long>{
          @Query(
            "SELECT c FROM convocatoria c WHERE c.fechaInicio LIKE %?1%" +
            "OR c.fechaFin LIKE %?1%"
            )
            public List<convocatoria> findAll(String BuscarConvocatoria);

    
}
