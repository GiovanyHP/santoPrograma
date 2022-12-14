package br.com.santoprograma.application.controller;

import br.com.santoprograma.application.converter.UsuarioConverter;
import br.com.santoprograma.application.dtos.Usuario.*;
import br.com.santoprograma.application.entity.Usuario;
import br.com.santoprograma.application.service.UsuarioService;
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
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        Usuario obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuarioConverter.mapEntityForDTO(obj));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarioConverter.mapEntityForDTOGetAll(usuarios));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioDTO> create(@RequestBody @Valid UsuarioPostDTO usuarioPostDTO) {
        UsuarioDTO usuarioDTO = usuarioService.create(usuarioPostDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioDTO.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).body(usuarioDTO);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @Valid @RequestBody UsuarioPutDTO usuarioPutDTO) {
        UsuarioDTO usuarioDTO = usuarioService.update(id, usuarioPutDTO);
        return ResponseEntity.ok().body(usuarioDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UsuarioDTO> login(@Valid @RequestBody UsuarioLoginDTO usuarioLoginDTO) {
        Usuario usuario = usuarioService.usuarioLogin(usuarioLoginDTO);
        UsuarioDTO usuarioDTO = usuarioConverter.mapEntityForDTO(usuario);

        if (usuario != null) {
            return ResponseEntity.ok().body(usuarioDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/{id}/oracoes")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioGetAllDTO> oracoesUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);

        return ResponseEntity.ok().body(usuarioService.oracoesUsuario(usuario));
    }
}
