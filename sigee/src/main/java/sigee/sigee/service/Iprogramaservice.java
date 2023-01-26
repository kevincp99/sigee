/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.service;
import sigee.sigee.model.programa;
import java.util.List;
/**
 *
 * @author KevinHP
 */
public interface Iprogramaservice {
    public List<programa> getAllPrograma();
    public programa getPrograma(Long idprograma);
    public programa crearPrograma(programa Programa);
    public programa modificarPrograma(programa Programa);
    public void eliminarPrograma(Long idprograma);
//    public List<programa> listarPrograma(String BuscarPrograma);
    public List<programa> listarPrograma() ;
}
