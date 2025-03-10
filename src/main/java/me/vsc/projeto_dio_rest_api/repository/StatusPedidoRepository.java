package me.vsc.projeto_dio_rest_api.repository;

import me.vsc.projeto_dio_rest_api.modelo.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusPedidoRepository extends JpaRepository<StatusPedido, Long> {
}
