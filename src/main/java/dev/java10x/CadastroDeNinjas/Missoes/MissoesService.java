package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepossitory missoesRepossitory;

    public MissoesService(MissoesRepossitory missoesRepossitory) {
        this.missoesRepossitory = missoesRepossitory;
    }

    //Listar todas missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepossitory.findAll();
    }

    //Listar todas missoes por ID
    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepossitory.findById(id);
        return missaoPorId.orElse(null);
    }

    //Criar nova missao
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepossitory.save(missao);
    }

    //Deletar missao por ID
    public void deletarMissaoPorId(Long id){
        missoesRepossitory.deleteById(id);
    }

    //atualizar missao
    public MissoesModel atualizarMissao(Long id,MissoesModel missaoAtualizada){
        if(missoesRepossitory.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepossitory.save(missaoAtualizada);
        }
        return null;
    }
}
