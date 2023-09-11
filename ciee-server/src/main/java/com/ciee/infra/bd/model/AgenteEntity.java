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
@Table(name = "agente")
public class AgenteEntity extends Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer codigo;
    private String data;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agente")
    private List<RegiaoEntity> regiao;

}

