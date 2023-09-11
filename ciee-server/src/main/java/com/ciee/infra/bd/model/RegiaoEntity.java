package com.ciee.infra.bd.model;

import com.ciee.domain.dto.Metadata;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "regiao")
public class RegiaoEntity extends Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "id", insertable = false, updatable = false)
    @JoinColumn(name = "agente_id", referencedColumnName = "id")
    private AgenteEntity agente;

    @Column(name = "sigla")
    private String sigla;

    // Mapeamento para as listas de geracao, compra e precoMedio
    @ElementCollection
    @CollectionTable(name = "geracao", joinColumns = @JoinColumn(name = "regiao_id"))
    @Column(name = "valor")
    private List<Double> geracao;

    @ElementCollection
    @CollectionTable(name = "compra", joinColumns = @JoinColumn(name = "regiao_id"))
    @Column(name = "valor")
    private List<Double> compra;

    @ElementCollection
    @CollectionTable(name = "preco_medio", joinColumns = @JoinColumn(name = "regiao_id"))
    @Column(name = "valor")
    private List<Double> precoMedio;

}

