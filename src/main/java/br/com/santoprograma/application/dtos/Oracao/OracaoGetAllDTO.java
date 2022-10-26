package br.com.santoprograma.application.dtos.Oracao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OracaoGetAllDTO {

    @ApiModelProperty(value = "Id do Pedido de Oração")
    private Long id;

    @ApiModelProperty(value = "Pedido de Oração", example = "Faço esse pedido a efeito de teste")
    @Size(max = 5000)
    private String pedido;

    @ApiModelProperty(value = "Data do Pedido de Oração")
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime dataPedido;

    @ApiModelProperty(value = "Situação da Oração", example = "0")
    private String situacaoOracao;
}
