package me.vsc.projeto_dio_rest_api.repository;

import me.vsc.projeto_dio_rest_api.modelo.Pedido;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
