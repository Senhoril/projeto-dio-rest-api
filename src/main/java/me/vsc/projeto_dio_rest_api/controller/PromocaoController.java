package me.vsc.projeto_dio_rest_api.controller;

import me.vsc.projeto_dio_rest_api.modelo.Promocao;
import me.vsc.projeto_dio_rest_api.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/promocao")
public class PromocaoController {
    @Autowired
    private PromocaoRepository promocaoRepository;
    @GetMapping
    public List<Promocao> listarPromocoes(){
        return promocaoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Promocao obterPromocao(@PathVariable Long id){
        return promocaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Promoção não encontrada"));
    }
    @PostMapping
    public Promocao criarPromocao(@RequestBody Promocao promocao){
        return promocaoRepository.save(promocao);
    }
    @PutMapping("/{id}")
    public Promocao atualizarPromocao(@PathVariable Long id, @RequestBody Promocao promocaoAtualizada){
        Promocao promocao = promocaoRepository.findById(id).orElse(null);
        if (promocao != null){
            promocaoAtualizada.setId(id);
            return promocaoRepository.save(promocaoAtualizada);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deletarPromocao(@PathVariable Long id){
        promocaoRepository.deleteById(id);
    }
}
