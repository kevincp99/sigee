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
        public String verGestionarConvocatoria(
          Model model,
          @Param("BuscarConvocatoria") String BuscarConvocatoria
        ) {
          List<convocatoria> listarConvocatoria = servicio.listarConvocatoria(BuscarConvocatoria);

          model.addAttribute("convocatoria", listarConvocatoria);
          model.addAttribute("BuscarConvocatoria", BuscarConvocatoria);
          return "GestionarConvocatoria";
        }
        
        @GetMapping("/modificarConvocatoria/{idconvocatoria}")
        public ModelAndView modificarConvocatoria(
          @PathVariable(name = "idconvocatoria") Long idconvocatoria,
          ModelAndView view
        ) {
          view.setViewName("Convocatoria");
          view.addObject("crearConvocatoriaForm", servicio.getConvocatoria(idconvocatoria));
          return view;
        }
 
    @RequestMapping("/Convocatoria")
    public String verConvocatoria(Model model) {
        convocatoria Convocatoria = new convocatoria();
        model.addAttribute("crearConvocatoriaForm", Convocatoria);
        return "Convocatoria";
    }

    @PostMapping("/crearConvocatoria")
    public String crearConvocatoria(convocatoria Convocatoria, ModelAndView model) {
        model.setViewName("convocatoria");
        servicio.crearConvocatoria(Convocatoria);
        return "redirect:/GestionarConvocatoria";
    }
    
    @GetMapping("/eliminarConvocatoria/{idconvocatoria}")
    public String eliminarConvocatoria(@PathVariable(name = "idconvocatoria") Long idconvocatoria) {
          servicio.eliminarConvocatoria(idconvocatoria);
          return "redirect:/GestionarConvocatoria";
    }

}

