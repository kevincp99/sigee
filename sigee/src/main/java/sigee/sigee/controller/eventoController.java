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
        public String verGestionarEvento(
          Model model,
          @Param("BuscarEvento") String BuscarEvento
        ) {
          List<evento> listarEventos = servicio.listarEventos(BuscarEvento);

          model.addAttribute("evento", listarEventos);
          model.addAttribute("BuscarEvento", BuscarEvento);
          return "GestionarEvento";
        }
        
        @GetMapping("/modificarEvento/{idevento}")
        public ModelAndView modificarEvento(
          @PathVariable(name = "idevento") Long idevento,
          ModelAndView view
        ) {
          view.setViewName("Evento");
          view.addObject("crearEventoForm", servicio.getEvento(idevento));
          return view;
        }
    
    /*@GetMapping(path = {"", "/GestionarEvento"})
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("GestionarEvento");
        //view.addObject("crearEventoForm", new evento());
        return view;
    }*/

    /*@GetMapping("/GestionarEvento")
  public ModelAndView GestionarEvento() {
    ModelAndView mav=new ModelAndView();
    mav.addObject("view", "GestionarEvento");
    return mav;
    evento Evento = new evento();
    model.addAttribute("crearEventoForm", Evento);
    return "GestionarEvento";
  }*/
    
    
    @RequestMapping("/Evento")
    public String verEvento(Model model) {
        evento Evento = new evento();
        model.addAttribute("crearEventoForm", Evento);
        return "Evento";
    }
    
    /*@PostMapping("/crearEvento")
    public String crearEvento(
        @ModelAttribute("crearEventoForm") evento Evento
        ) {
        servicio.crearEvento(Evento);
        return "redirect:/GestionarEvento";
    }*/

    @PostMapping("/crearEvento")
    public String crearEvento(evento Evento, ModelAndView model) {
        model.setViewName("evento");
        servicio.crearEvento(Evento);
        //model.addObject("evento", servicio.getAllEvento());
        return "redirect:/GestionarEvento";
    }
   
    
    @GetMapping("/eliminarEvento/{idevento}")
    public String eliminarEvento(@PathVariable(name = "idevento") Long idevento) {
          servicio.eliminarEvento(idevento);
          return "redirect:/GestionarEvento";
    }

}
