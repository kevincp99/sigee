/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.service;

/**
 *
 * @author KevinHP
 */

import sigee.sigee.model.evento;
import java.util.List;
public interface Ieventoservice{
    public List<evento> getAllEvento();
    public evento getEvento(Long idevento);
    public evento crearEvento(evento Evento);
    public evento modificarEvento(evento Evento);
    public evento cerrarEvento (Long idevento);
    public void eliminarEvento(Long idevento);
    public List<evento> listarEventos(String BuscarEvento);
}
