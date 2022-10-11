package br.com.isiflix.appmercado.service;

import br.com.isiflix.appmercado.model.Produto;
import br.com.isiflix.appmercado.repository.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImplemetacao implements IProdutoService {

    @Autowired
    private ProdutoRepo repo;


    @Override
    public Produto criarNovoProduto(Produto prod) {
        if (prod.getNome() == null || prod.getNome().length() == 0)
            return null;
        return repo.save(prod);
    }

    @Override
    public Produto alterarProduto(Produto prod) {
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        return (List<Produto>)repo.findAll();
    }

    @Override
    public List<Produto> buscarPorPalavraChave(String key) {
        return repo.findAllByNomeContaining(key);
    }

    @Override
    public Produto buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
