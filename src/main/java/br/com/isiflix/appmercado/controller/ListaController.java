package br.com.isiflix.appmercado.controller;

import br.com.isiflix.appmercado.model.Lista;
import br.com.isiflix.appmercado.service.IListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ListaController {

    @Autowired
    private IListaService service;

    @GetMapping("/listas")
    public ResponseEntity<List<Lista>> recuperarTodas() {
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/listas/{id}")
    public ResponseEntity<Lista> buscarPeloId(@PathVariable Integer id) {
        Lista res = service.buscarPeloId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping("/listas")public ResponseEntity<Lista> adicionarNova(@RequestBody Lista nova) {
        Lista res = service.criarNovaLista(nova);
        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/lista/{id}")
    public ResponseEntity<Lista> alterarLista(@PathVariable Integer id) {
        Lista res = service.fecharLista(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/lista/{id}")
    public ResponseEntity<?> removerLista(@PathVariable Integer id) {
        service.removerLista(id);
        return ResponseEntity.ok("Ok");
    }
}
