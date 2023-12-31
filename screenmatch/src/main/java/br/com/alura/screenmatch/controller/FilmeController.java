package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.filme.DadosAlteracaoFilmes;
import br.com.alura.screenmatch.domain.filme.DadosCadastrosFilmes;
import br.com.alura.screenmatch.domain.filme.Filme;
import br.com.alura.screenmatch.domain.filme.FilmeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

//    private List<Filme> filmes = new ArrayList<>();

    // O Spring instancia o repository
    @Autowired
    private FilmeRepository repository;
    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model){
        if(id != null){
            var filme = repository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }

        return "filmes/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model){
//        model.addAttribute( "lista", filmes);

        model.addAttribute("lista", repository.findAll());
        return "filmes/listagemFilmes";

    }

    @DeleteMapping
    public String removeFilme(Long id) {
        System.out.println(id);
        repository.deleteById(id);
        return "redirect:/filmes";
    }

    @PostMapping
    public String cadastrarFilme(DadosCadastrosFilmes dados) {
        var filme = new Filme(dados);
//        filmes.add(filme);
        repository.save(filme);
        return "redirect:/filmes";

   }

   //@Transactional deixa uma conexão aberta e o Spring verifica se algum dado foi alterado e atualiza no banco
    @PutMapping
    @Transactional
    public String alterarFilme(DadosAlteracaoFilmes dados) {
       var filme = repository.getReferenceById(dados.id());
       filme.atualizaDados(dados);
        return "redirect:/filmes";

    }



}
