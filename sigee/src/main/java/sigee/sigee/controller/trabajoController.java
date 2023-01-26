/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.controller;

import sigee.sigee.model.trabajo;
import sigee.sigee.service.Itrabajoservice;
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
public class trabajoController {

    @Autowired
    private Itrabajoservice servicio;

    @RequestMapping("/GestionarTrabajo")
    public ModelAndView verGestionarTrabajo(
      @Param("BuscarTrabajo") String BuscarTrabajo
    ) {
      ModelAndView model = new ModelAndView("principal");
      model.addObject("view", "GestionarTrabajo");

      List<trabajo> listarTrabajo = servicio.listarTrabajo(BuscarTrabajo);

      model.addObject("Trabajo", listarTrabajo);
      model.addObject("BuscarTrabajo", BuscarTrabajo);
      return model;
  }

        
        @GetMapping("/modificarTrabajo/{idtrabajo}")
        public ModelAndView modificarTrabajo(
          @PathVariable(name = "idtrabajo") Long idtrabajo,
          ModelAndView view
        ) {
          view.setViewName("principal");
          view.addObject("crearTrabajoForm", servicio.getTrabajo(idtrabajo));
          view.addObject("view", "Trabajo");
          return view;
        }
        
    
  
  @RequestMapping("/Trabajo")
    public ModelAndView verTrabajo(
      
    ) {
      ModelAndView model = new ModelAndView("principal");
      model.addObject("crearTrabajoForm", new trabajo());
      model.addObject("view", "Trabajo");
      return model;
  }




    @PostMapping("/crearTrabajo")
    public ModelAndView crearTrabajo(trabajo Trabajo, 
        @Param("BuscarTrabajo") 
        String BuscarTrabajo
    ) {
        
        try {
            servicio.crearTrabajo(Trabajo);
            ModelAndView model = new ModelAndView("principal");

            List<trabajo> listarTrabajos = servicio.listarTrabajo(BuscarTrabajo);

            model.addObject("Trabajo", listarTrabajos);
            model.addObject("BuscarTrabajo", BuscarTrabajo);
            model.addObject("view", "GestionarTrabajo");
            model.addObject("mensaje","Se ha guardado un trabajo");
            return model;
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("principal");
            model.addObject("crearTrabajoForm", new trabajo());
            model.addObject("view", "Trabajo");
            model.addObject("mensaje","No se ha guardado el trabajo");
            return model;
        }
    }
   
    
    @GetMapping("/eliminarTrabajo/{idtrabajo}")
    public ModelAndView eliminarTrabajo(@PathVariable(name = "idtrabajo") Long idtrabajo) {
        servicio.eliminarTrabajo(idtrabajo);
        ModelAndView model = new ModelAndView("principal");
        List<trabajo> listarTrabajos = servicio.getAllTrabajo();
        model.addObject("Trabajo", listarTrabajos);
        model.addObject("view", "GestionarTrabajo");
        model.addObject("mensaje","Se ha eliminado el trabajo");
        return model;
    }

}
