package br.com.uni.springweb.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.uni.springweb.Servico.CookieService;
import br.com.uni.springweb.models.Administrador;
import br.com.uni.springweb.repositorio.AdministradoresRepo;

@Controller
public class LoginController {

  @Autowired
  private AdministradoresRepo repo;

  @GetMapping("/login")
  public String index() {
    // model.addAttribute("nome", "Renê");
    return "login/index";
  }

  @PostMapping("/logar")
  public String logar(Model model, Administrador adminParam, String lembrar, HttpServletResponse response) throws IOException {

    Administrador adm = this.repo.Login(extracted(adminParam), adminParam.getSenha());
    if (adm != null) {
      int tempoLogado = 60*60; //1h de cookie
      if(lembrar != null){
        tempoLogado = 60*60*24*360; //1 ano de cookie
      }
      CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()), tempoLogado);
      CookieService.setCookie(response, "usuarioNome", String.valueOf(adm.getNome()), tempoLogado);
      return "redirect:/";
    }
    model.addAttribute("erro", "Usuário ou senha inválidos");
    return "login/index";
  }

  private String extracted(Administrador adminParam) {
    return adminParam.getEmail();
  } 
  @GetMapping("/sair")
  public String sair( HttpServletResponse response) throws IOException {

      CookieService.setCookie(response, "usuarioId", "", 0);
      return "redirect:/login";     
  }

  
}