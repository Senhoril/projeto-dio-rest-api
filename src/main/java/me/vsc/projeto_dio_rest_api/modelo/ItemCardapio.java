package me.vsc.projeto_dio_rest_api.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
@Entity
public class ItemCardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    @ManyToOne
    private CategoriaCardapio categoria;
    private boolean disponivel;
    @OneToMany(mappedBy = "itemCardapio")
    private List<PromocaoItemCardapio> promocoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public CategoriaCardapio getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCardapio categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<PromocaoItemCardapio> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<PromocaoItemCardapio> promocoes) {
        this.promocoes = promocoes;
    }
}
