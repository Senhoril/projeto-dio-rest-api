package me.vsc.projeto_dio_rest_api.controller;

import me.vsc.projeto_dio_rest_api.modelo.ItemCardapio;
import me.vsc.projeto_dio_rest_api.repository.ItemCardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/item-cardapio")
public class ItemCardapioController {
    @Autowired
    private ItemCardapioRepository itemCardapioRepository;
    @GetMapping
    public List<ItemCardapio> listarItemCardapio(){
        return itemCardapioRepository.findAll();
    }
    @GetMapping("/{id}")
    public ItemCardapio obterItemCardapio(@PathVariable Long id){
        return itemCardapioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item cardápio não encontrado"));
    }
    @PostMapping
    public ItemCardapio criarItemCardapio(@RequestBody ItemCardapio itemCardapio){
        return itemCardapioRepository.save(itemCardapio);
    }
    @PutMapping("/{id}")
    public ItemCardapio atualizarItemCardapio(@PathVariable Long id, @RequestBody ItemCardapio itemCardapioAtualizado){
        ItemCardapio itemCardapio = itemCardapioRepository.findById(id).orElse(null);
        if (itemCardapio != null){
            itemCardapioAtualizado.setId(id);
            return itemCardapioRepository.save(itemCardapioAtualizado);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deletarItemCardapio(@PathVariable Long id ){
        itemCardapioRepository.deleteById(id);
    }
}
