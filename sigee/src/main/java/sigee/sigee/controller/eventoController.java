/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.controller;

import sigee.sigee.model.evento;
import sigee.sigee.service.Ieventoservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author KevinHP
 */
@Controller
public class eventoController {

    @Autowired
    private Ieventoservice servicio;

    @RequestMapping("/GestionarEvento")
    public ModelAndView verGestionarEvento(
      @Param("BuscarEvento") String BuscarEvento
    ) {
      ModelAndView model = new ModelAndView("principal");
      model.addObject("view", "GestionarEvento");

      List<evento> listarEvento = servicio.listarEventos(BuscarEvento);

      model.addObject("Evento", listarEvento);
      model.addObject("BuscarEvento", BuscarEvento);
      return model;
  }

        
        @GetMapping("/modificarEvento/{idevento}")
        public ModelAndView modificarEvento(
          @PathVariable(name = "idevento") Long idevento,
          ModelAndView view
        ) {
          view.setViewName("principal");
          view.addObject("crearEventoForm", servicio.getEvento(idevento));
          view.addObject("view", "Evento");
          return view;
        }
        
    
  
  @RequestMapping("/Evento")
    public ModelAndView verEvento(
      
    ) {
      ModelAndView model = new ModelAndView("principal");
      model.addObject("crearEventoForm", new evento());
      model.addObject("view", "Evento");
      return model;
  }




    @PostMapping("/crearEvento")
    public ModelAndView crearEvento(evento Evento, 
        @Param("BuscarEvento") 
        String BuscarEvento
    ) {
        
        try {
            servicio.crearEvento(Evento);
            ModelAndView model = new ModelAndView("principal");

            List<evento> listarEventos = servicio.listarEventos(BuscarEvento);

            model.addObject("Evento", listarEventos);
            model.addObject("BuscarEvento", BuscarEvento);
            model.addObject("view", "GestionarEvento");
            model.addObject("mensaje","Se ha guardado un evento");
            return model;
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("principal");
            model.addObject("crearEventoForm", new evento());
            model.addObject("view", "Evento");
            model.addObject("mensaje","No se ha guardado el evento");
            return model;
        }
    }
   
    
    @GetMapping("/eliminarEvento/{idevento}")
    public ModelAndView eliminarEvento(@PathVariable(name = "idevento") Long idevento) {
        servicio.eliminarEvento(idevento);
        ModelAndView model = new ModelAndView("principal");
        List<evento> listarEventos = servicio.getAllEvento();
        model.addObject("Evento", listarEventos);
        model.addObject("view", "GestionarEvento");
        model.addObject("mensaje","Se ha eliminado el evento");
        return model;
    }

}
