package br.com.santoprograma.application.controller;

import br.com.santoprograma.application.converter.CategoriaOracaoConverter;
import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoDTO;
import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoPostDTO;
import br.com.santoprograma.application.dtos.CategoriaOracao.CategoriaOracaoPutDTO;
import br.com.santoprograma.application.entity.CategoriaOracao;
import br.com.santoprograma.application.frameworksp.ControllerBase;
import br.com.santoprograma.application.service.CategoriaOracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias-oracoes")
public class CategoriaOracaoController implements ControllerBase<CategoriaOracaoDTO, CategoriaOracaoDTO, CategoriaOracaoPostDTO, CategoriaOracaoPutDTO> {

    @Autowired
    private CategoriaOracaoService categoriaOracaoService;

    @Autowired
    private CategoriaOracaoConverter categoriaOracaoConverter;

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoriaOracaoDTO> findById(Long id) {
        CategoriaOracao categoriaOracao = categoriaOracaoService.findById(id);
        return ResponseEntity.ok().body(categoriaOracaoConverter.mapEntityForDTO(categoriaOracao));
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CategoriaOracaoDTO>> findAll() {
        List<CategoriaOracao> categorias = categoriaOracaoService.findAll();
        return ResponseEntity.ok().body(categoriaOracaoConverter.mapEntityForDTOGetAll(categorias));
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoriaOracaoDTO> create(@Valid @RequestBody CategoriaOracaoPostDTO categoriaOracaoPostDTO) {
        CategoriaOracaoDTO categoriaOracaoDTO = categoriaOracaoService.create(categoriaOracaoPostDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoriaOracaoDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoriaOracaoDTO> update(@PathVariable Long id, @RequestBody @Valid CategoriaOracaoPutDTO categoriaOracaoPutDTO) {
        CategoriaOracaoDTO categoriaOracaoDTO = categoriaOracaoService.update(id, categoriaOracaoPutDTO);
        return ResponseEntity.ok().body(categoriaOracaoDTO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaOracaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
