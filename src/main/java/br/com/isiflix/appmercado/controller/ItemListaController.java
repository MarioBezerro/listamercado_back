package br.com.isiflix.appmercado.controller;

import br.com.isiflix.appmercado.model.ItemLista;
import br.com.isiflix.appmercado.service.ItemListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemListaController {

    @Autowired
    private ItemListaService service;

    @PostMapping("/itemlista")
    public ResponseEntity<ItemLista> inserir(@RequestBody ItemLista novo) {
        ItemLista res = service.inserirItem(novo);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/itemlista/{numSeq}")
    public ResponseEntity<ItemLista> alterar(@RequestBody ItemLista item, @PathVariable Integer numSeq) {
        item.setNumSeq(numSeq);
        ItemLista res = service.alterarItem(item);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/itemlista/{id}")
    public ResponseEntity<?> apagar(@PathVariable Integer numSeq) {
        service.removerItem(numSeq);
        return ResponseEntity.ok("Ok");
    }
}