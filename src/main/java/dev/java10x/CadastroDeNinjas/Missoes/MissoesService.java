package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepossitory missoesRepossitory;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesMapper missoesMapper, MissoesRepossitory missoesRepossitory) {
        this.missoesMapper = missoesMapper;
        this.missoesRepossitory = missoesRepossitory;
    }

    //Listar todas missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepossitory.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Listar todas missoes por ID
    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepossitory.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    //Criar nova missao
    public MissoesDTO criarMissao(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missao = missoesRepossitory.save(missao);
        return missoesMapper.map(missao);
    }

    //Deletar missao por ID
    public void deletarMissaoPorId(Long id){
        missoesRepossitory.deleteById(id);
    }

    //atualizar missao
    public MissoesDTO atualizarMissao(Long id,MissoesDTO missaoDTO){
        Optional<MissoesModel> missaoExistente = missoesRepossitory.findById(id);
        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepossitory.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
