package br.com.santoprograma.application.service;

import br.com.santoprograma.application.converter.CategoriaOracaoConverter;
import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoDTO;
import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoPostDTO;
import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoPutDTO;
import br.com.santoprograma.application.entity.CategoriaOracao;
import br.com.santoprograma.application.repository.CategoriaOracaoRepository;
import br.com.santoprograma.application.service.exceptions.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaOracaoService {

    @Autowired
    private CategoriaOracaoConverter categoriaOracaoConverter;

    @Autowired
    private CategoriaOracaoRepository categoriaOracaoRepository;

    public CategoriaOracao findById(Long id) {
        CategoriaOracao categoriaOracao = categoriaOracaoRepository.getById(id);

        if (categoriaOracao == null) {
            throw new InternalServerErrorException("Categoria da Oração Não encontrada na base de dados");
        }

        return categoriaOracao;
    }

    public List<CategoriaOracao> findAll() {
        return categoriaOracaoRepository.findAll();
    }

    public CategoriaOracaoDTO create(CategoriaOracaoPostDTO categoriaOracaoPostDTO) {

        CategoriaOracao categoriaOracao = categoriaOracaoConverter.mapDTOForInsert(categoriaOracaoPostDTO);
        categoriaOracaoRepository.save(categoriaOracao);
        return categoriaOracaoConverter.mapEntityForDTO(categoriaOracao);
    }

    public CategoriaOracaoDTO update(Long id, CategoriaOracaoPutDTO categoriaOracaoPutDTO) {
        CategoriaOracao categoriaOracao = findById(id);

        categoriaOracaoConverter.mapDTOForUpdate(categoriaOracao, categoriaOracaoPutDTO);
        categoriaOracaoRepository.save(categoriaOracao);
        return categoriaOracaoConverter.mapEntityForDTO(categoriaOracao);
    }

    public void delete(Long id) {
        findById(id);
        categoriaOracaoRepository.deleteById(id);
    }

}
