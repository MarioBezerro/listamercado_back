package br.com.isiflix.appmercado.repository;

import br.com.isiflix.appmercado.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepo extends CrudRepository<Produto, Integer> {
    public List<Produto> findAllByNomeContaining(String palavrachave);
}
