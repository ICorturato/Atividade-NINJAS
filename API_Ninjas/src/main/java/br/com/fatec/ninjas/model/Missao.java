package br.com.fatec.ninjas.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;


@Data
@Entity
@Table(name="missao")
@Valid
public class Missao {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id_missao;

    @Column (name = "titulo_missao", nullable=false)
    @NotBlank(message = "O titulo é obrigatório.")
    @Size (min = 3, max = 50, message = "titulo deve ter entre 3 e 50 caracteres.")
    private String titulo;

    @Column(name = "descricao_missao", nullable = false)
    @NotBlank(message = "A descrição da missão é obrigatória.")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "rank_missao", nullable = false)
    @NotNull(message = "O rank da missão é obrigatório.")
    private RankMissao  rank;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_missao", nullable = false)
    @NotNull(message = "O status da missão é obrigatório.")
    private StatusMissao  status;

    @Column(name = "recompensa_missao", nullable = false)
    @NotNull(message = "A recompensa da missão é obrigatória.")
    private Double recompensa;
}

