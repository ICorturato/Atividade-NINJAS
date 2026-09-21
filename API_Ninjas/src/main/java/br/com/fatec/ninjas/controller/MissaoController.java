package br.com.fatec.ninjas.controller;


import br.com.fatec.ninjas.model.Missao;
import br.com.fatec.ninjas.service.MissaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;

    @PostMapping
    public Missao cadastrarMissao(@Valid @RequestBody Missao missao){
        return missaoService.cadastrarMissao(missao);
    }

    @GetMapping
        public List<Missao> listarMissao(){
            return missaoService.listarMissao();
        }

    @GetMapping("/id/{id}")
    public Optional<Missao> buscarPorId(@PathVariable Long id){
        return missaoService.buscarPorId(id);
    }

    @GetMapping("/titulo/{titulo}")
    public Missao buscarPorTitulo(@PathVariable String titulo){
        return missaoService.buscarPorTitulo(titulo);
    }

    @GetMapping("/descricao/{descricao}")
    public List<Missao> buscarPorDescricao(@PathVariable String descricao){
        return missaoService.buscarPorDescricao(descricao);
    }

    @PutMapping("/{id}")
    public Missao atualizarMissao(@PathVariable Long id, @Valid @RequestBody Missao missao){
        return missaoService.atualizarMissao(id, missao);
    }

    @DeleteMapping("/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deletarMissao(id);
    }

}
