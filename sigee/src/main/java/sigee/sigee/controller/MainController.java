/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigee.sigee.controller;

import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author maira
 */
@Controller
public class MainController {

    @GetMapping(path = {"/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/principal")
    public String success(HttpSession session, Model model) {
        SecurityContext ctx = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        Authentication auth = ctx.getAuthentication();//aqui está toda la informacion del user 
        model.addAttribute("view", "opciones");
        return "principal";
    }
}
