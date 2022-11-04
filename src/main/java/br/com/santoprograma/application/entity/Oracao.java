package br.com.santoprograma.application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity(name = "Oracao")
@Table(name = "oracao")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Oracao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "pedido", length = 5000)
    private String pedido;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataPedido;

    @Column(name = "situacao")
    private Integer situacaoOracao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_categoria")
    private CategoriaOracao categoriaOracao;
}
