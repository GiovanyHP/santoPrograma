package br.com.santoprograma.application.converter;

import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoDTO;
import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoPostDTO;
import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoPutDTO;
import br.com.santoprograma.application.entity.CategoriaOracao;
import br.com.santoprograma.application.frameworksp.ConverterBase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaOracaoConverter implements ConverterBase<CategoriaOracao, CategoriaOracaoDTO, CategoriaOracaoPostDTO, CategoriaOracaoPutDTO> {

    @Override
    public CategoriaOracaoDTO mapEntityForDTO(CategoriaOracao ent) {
        return null;
    }

    @Override
    public List<CategoriaOracaoDTO> mapEntityForDTOGetAll(List<CategoriaOracao> list) {
        return null;
    }

    @Override
    public CategoriaOracao mapDTOForInsert(CategoriaOracaoPostDTO categoriaOracaoPostDTO) {
        return null;
    }

    @Override
    public CategoriaOracao mapDTOForUpdate(CategoriaOracao ent, CategoriaOracaoPutDTO categoriaOracaoPutDTO) {
        return null;
    }
}
