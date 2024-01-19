package com.diego.sistemaweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class autenticador {

    // Este método manejará las solicitudes GET a la ruta "/login"
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String mostrarFormularioLogin() {
        return "login"; // Este nombre corresponderá a la vista JSP o Thymeleaf
    }

    // Este método manejará las solicitudes POST a la ruta "/login"
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String autenticarUsuario(@RequestParam("usuario") String usuario,
                                    @RequestParam("password") String password,
                                    Model model) {
        autenticador autenticador = new autenticador();

        // Ejemplo de autenticación
        if (autenticador.autenticarUsuario(usuario, password)) {
            model.addAttribute("mensaje", "¡Usuario autenticado!");
            return "bienvenido"; // Este nombre corresponderá a la vista JSP o Thymeleaf de bienvenida
        } else {
            model.addAttribute("mensaje", "Usuario o contraseña incorrectos.");
            return "login"; // Volver al formulario de login
        }
    }

    private boolean autenticarUsuario(String usuario, String password) {
        return false;
    }
}