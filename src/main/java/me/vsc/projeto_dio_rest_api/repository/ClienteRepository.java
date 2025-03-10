package me.vsc.projeto_dio_rest_api.repository;

import me.vsc.projeto_dio_rest_api.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{
}
