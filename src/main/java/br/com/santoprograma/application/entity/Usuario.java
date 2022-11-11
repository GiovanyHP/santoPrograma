package br.com.santoprograma.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Usuario")
@Table(name = "usuario")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long idUsuario;

    @Column(name = "nome", nullable = false, length = 300)
    private String nome;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "dt_nascimento")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dtNascimento;

    @Column(name = "dtCadastro", updatable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date dtCadastro;

    @Column(name = "tipoLogradoro", length = 15)
    private String tipoLogradouro;

    @Column(name = "logradouro")
    private String Logradouro;

    @Column(name = "numero", length = 10)
    private String numero;

    @Column(name = "complemento", length = 100)
    private String complemento;

    @Column(name = "bairro", length = 100)
    private String bairro;

    @Column(name = "cidade", length = 150)
    private String cidade;

    @Column(name = "cep", length = 15)
    private String cep;

    @Column(name = "uf", length = 3)
    private String uf;

    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;

    @Column(name = "email", length = 100, unique = true)
    @Email
    private String email;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    @CPF
    private String cpf;

    @Column(name = "situacao")
    private Integer situacaoUsuario;

    @Column(name = "nivel")
    private Integer nivelUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @ToString.Exclude
    private List<Oracao> pedidosOracao = new ArrayList<>();
}
