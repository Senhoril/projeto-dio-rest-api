package me.vsc.projeto_dio_rest_api.controller;

import me.vsc.projeto_dio_rest_api.modelo.PromocaoItemCardapio;
import me.vsc.projeto_dio_rest_api.repository.PromocaoItemCardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/promocoes-item-cardapio")
public class PromocaoItemCardapioController {
    @Autowired
    private PromocaoItemCardapioRepository promocaoItemCardapioRepository;

    // Métodos CRUD para PromocaoItemCardapio

    @GetMapping
    public List<PromocaoItemCardapio> listarPromocaoItemCardapio() {
        return promocaoItemCardapioRepository.findAll();
    }

    @GetMapping("/{id}")
    public PromocaoItemCardapio obterPromocaoItemCardapio(@PathVariable Long id) {
        return promocaoItemCardapioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Promoção item cardápio não encontrado"));
    }

    @PostMapping
    public PromocaoItemCardapio criarPromocaoItemCardapio(@RequestBody PromocaoItemCardapio promocaoItemCardapio) {
        return promocaoItemCardapioRepository.save(promocaoItemCardapio);
    }

    @PutMapping("/{id}")
    public PromocaoItemCardapio atualizarPromocaoItemCardapio(@PathVariable Long id, @RequestBody PromocaoItemCardapio promocaoItemCardapioAtualizado) {
        PromocaoItemCardapio promocaoItemCardapio = promocaoItemCardapioRepository.findById(id).orElse(null);
        if (promocaoItemCardapio != null) {
            promocaoItemCardapioAtualizado.setId(id);
            return promocaoItemCardapioRepository.save(promocaoItemCardapioAtualizado);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deletarPromocaoItemCardapio(@PathVariable Long id){
        promocaoItemCardapioRepository.deleteById(id);
    }
}
