package me.vsc.projeto_dio_rest_api.controller;

import me.vsc.projeto_dio_rest_api.modelo.ItemPedido;
import me.vsc.projeto_dio_rest_api.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @GetMapping
    public List<ItemPedido> listarItenspedidos(){
        return itemPedidoRepository.findAll();
    }
    @GetMapping("/{id}")
    public ItemPedido obterPedido(@PathVariable Long id){
        return itemPedidoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item pedido não encontrado"));
    }
    @PostMapping
    public ItemPedido criarPedido(@RequestBody ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }
    @PutMapping("/{id}")
    public ItemPedido atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedidoAtualizado){
        ItemPedido itemPedido = itemPedidoRepository.findById(id).orElse(null);
        if (itemPedido != null){
            itemPedidoAtualizado.setId(id);
            return itemPedidoRepository.save(itemPedidoAtualizado);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id){
        itemPedidoRepository.deleteById(id);
    }
}
