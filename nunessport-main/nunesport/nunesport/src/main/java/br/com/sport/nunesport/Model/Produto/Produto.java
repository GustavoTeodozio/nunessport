package br.com.sport.nunesport.Model.Produto;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity  //cria tabela jdbc
@Table(name= "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    public Produto(DadosCadastroProdutos dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
    }

    public  Produto(){}

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    public Long getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void atualizaDados(DadosAlteracaoProduto dados) {
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.descricao = dados.descricao();
    }
}
