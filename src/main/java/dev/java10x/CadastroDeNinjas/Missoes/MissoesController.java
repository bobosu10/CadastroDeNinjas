package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController //tudo abaixo e um controller
@RequestMapping("/missoes") //vou comecar a mapear a api
public class MissoesController  {

    //GET - MANDAR UMA REQUISISAO PARA MOSTAR AS MISSSOES

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listadas com sucesso";
    }

    //LOCASHOST:8080/MISSOES/CRIAR
    //POST - MANDAR UMA REQUISISAO PARA CRIAR AS MISSOES
    @PostMapping("/criar")
    public String  criarMissao(){
        return "Missao criada com sucesso";
    }

    //PUT - MANDAR UMA REQUISISAO PARA ALTERAR AS MISSOES
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }

    //DELETE - MANDAR UMA REQUISISAO PARA DELETAR AS MISSOES
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }



}
