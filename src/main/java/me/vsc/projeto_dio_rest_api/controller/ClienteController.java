package me.vsc.projeto_dio_rest_api.controller;

import me.vsc.projeto_dio_rest_api.modelo.Cliente;
import me.vsc.projeto_dio_rest_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado){
       Cliente cliente =  clienteRepository.findById(id).orElse(null);
       if (cliente != null){
           clienteAtualizado.setId(id);
           return clienteRepository.save(clienteAtualizado);
       }
       return null;
    }
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }

}
