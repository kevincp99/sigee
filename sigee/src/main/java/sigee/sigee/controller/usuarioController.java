package sigee.sigee.controller;

import java.util.List;
import sigee.sigee.model.Usuario;
import sigee.sigee.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sigee.sigee.service.IUsuarioService;

@Controller
public class usuarioController {

    @Autowired
    private IUsuarioService servicio;

    @RequestMapping("/GestionarUsuario")
    public ModelAndView verGestionarUsuario(
      @Param("BuscarUsuario") String BuscarUsuario
    ) {
      ModelAndView model = new ModelAndView("principal");
      model.addObject("view", "GestionarUsuario");

      List<Usuario> listarUsuario = servicio.listarUsuario(BuscarUsuario);

      model.addObject("Usuario", listarUsuario);
      model.addObject("BuscarUsuario", BuscarUsuario);
      return model;
  }
    
      @RequestMapping("/Usuario")
    public ModelAndView verUsuario(
      
    ) {
      ModelAndView model = new ModelAndView("principal");
      model.addObject("InfoUsuarioForm", new Usuario());
      model.addObject("view", "Usuario");
      return model;
  }




    @PostMapping("/crearUsuario")
    public ModelAndView crearUsuario(Usuario userName, 
        @Param("BuscarUsuario") 
        String BuscarUsuario
    ) {
        
        try {
            servicio.salvar(userName);
            ModelAndView model = new ModelAndView("principal");

            List<Usuario> listarUsuario = servicio.listarUsuario(BuscarUsuario);

            model.addObject("Usuario", listarUsuario);
            model.addObject("BuscarUsuario", BuscarUsuario);
            model.addObject("view", "GestionarUsuario");
            model.addObject("mensaje","Se ha guardado un usuario");
            return model;
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("principal");
            model.addObject("InfoUsuarioForm", new Usuario());
            model.addObject("view", "Usuario");
            model.addObject("mensaje","No se ha guardado el usuario");
            return model;
        }
    }
    
//        @GetMapping("/asignarRol/{id}")
//        public ModelAndView modificarUsuario(
//          @PathVariable(name = "id") Long id,
//          ModelAndView view
//        ) {
//          view.setViewName("principal");
//          view.addObject("InfoUsuarioForm", servicio.findById(id));
//          view.addObject("view", "Usuario");
//          return view;
//        }
    
//    @GetMapping("/Usuario")
//    public ModelAndView listar(ModelAndView view) {
//        view.addObject("usuario", servicio.findAll());
//        view.setViewName("principal");
//        view.addObject("view", "GestionarUsuario");
//        return view;
//    }

//    @RequestMapping("/paginaUsuario_Registrar")
//    public String verUsuario(Model model) {
//      usuario usuario = new usuario();
//      model.addAttribute("registrarUsuarioForm", usuario);
//      return "Usuario_Registrar";
//    }

//    @PostMapping("/registrarUsuario")
//    public ModelAndView registrarUsuario(usuario usuario, ModelAndView view) {
//        servicio.salvar(usuario);
//        view.addObject("usuarios", servicio.findAll());
//        view.setViewName("principal");
//        view.addObject("view", "Usuario_Gestionar");
//        return view;
//    }
        
    @GetMapping("/modificarUsuario/{id}")
        public ModelAndView modificarUsuario(
          @PathVariable(name = "id") Long id,
          ModelAndView view
        ) {
          view.setViewName("principal");
          view.addObject("InfoUsuarioForm", servicio.findById(id));
          view.addObject("view", "Usuario");
          return view;
        }
    
    @GetMapping("/eliminarUsuario/{id}")
    public ModelAndView eliminarUsuario(@PathVariable(name = "id") Long id) {
        servicio.eliminar(id);
        ModelAndView model = new ModelAndView("principal");
        List<Usuario> listarUsuario = servicio.findAll();
        model.addObject("Usuario", listarUsuario);
        model.addObject("view", "GestionarUsuario");
        model.addObject("mensaje","Se ha eliminado el usuario");
        return model;
    }

//    @GetMapping("/editarUsuario/{id}")
//    public ModelAndView editarUsuario(@PathVariable(name = "id") Long id, ModelAndView view) {
//        view.setViewName("principal");
//        view.addObject("registrarUsuarioForm", servicio.findById(id));
//        view.addObject("view", "Usuario_Registrar");
//        return view;
//    }

}
