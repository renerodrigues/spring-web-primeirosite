package br.com.uni.springweb.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.uni.springweb.Servico.CookieService;
import br.com.uni.springweb.models.Administrador;
import br.com.uni.springweb.repositorio.AdministradoresRepo;

@Controller
public class AdministradoresController {
    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/administradores")
    public String index(Model model,  HttpServletRequest request) throws UnsupportedEncodingException {

        List<Administrador> administradores = (List<Administrador>) repo.findAll();
        model.addAttribute("administradores", administradores);
        model.addAttribute("nome", CookieService.getCookie(request, "usuarioNome"));
        
        return "administradores/index";
    }

    @GetMapping("/administradores/novo")
    public String novo() {

        // List<Administrador> administradores = (List<Administrador>) repo.findAll();
        // model.addAttribute("administradores", administradores);
        return "administradores/novo";
    }

    @PostMapping("/administradores/criar")
    public String criar(Administrador administrador) {

        repo.save(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}/excluir")
    public String excluir(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}")
    public String busca(@PathVariable int id, Model model) {
        try {
            // Optional<Administrador> admin = repo.findById(id);
            // model.addAttribute("administrador", admin.get());
            Optional<Administrador> admin = repo.findById(id);
            model.addAttribute("administrador", admin.get());
        } catch (Exception ex) {
            return "redirect:/administradores";
        }
        return "/administradores/editar";
    }

    @PostMapping("/administradores/{id}/atualizar")
    public String atualizar(@PathVariable int id, Administrador admin, HttpServletResponse response) {
        try {
            if (!repo.existsById(id)) {
                //CookieService.setCookie(response, "usuarioNome", admin.getNome(), 0);
                
                return "redirect:/administradores";
            }
          
            repo.save(admin);
        } catch (Exception ex) {
            return "redirect:/administradores";
        }
        return "redirect:/administradores";
    }
}
