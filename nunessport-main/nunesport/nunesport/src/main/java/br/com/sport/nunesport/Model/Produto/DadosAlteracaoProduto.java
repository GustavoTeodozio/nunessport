package br.com.sport.nunesport.Model.Produto;

import java.math.BigDecimal;

public record DadosAlteracaoProduto(Long id, String nome, String descricao, BigDecimal preco) {
}
