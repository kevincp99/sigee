/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.service;
import sigee.sigee.model.convocatoria;
import java.util.List;
/**
 *
 * @author KevinHP
 */
public interface Iconvocatoriaservice {
    public List<convocatoria> getAllConvocatoria();
    public convocatoria getConvocatoria(Long idconvocatoria);
    public convocatoria crearConvocatoria(convocatoria Convocatoria);
    public convocatoria modificarConvocatoria(convocatoria Convocatoria);
    public void eliminarConvocatoria(Long idconvocatoria);
    public List<convocatoria> listarConvocatoria(String BuscarConvocatoria);

    public Object findAll();
}
