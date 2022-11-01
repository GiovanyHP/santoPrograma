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
public class CategoriaOracaoPutDTO {

    @ApiModelProperty(value = "Descrição da Categoria", example = "Finanças")
    private String nome;

    @ApiModelProperty(value = "Situação da categoria", example = "1")
    private Integer situacaoCategoria;

}
