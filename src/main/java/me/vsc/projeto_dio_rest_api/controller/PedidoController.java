package me.vsc.projeto_dio_rest_api.controller;

import me.vsc.projeto_dio_rest_api.modelo.Pedido;
import me.vsc.projeto_dio_rest_api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;
    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Pedido obterpedido(@PathVariable Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }
    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido){
          return pedidoRepository.save(pedido);
    }
    @PutMapping("/{id}")
    public Pedido atualizarpedido(@PathVariable Long id, @RequestBody Pedido pedidoatualizado){
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null){
            pedidoatualizado.setId(id);
            return pedidoRepository.save(pedidoatualizado);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id){
        pedidoRepository.deleteById(id);
    }
}
