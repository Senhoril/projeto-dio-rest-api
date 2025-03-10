package me.vsc.projeto_dio_rest_api.repository;

import me.vsc.projeto_dio_rest_api.modelo.CategoriaCardapio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaCardapioRepository extends JpaRepository<CategoriaCardapio, Long> {
}
