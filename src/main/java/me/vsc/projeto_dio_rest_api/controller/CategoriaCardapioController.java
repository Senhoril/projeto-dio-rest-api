package me.vsc.projeto_dio_rest_api.controller;

import me.vsc.projeto_dio_rest_api.modelo.CategoriaCardapio;
import me.vsc.projeto_dio_rest_api.repository.CategoriaCardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/categorias-cardapio")
public class CategoriaCardapioController {
    @Autowired
    private CategoriaCardapioRepository categoriaCardapioRepository;
     @GetMapping
    public List<CategoriaCardapio> listarCategorias(){
         return categoriaCardapioRepository.findAll();
     }
     @GetMapping("/{id}")
    public CategoriaCardapio obterCategoria(@PathVariable Long id){
         return categoriaCardapioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
     }
     @PostMapping
    public CategoriaCardapio criarCardapio(@RequestBody CategoriaCardapio categoriaCardapio){
     return categoriaCardapioRepository.save(categoriaCardapio);
     }
     @PutMapping("/{id}")
    public CategoriaCardapio atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaCardapio categoriaAtulizada){
         CategoriaCardapio categoriaCardapio = categoriaCardapioRepository.findById(id).orElse(null);
         if (categoriaCardapio != null){
            categoriaAtulizada.setId(id);
            return categoriaCardapioRepository.save(categoriaAtulizada);
         }
         return null;
     }
     @DeleteMapping("/{id}")
    public void deletarCategoriaCardapio(@PathVariable Long id){
         categoriaCardapioRepository.deleteById(id);
    }
}
