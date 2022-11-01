package br.com.santoprograma.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "CategoriaOracao")
@Table(name = "categoria")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaOracao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "situcao", nullable = false)
    private Integer situacaoCategoria;

}
