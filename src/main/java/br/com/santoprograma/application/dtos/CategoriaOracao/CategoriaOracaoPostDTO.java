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
public class CategoriaOracaoPostDTO {

    @ApiModelProperty(value = "Descrição da Categoria", example = "Finanças", required = true)
    private String nome;

}
