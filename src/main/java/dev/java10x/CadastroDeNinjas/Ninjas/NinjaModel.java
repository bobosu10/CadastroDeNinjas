package dev.java10x.CadastroDeNinjas.Ninjas;


import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

//ENTITY TRANSFORMA UMA CALSSE EM UMA ENTIDADE DO BANCO DE DADOS
//JPA JAVA PERSISTENCE API
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String email;

    private int idade;


    //@ManyToOne varios ninjas podem ter apenas uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key ou chave estrangeira
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String email, int idade, String nome) {
        this.email = email;
        this.idade = idade;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
