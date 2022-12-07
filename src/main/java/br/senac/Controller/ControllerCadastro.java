/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.senac.Controller;

import br.senac.Model.Musica;
import br.senac.Repository.RepositorioMusica;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kleber
 */
@Controller
public class ControllerCadastro {

    @Autowired
    private RepositorioMusica RepositorioMusica;

    @GetMapping("/listaMusicas")
    public ModelAndView listaMusica() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("MusicasCadastradas");
        mv.addObject("musicasCad", RepositorioMusica.findAll());
        return mv;
    }

    @GetMapping("/cadastrarMusica")
    public ModelAndView cadastrar(Musica musica) {
        ModelAndView mv = new ModelAndView("CadastroMusicas");
        mv.addObject("musica", musica);

        return mv;
    }

    @PostMapping("/salvarMusica")
    public ModelAndView salvar(@Valid Musica musica, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            mv.setViewName("CadastroMusicas");
            mv.addObject("musica");
        } else {
            mv.setViewName("redirect:/listaMusicas");
            RepositorioMusica.save(musica);
        }
        return mv;
    }

}
