package br.com.santoprograma.application.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLoginDTO {

    @ApiModelProperty(value = "Email do Usuário", required = true, example = "exemplo@exemplo.com.br", allowableValues = "range[1, 100]")
    private String email;

    @ApiModelProperty(value = "Senha do Usuário", example = "123456789", required = true)
    @NotBlank
    @Size(max = 255)
    private String senha;
}
