/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.controller;
import sigee.sigee.model.programa;
import sigee.sigee.service.Iprogramaservice;
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
public class programaController {

    @Autowired
    private Iprogramaservice servicio;
    
    @RequestMapping("/GestionarPrograma")
      public ModelAndView verGestionarPrograma() {
        ModelAndView model = new ModelAndView("principal");
        model.addObject("view", "GestionarPrograma");

        List<programa> listarPrograma = servicio.listarPrograma();

        model.addObject("Programa", listarPrograma);
        return model;
    }
     
    
    @RequestMapping("/Programa")
    public ModelAndView verPrograma(
      
    ) {
      ModelAndView model = new ModelAndView("principal");
      model.addObject("crearProgramaForm", new programa());
      model.addObject("view", "Programa");
      return model;
  }


        @GetMapping("/modificarPrograma/{idprograma}")
        public ModelAndView modificarPrograma(
          @PathVariable(name = "idprograma") Long idprograma,
          ModelAndView view
        ) {
          view.setViewName("principal");
          view.addObject("crearProgramaForm", servicio.getPrograma(idprograma));
          view.addObject("view", "Programa");
          return view;
        }
 
    
    @PostMapping("/crearPrograma")
    public ModelAndView crearPrograma(programa Programa ) {
        
        try {
            servicio.crearPrograma(Programa);
            ModelAndView model = new ModelAndView("principal");

            List<programa> listarPrograma = servicio.listarPrograma();

            model.addObject("Programa", listarPrograma);
            model.addObject("view", "GestionarPrograma");
            model.addObject("mensaje","Se ha guardado un programa");
            return model;
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("principal");
            model.addObject("crearProgramaForm", new programa());
            model.addObject("view", "Programa");
            model.addObject("mensaje","No se ha guardado el programa");
            return model;
        }
    }
   
    
    @GetMapping("/eliminarPrograma/{idprograma}")
    public ModelAndView eliminarPrograma(@PathVariable(name = "idprograma") Long idprograma) {
        servicio.eliminarPrograma(idprograma);
        ModelAndView model = new ModelAndView("principal");
        List<programa> listarPrograma = servicio.getAllPrograma();
        model.addObject("Programa", listarPrograma);
        model.addObject("view", "GestionarPrograma");
        model.addObject("mensaje","Se ha eliminado el programa");
        return model;
    }

}

