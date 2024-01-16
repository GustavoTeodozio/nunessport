package br.com.sport.nunesport.Controller;


import br.com.sport.nunesport.Model.Produto.DadosAlteracaoProduto;
import br.com.sport.nunesport.Model.Produto.DadosCadastroProdutos;
import br.com.sport.nunesport.Model.Produto.Produto;
import br.com.sport.nunesport.Model.Produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario (Long id, Model model){
        if (id != null){
            var produto = repository.getReferenceById(id);
            model.addAttribute("produto", produto);
        }
        return "produtos/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll());
        return "produtos/listagem";
    }


    @PostMapping
    public String cadastraProduto(DadosCadastroProdutos dados){
        var produto = new Produto(dados);
        repository.save(produto);
        return "redirect:/produtos";
    }

    @PutMapping
    @Transactional
    public String alteraProduto(DadosAlteracaoProduto dados){
        var produto = repository.getReferenceById(dados.id());
        produto.atualizaDados(dados);
        return "redirect:/produtos";
    }



    @DeleteMapping
    public  String removeProduto (Long id) {
        repository.deleteById(id);
        return "redirect:/produtos";
    }
}
