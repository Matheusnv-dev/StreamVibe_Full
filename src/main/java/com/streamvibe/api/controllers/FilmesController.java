package com.streamvibe.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.streamvibe.api.models.filme.DadosAtualizacaoFilme;
import com.streamvibe.api.models.filme.DadosCadastroFilme;
import com.streamvibe.api.models.filme.Filme;
import com.streamvibe.api.models.filme.FilmeRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/filme")
public class FilmesController {

    // Injeção de depedência
    @Autowired
    private FilmeRepository repository;

    // Aqui fica o CREATE
    @PostMapping
    @Transactional
    public void cadastrarFilme(@RequestBody DadosCadastroFilme dados) {
        repository.save(new Filme(dados));
    }

    // Aqui fica o READ
    @GetMapping
    public List<Filme> listarFilmes() {
        return repository.findAll();
    }



    // Aqui fica o UPDATE
    // @PutMapping
    // @Transactional
    // public void atualizarFilme(@RequestBody DadosAtualizacaoFilme dados) {
    //     var filme = repository.getReferenceById(dados.id()); }
    //     filme atualizarInformacoes(@RequestBody DadosAtualizacaoFilme dados){
    //    var filme = repository.getReferenceById(dados.id());
    //         filme.atualizarImformacoes(dados);
    // }


     // 1. Tinha uma classe chamada DadosAtualozacaoFilme.java que não tinha nada.
    // 2. Estava chamando o método atualizarImformacoes(dados),com M.
    @PutMapping
    @Transactional
    public void atualizarFilme(@RequestBody DadosAtualizacaoFilme dados) {
        var filme = repository.getReferenceById(dados.id()); 
        filme.atualizarInformacoes(dados);
    }

    // Aqui fica o DELETE REAL
    // @DeleteMapping("/{id}")
    // @Transactional
    // public void excluirFilmeReal(@PathVariable Integer id) {
    // repository.deleteById(id);
    // }

    // Aqui fica a EXCLUSÃO LÓGICA
    @DeleteMapping("/{id}")
    @Transactional
    public void excluirFilmeLogico(@PathVariable Integer id) {
        var filme = repository.getReferenceById(id);
        filme.exclusaoLogica();
    }

}