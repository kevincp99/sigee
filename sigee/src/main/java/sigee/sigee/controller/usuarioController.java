package sigee.sigee.controller;

import sigee.sigee.model.Usuario;
import sigee.sigee.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class usuarioController {

    @Autowired
    private IUsuarioService servicio;

    @GetMapping("/Usuario")
    public ModelAndView listar(ModelAndView view) {
        view.addObject("usuario", servicio.findAll());
        view.setViewName("principal");
        view.addObject("view", "GestionarUsuario");
        return view;
    }

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

    @GetMapping("/eliminarUsuario/{id}")
    public ModelAndView eliminar(@PathVariable(name = "id") Long id, ModelAndView view) {
        servicio.eliminar(id);
        view.addObject("usuario", servicio.findAll());
        view.setViewName("inicio");
        view.addObject("view", "GestionarUsuario");
        return view;
    }

//    @GetMapping("/editarUsuario/{id}")
//    public ModelAndView editarUsuario(@PathVariable(name = "id") Long id, ModelAndView view) {
//        view.setViewName("principal");
//        view.addObject("registrarUsuarioForm", servicio.findById(id));
//        view.addObject("view", "Usuario_Registrar");
//        return view;
//    }

}
