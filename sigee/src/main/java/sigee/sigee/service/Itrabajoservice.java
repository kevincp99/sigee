/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.service;
import java.util.List;
import sigee.sigee.model.trabajo;
/**
 *
 * @author KevinHP
 */
public interface Itrabajoservice {
    public List<trabajo> getAllTrabajo();
    public trabajo getTrabajo(Long idtrabajo);
    public trabajo crearTrabajo(trabajo Trabajo);
    public trabajo modificarTrabajo(trabajo Trabajo);
    public void eliminarTrabajo(Long idtrabajo);
    public List<trabajo> listarTrabajo(String BuscarTrabajo);
}
