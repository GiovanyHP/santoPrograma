package br.com.santoprograma.application.converter;

import br.com.santoprograma.application.dtos.Oracao.OracaoDTO;
import br.com.santoprograma.application.dtos.Oracao.OracaoGetAllDTO;
import br.com.santoprograma.application.dtos.Oracao.OracaoPostDTO;
import br.com.santoprograma.application.dtos.Oracao.OracaoPutDTO;
import br.com.santoprograma.application.entity.Oracao;
import br.com.santoprograma.application.enums.SituacaoOracao;
import br.com.santoprograma.application.frameworksp.ConverterBase;
import br.com.santoprograma.application.repository.OracaoRepository;
import br.com.santoprograma.application.service.CategoriaOracaoService;
import br.com.santoprograma.application.service.OracaoService;
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

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private CategoriaOracaoService categoriaOracaoService;

    @Override
    public OracaoDTO mapEntityForDTO(Oracao ent) {
        OracaoDTO oracaoDTO = new OracaoDTO();
        oracaoDTO.setId(ent.getId());
        oracaoDTO.setUsuario(usuarioConverter.mapEntityForDTO(ent.getUsuario()));
        oracaoDTO.setDataPedido(ent.getDataPedido());
        oracaoDTO.setPedido(ent.getPedido());
        oracaoDTO.setSituacaoOracao(SituacaoOracao.toEnum(ent.getSituacaoOracao()).getDescricao());
        oracaoDTO.setCategoria(ent.getCategoriaOracao().getNome());

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
        oracao.setCategoriaOracao(categoriaOracaoService.findById(oracaoPostDTO.getCategoria()));

        return oracao;
    }

    @Override
    public Oracao mapDTOForUpdate(Oracao ent, OracaoPutDTO oracaoPutDTO) {

        ent.setUsuario(oracaoPutDTO.getUsuario() != null ? usuarioService.findById(oracaoPutDTO.getUsuario()) : ent.getUsuario());
        ent.setPedido(oracaoPutDTO.getPedido() != null ? oracaoPutDTO.getPedido() : ent.getPedido());
        ent.setSituacaoOracao(oracaoPutDTO.getSituacaoOracao() != null ? SituacaoOracao.toEnum(oracaoPutDTO.getSituacaoOracao()).getCodigo() : ent.getSituacaoOracao());
        ent.setCategoriaOracao(oracaoPutDTO.getCategoria() != null ? categoriaOracaoService.findById(oracaoPutDTO.getCategoria()) : ent.getCategoriaOracao());

        return ent;
    }

    public OracaoGetAllDTO oracoesGetAll(Oracao oracao){
        OracaoGetAllDTO oracaoGetAllDTO = new OracaoGetAllDTO();
        oracaoGetAllDTO.setId(oracao.getId());
        oracaoGetAllDTO.setDataPedido(oracao.getDataPedido());
        oracaoGetAllDTO.setPedido(oracao.getPedido());
        oracaoGetAllDTO.setSituacaoOracao(SituacaoOracao.toEnum(oracao.getSituacaoOracao()).getDescricao());
        oracaoGetAllDTO.setCategoria(oracao.getCategoriaOracao().getNome());

        return oracaoGetAllDTO;
    }
}
