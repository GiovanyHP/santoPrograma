package br.com.santoprograma.application.converter;

import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoDTO;
import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoPostDTO;
import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoPutDTO;
import br.com.santoprograma.application.entity.CategoriaOracao;
import br.com.santoprograma.application.enums.SituacaoCategoria;
import br.com.santoprograma.application.frameworksp.ConverterBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaOracaoConverter implements ConverterBase<CategoriaOracao, CategoriaOracaoDTO, CategoriaOracaoPostDTO, CategoriaOracaoPutDTO> {

    @Override
    public CategoriaOracaoDTO mapEntityForDTO(CategoriaOracao ent) {
        CategoriaOracaoDTO categoriaOracaoDTO = new CategoriaOracaoDTO();
        categoriaOracaoDTO.setId(ent.getId());
        categoriaOracaoDTO.setNome(ent.getNome());
        categoriaOracaoDTO.setSituacaoCategoria(SituacaoCategoria.toEnum(ent.getSituacaoCategoria()).getDescricao());

        return categoriaOracaoDTO;
    }

    @Override
    public List<CategoriaOracaoDTO> mapEntityForDTOGetAll(List<CategoriaOracao> list) {
        List<CategoriaOracaoDTO> categoriaOracoes = new ArrayList<>();

        for (CategoriaOracao categoriaOracao : list) {
            categoriaOracoes.add(mapEntityForDTO(categoriaOracao));
        }

        return categoriaOracoes;
    }

    @Override
    public CategoriaOracao mapDTOForInsert(CategoriaOracaoPostDTO categoriaOracaoPostDTO) {

        CategoriaOracao categoriaOracao = new CategoriaOracao();
        categoriaOracao.setNome(categoriaOracaoPostDTO.getNome());
        categoriaOracao.setSituacaoCategoria(1);

        return categoriaOracao;

    }

    @Override
    public CategoriaOracao mapDTOForUpdate(CategoriaOracao ent, CategoriaOracaoPutDTO categoriaOracaoPutDTO) {
        ent.setNome(categoriaOracaoPutDTO.getNome() != null ? categoriaOracaoPutDTO.getNome() : ent.getNome());
        ent.setSituacaoCategoria(categoriaOracaoPutDTO.getSituacaoCategoria() != null ? SituacaoCategoria.toEnum(categoriaOracaoPutDTO.getSituacaoCategoria()).getCodigo() : ent.getSituacaoCategoria());

        return ent;
    }
}
