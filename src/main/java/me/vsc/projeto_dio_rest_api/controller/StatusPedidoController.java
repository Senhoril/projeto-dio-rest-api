package me.vsc.projeto_dio_rest_api.controller;

import me.vsc.projeto_dio_rest_api.modelo.StatusPedido;
import me.vsc.projeto_dio_rest_api.repository.StatusPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/status-pedido")
public class StatusPedidoController {
    @Autowired
    StatusPedidoRepository statusPedidoRepository;
    @GetMapping
    public List<StatusPedido> listarStatusPedidos(){
        return statusPedidoRepository.findAll();
    }
    @GetMapping("/{id}")
    public StatusPedido obterStatusPedido(@PathVariable Long id){
        return statusPedidoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status de pedido não encontrado"));
    }
    @PostMapping
    public StatusPedido criarStatusPedido(@RequestBody StatusPedido statusPedido){
        return statusPedidoRepository.save(statusPedido);
    }
    @PutMapping("/{id}")
    public StatusPedido atualizarStatusPedido(@PathVariable Long id, @RequestBody StatusPedido statusPedidoAtualizado){
        StatusPedido statusPedido = statusPedidoRepository.findById(id).orElse(null);
        if (statusPedido != null){
            statusPedidoAtualizado.setId(id);
            return statusPedidoRepository.save(statusPedidoAtualizado);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deletarStatusPedido(@PathVariable Long id){
        statusPedidoRepository.deleteById(id);
    }
}
