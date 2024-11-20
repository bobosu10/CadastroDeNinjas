package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //tudo abaixo e um controller
@RequestMapping("/missoes") //vou comecar a mapear a api
public class MissoesController  {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET - MANDAR UMA REQUISISAO PARA MOSTAR AS MISSSOES

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("listar/{id}")
    public MissoesModel listarPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    //LOCASHOST:8080/MISSOES/CRIAR
    //POST - MANDAR UMA REQUISISAO PARA CRIAR AS MISSOES
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    //PUT - MANDAR UMA REQUISISAO PARA ALTERAR AS MISSOES
    @PutMapping("/alterar")
    public MissoesModel alterarMissao(@PathVariable Long id,@RequestBody MissoesModel missaoAtualizada){
        return missoesService.atualizarMissao(id,missaoAtualizada);
    }

    //DELETE - MANDAR UMA REQUISISAO PARA DELETAR AS MISSOES
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }
}
