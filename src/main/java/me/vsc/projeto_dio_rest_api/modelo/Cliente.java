package me.vsc.projeto_dio_rest_api.modelo;

import jakarta.persistence.*;

import java.util.List;
@Entity(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
    @ManyToMany
    @JoinTable(
            name = "cliente_promocao",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "promocao_id")
    )
    private List<Promocao> promocoesElegiveis;

    // getters and setters
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Promocao> getPromocoesElegiveis() {
        return promocoesElegiveis;
    }

    public void setPromocoesElegiveis(List<Promocao> promocoesElegiveis) {
        this.promocoesElegiveis = promocoesElegiveis;
    }
}