package br.com.isiflix.appmercado.service;

import br.com.isiflix.appmercado.model.ItemLista;

public interface ItemListaService {

    public ItemLista inserirItem(ItemLista novo);
    public ItemLista alterarItem(ItemLista item);
    public void removerItem(Integer numSeq);
}
