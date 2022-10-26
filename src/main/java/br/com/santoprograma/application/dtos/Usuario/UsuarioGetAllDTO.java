package br.com.santoprograma.application.dtos.Usuario;

import br.com.santoprograma.application.dtos.Oracao.OracaoGetAllDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGetAllDTO {

    @ApiModelProperty(value = "Id do registro", example = "1")
    private Long idUsuario;

    @ApiModelProperty(value = "Nome do Usuário", example = "José dos Santos")
    @Size(max = 255)
    private String nome;

    @ApiModelProperty(value = "Lista de orações")
    private List<OracaoGetAllDTO> oracoes;

    public void add(OracaoGetAllDTO oracao){
        if (oracoes == null){
            oracoes = new ArrayList<>();
        }

        oracoes.add(oracao);
    }
}
