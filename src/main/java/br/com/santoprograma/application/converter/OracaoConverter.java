package br.com.santoprograma.application.converter;

import br.com.santoprograma.application.dtos.OracaoDTO;
import br.com.santoprograma.application.dtos.OracaoPostDTO;
import br.com.santoprograma.application.dtos.OracaoPutDTO;
import br.com.santoprograma.application.entity.Oracao;
import br.com.santoprograma.application.enums.SituacaoOracao;
import br.com.santoprograma.application.frameworksp.ConverterBase;
import br.com.santoprograma.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class OracaoConverter implements ConverterBase<Oracao, OracaoDTO, OracaoPostDTO, OracaoPutDTO> {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public OracaoDTO mapEntityForDTO(Oracao ent) {
        OracaoDTO oracaoDTO = new OracaoDTO();
        oracaoDTO.setId(ent.getId());
        oracaoDTO.setUsuario(UsuarioConverter.mapEntityForDTO(ent.getUsuario()));
        oracaoDTO.setDataPedido(ent.getDataPedido());
        oracaoDTO.setPedido(ent.getPedido());
        oracaoDTO.setSituacaoOracao(SituacaoOracao.toEnum(ent.getSituacaoOracao()).getDescricao());

        return oracaoDTO;
    }

    @Override
    public List<OracaoDTO> mapEntityForDTOGetAll(List<Oracao> list) {
        List<OracaoDTO> listaOracaoDTO = new ArrayList<>();

        for (Oracao oracao : list) {
            listaOracaoDTO.add(mapEntityForDTO(oracao));
        }

        return listaOracaoDTO;
    }

    @Override
    public Oracao mapDTOForInsert(OracaoPostDTO oracaoPostDTO) {
        Oracao oracao = new Oracao();

        oracao.setUsuario(usuarioService.findById(oracaoPostDTO.getUsuario()));
        oracao.setDataPedido(LocalDateTime.now());
        oracao.setPedido(oracaoPostDTO.getPedido());
        oracao.setSituacaoOracao(SituacaoOracao.toEnum(oracaoPostDTO.getSituacaoOracao()).getCodigo());

        return oracao;
    }

    @Override
    public Oracao mapDTOForUpdate(Oracao ent, OracaoPutDTO oracaoPutDTO) {

        ent.setUsuario(oracaoPutDTO.getUsuario() != null ? usuarioService.findById(oracaoPutDTO.getUsuario()) : ent.getUsuario());
        ent.setPedido(oracaoPutDTO.getPedido() != null ? oracaoPutDTO.getPedido() : ent.getPedido());
        ent.setSituacaoOracao(oracaoPutDTO.getSituacaoOracao() != null ? SituacaoOracao.toEnum(oracaoPutDTO.getSituacaoOracao()).getCodigo() : ent.getSituacaoOracao());

        return ent;
    }
}
