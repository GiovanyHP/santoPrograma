package br.com.santoprograma.application.dtos.Oracao;

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
public class OracaoPostDTO {

    @ApiModelProperty(value = "Usuario do pedido de Oração",required = true)
    private Long usuario;

    @ApiModelProperty(value = "Pedido de Oração", required = true, example = "Faço esse pedido a efeito de teste")
    @NotBlank
    @Size(max = 5000)
    private String pedido;

    @ApiModelProperty(value = "Situação da Oração", required = true, example = "LIDO", allowableValues = "range[1, 15]")
    private Integer situacaoOracao;
}
