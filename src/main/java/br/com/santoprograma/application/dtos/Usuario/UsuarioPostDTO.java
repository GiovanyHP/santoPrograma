package br.com.santoprograma.application.dtos.Usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPostDTO {

    @ApiModelProperty(value = "Nome do Usuário", example = "José dos Santos", required = true)
    @NotBlank
    @Size(max = 255)
    private String nome;

    @ApiModelProperty(value = "Senha do Usuário", example = "123456789", required = true)
    //@NotBlank
    @Size(max = 255)
    private String senha;

    @ApiModelProperty(value = "Data de Nascimento do Usuário", required = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dtNascimento;

    @ApiModelProperty(value = "Tipo do logradouro", required = true, example = "text", allowableValues = "range[1, 100]")
    private String tipoLogradouro;

    @ApiModelProperty(value = "Logradouro", required = true, example = "text", allowableValues = "range[1, 200]")
    @Size(max = 200)
    private String Logradouro;

    @ApiModelProperty(value = "Número do logradouro", required = true, example = "text", allowableValues = "range[1, 20]")
    @Size(max = 20)
    private String numero;

    @ApiModelProperty(value = "Complemento do logradouro", example = "text", allowableValues = "range[1, 100]")
    @Size(max = 100)
    private String complemento;

    @ApiModelProperty(value = "Bairro", required = true, example = "text", allowableValues = "range[1, 100]")
    private String bairro;

    @ApiModelProperty(value = "Cidade", required = true, example = "text", allowableValues = "range[1, 100]")
    private String cidade;

    @ApiModelProperty(value = "Número do CEP", required = true, example = "81100000")
    private String cep;

    @ApiModelProperty(value = "Sigla da UF", required = true, example = "PR", allowableValues = "range[1, 3]")
    private String uf;

    @ApiModelProperty(value = "Telefone do Usuário", required = true, example = "(041) 99552-4488", allowableValues = "range[1, 20]")
    private String telefone;

    @ApiModelProperty(value = "Email do Usuário", required = true, example = "exemplo@exemplo.com.br", allowableValues = "range[1, 100]")
    private String email;

    @ApiModelProperty(value = "CPF do Usuário", required = true, example = "50938275097", allowableValues = "range[1, 11]")
    @CPF
    private String cpf;

}
