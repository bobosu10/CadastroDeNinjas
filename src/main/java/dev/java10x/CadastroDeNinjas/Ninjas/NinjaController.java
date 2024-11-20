package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa e minha primeira mensagem nessa rota";
    }

    //adicionar ninja(CREATE)
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaDTO){
        return ninjaService.criarNinja(ninjaDTO);
    }

    //Procurar Ninja por ID(CREATE)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostrar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorID(id);
    }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable Long id,@RequestBody NinjaModel ninjatualizado){
        return ninjaService.atualizarNinja(id,ninjatualizado);
    }

    //Deletar Ninjas(DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }


}
