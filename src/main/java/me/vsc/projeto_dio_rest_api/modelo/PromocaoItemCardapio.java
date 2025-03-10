package me.vsc.projeto_dio_rest_api.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
public class PromocaoItemCardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal precoDescontado;
    @ManyToOne
    private Promocao promocao;
    @ManyToOne
    private ItemCardapio itemCardapio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecoDescontado() {
        return precoDescontado;
    }

    public void setPrecoDescontado(BigDecimal precoDescontado) {
        this.precoDescontado = precoDescontado;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }
}
