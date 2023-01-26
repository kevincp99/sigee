/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.controller;
import sigee.sigee.model.convocatoria;
import sigee.sigee.service.Iconvocatoriaservice;
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
public class convocatoriaController {

    @Autowired
    private Iconvocatoriaservice servicio;
    
    @RequestMapping("/GestionarConvocatoria")
      public ModelAndView verGestionarConvocatoria(
        @Param("BuscarConvocatoria") String BuscarConvocatoria
      ) {
        ModelAndView model = new ModelAndView("principal");
        model.addObject("view", "GestionarConvocatoria");

        List<convocatoria> listarConvocatoria = servicio.listarConvocatoria(BuscarConvocatoria);

        model.addObject("Convocatoria", listarConvocatoria);
        model.addObject("BuscarConvocatoria", BuscarConvocatoria);
        return model;
    }
     
    
    @RequestMapping("/Convocatoria")
    public ModelAndView verConvocatoria(
      
    ) {
      ModelAndView model = new ModelAndView("principal");
      model.addObject("crearConvocatoriaForm", new convocatoria());
      model.addObject("view", "Convocatoria");
      return model;
  }


        @GetMapping("/modificarConvocatoria/{idconvocatoria}")
        public ModelAndView modificarConvocatoria(
          @PathVariable(name = "idconvocatoria") Long idconvocatoria,
          ModelAndView view
        ) {
          view.setViewName("principal");
          view.addObject("crearConvocatoriaForm", servicio.getConvocatoria(idconvocatoria));
          view.addObject("view", "Convocatoria");
          return view;
        }
 
    
    @PostMapping("/crearConvocatoria")
    public ModelAndView crearConvocatoria(convocatoria Convocatoria, 
        @Param("BuscarConvocatoria") 
        String BuscarConvocatoria
    ) {
        
        try {
            servicio.crearConvocatoria(Convocatoria);
            ModelAndView model = new ModelAndView("principal");

            List<convocatoria> listarConvocatoria = servicio.listarConvocatoria(BuscarConvocatoria);

            model.addObject("Convocatoria", listarConvocatoria);
            model.addObject("BuscarConvocatoria", BuscarConvocatoria);
            model.addObject("view", "GestionarConvocatoria");
            model.addObject("mensaje","Se ha guardado una convocatoria");
            return model;
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("principal");
            model.addObject("crearConvocatoriaForm", new convocatoria());
            model.addObject("view", "Convocatoria");
            model.addObject("mensaje","No se ha guardado la convocatoria");
            return model;
        }
    }
   
    
    @GetMapping("/eliminarConvocatoria/{idconvocatoria}")
    public ModelAndView eliminarConvocatoria(@PathVariable(name = "idconvocatoria") Long idconvocatoria) {
        servicio.eliminarConvocatoria(idconvocatoria);
        ModelAndView model = new ModelAndView("principal");
        List<convocatoria> listarConvocatoria = servicio.getAllConvocatoria();
        model.addObject("Convocatoria", listarConvocatoria);
        model.addObject("view", "GestionarConvocatoria");
        model.addObject("mensaje","Se ha eliminado la convocatoria");
        return model;
    }

}

