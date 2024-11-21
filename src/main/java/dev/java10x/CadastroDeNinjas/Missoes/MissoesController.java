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
    public List<MissoesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("listar/{id}")
    public MissoesDTO listarPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    //LOCASHOST:8080/MISSOES/CRIAR
    //POST - MANDAR UMA REQUISISAO PARA CRIAR AS MISSOES
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missaoDTO){
        return missoesService.criarMissao(missaoDTO);
    }

    //PUT - MANDAR UMA REQUISISAO PARA ALTERAR AS MISSOES
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id,@RequestBody MissoesDTO missaoAtualizada){
        return missoesService.atualizarMissao(id,missaoAtualizada);
    }

    //DELETE - MANDAR UMA REQUISISAO PARA DELETAR AS MISSOES
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }
}
