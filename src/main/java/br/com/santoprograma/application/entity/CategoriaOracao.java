package br.com.santoprograma.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "CategoriaOracao")
@Table(name = "categoria")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaOracao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "situcao", nullable = false)
    private Integer situacaoCategoria;

    @OneToMany(mappedBy = "categoriaOracao", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @ToString.Exclude
    private List<Oracao> oracoes = new ArrayList<>();
}
