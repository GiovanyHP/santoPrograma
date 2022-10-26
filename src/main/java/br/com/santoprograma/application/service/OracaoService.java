package br.com.santoprograma.application.service;

import br.com.santoprograma.application.converter.OracaoConverter;
import br.com.santoprograma.application.dtos.Oracao.OracaoDTO;
import br.com.santoprograma.application.dtos.Oracao.OracaoPostDTO;
import br.com.santoprograma.application.dtos.Oracao.OracaoPutDTO;
import br.com.santoprograma.application.entity.Oracao;
import br.com.santoprograma.application.repository.OracaoRepository;
import br.com.santoprograma.application.service.exceptions.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OracaoService {

    @Autowired
    private OracaoConverter oracaoConverter;

    @Autowired
    private OracaoRepository oracaoRepository;

    public Oracao findById(Long id) {
        Oracao oracao = oracaoRepository.getById(id);

        if (oracao == null) {
            throw new InternalServerErrorException("Oração Não encontrada na base de dados");
        }

        return oracao;
    }

    public List<Oracao> findAll() {
        return oracaoRepository.findAll();
    }

    public OracaoDTO create(OracaoPostDTO oracaoPostDTO) {

        Oracao oracao = oracaoConverter.mapDTOForInsert(oracaoPostDTO);
        oracaoRepository.save(oracao);
        return oracaoConverter.mapEntityForDTO(oracao);
    }

    public OracaoDTO update(Long id, OracaoPutDTO oracaoPutDTO) {
        Oracao oracao = findById(id);

        oracaoConverter.mapDTOForUpdate(oracao, oracaoPutDTO);
        oracaoRepository.save(oracao);
        return oracaoConverter.mapEntityForDTO(oracao);
    }

    public void delete(Long id) {
        findById(id);
        oracaoRepository.deleteById(id);
    }
}