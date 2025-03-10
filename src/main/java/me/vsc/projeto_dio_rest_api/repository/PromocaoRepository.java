package me.vsc.projeto_dio_rest_api.repository;

import me.vsc.projeto_dio_rest_api.modelo.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {

}
