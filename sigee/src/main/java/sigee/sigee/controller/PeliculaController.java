/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.controller;

import sigee.sigee.model.Pelicula;
import sigee.sigee.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tecnologiaf4
 */
/**
 * La anotación @Controller indica al compilador que la clase es un controlador
 * de Spring
 */
@Controller
public class PeliculaController {

    @Autowired
    private IPeliculaService service;

    @GetMapping("/formulario")
    public ModelAndView formulario() {
        ModelAndView model = new ModelAndView("principal");
        model.addObject("peliculaFormulario", new Pelicula());
        model.addObject("view", "formulario");
        return model;
    }
    @PostMapping("/adicionar")
    public ModelAndView adicionar(Pelicula pelicula) {
        service.salvar(pelicula);
        ModelAndView model = new ModelAndView("principal");
        model.addObject("view", "opciones");
        return model;
    }
    
    @GetMapping("/listar")
    public ModelAndView listar(ModelAndView view) {
        view.addObject("peliculas", service.listar());
        view.setViewName("principal");
        view.addObject("view", "listar");
        return view;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/eliminar/{id}")
    public ModelAndView eliminar(@PathVariable(name = "id") Long id, ModelAndView view) {
        service.eliminarPorId(id);
        view.setViewName("principal");
        view.addObject("peliculas", service.listar());
        view.addObject("view", "listar");
        return view;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable(name = "id") Long id, ModelAndView view) {
        view.setViewName("principal");
        view.addObject("peliculaFormulario", service.buscarPorId(id));
        view.addObject("view", "formulario");
        return view;
    }

    @GetMapping("/menortiempo")
    public ModelAndView showFormDuracion() {
        ModelAndView model = new ModelAndView("principal");
        model.addObject("view", "peliculastiempomenorque");
        return model;
    }

    @PostMapping("/listarpeliculasduracion")
    public ModelAndView peliculasDuracion(int duracion, ModelAndView view) {
        view.setViewName("principal");
        view.addObject("peliculas", service.findByDuracionLessThan(duracion));
        view.addObject("view", "peliculastiempomenorque");
        return view;
    }

}
