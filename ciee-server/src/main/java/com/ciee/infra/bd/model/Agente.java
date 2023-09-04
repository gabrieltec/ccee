package com.ciee.infra.bd.model;

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
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int codigo;
    private String data;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agente")
    private List<Regiao> regiao;

}

