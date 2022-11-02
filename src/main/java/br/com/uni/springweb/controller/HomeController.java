package br.com.uni.springweb.controller;


import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.uni.springweb.Servico.CookieService;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
       model.addAttribute("nome", CookieService.getCookie(request, "usuarioNome"));
        return "home/index";
    }
    
}