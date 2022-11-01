package br.com.santoprograma.application.dtos.CategoriaOracao;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaOracaoDTO {

    @ApiModelProperty(value = "Id do registro", example = "1")
    private Long id;

    @ApiModelProperty(value = "Descrição da categoria", example = "Financeira")
    private String nome;

    @ApiModelProperty(value = "Situação da categoria", example = "Ativo")
    private String situacaoCategoria;
}
