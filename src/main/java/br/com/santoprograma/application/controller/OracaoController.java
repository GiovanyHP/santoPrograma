package br.com.santoprograma.application.controller;

import br.com.santoprograma.application.converter.OracaoConverter;
import br.com.santoprograma.application.dtos.OracaoDTO;
import br.com.santoprograma.application.dtos.OracaoPostDTO;
import br.com.santoprograma.application.dtos.OracaoPutDTO;
import br.com.santoprograma.application.entity.Oracao;
import br.com.santoprograma.application.frameworksp.ControllerBase;
import br.com.santoprograma.application.service.OracaoService;
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
@RequestMapping(value = "/oracoes")
public class OracaoController implements ControllerBase<OracaoDTO, OracaoDTO, OracaoPostDTO, OracaoPutDTO> {

    @Autowired
    private OracaoService oracaoService;

    @Autowired
    private OracaoConverter oracaoConverter;

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OracaoDTO> findById(Long id) {
        Oracao oracao = oracaoService.findById(id);
        return ResponseEntity.ok().body(oracaoConverter.mapEntityForDTO(oracao));
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<OracaoDTO>> findAll() {
        List<Oracao> oracoes = oracaoService.findAll();
        return ResponseEntity.ok().body(oracaoConverter.mapEntityForDTOGetAll(oracoes));
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OracaoDTO> create(@Valid @RequestBody OracaoPostDTO oracaoPostDTO) {
        OracaoDTO oracaoDTO = oracaoService.create(oracaoPostDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(oracaoDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OracaoDTO> update(Long id, @Valid OracaoPutDTO oracaoPutDTO) {
        return null;
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(Long id) {
        oracaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
