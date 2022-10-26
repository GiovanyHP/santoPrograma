package br.com.santoprograma.application.converter;

import br.com.santoprograma.application.dtos.Usuario.UsuarioDTO;
import br.com.santoprograma.application.dtos.Usuario.UsuarioGetAllDTO;
import br.com.santoprograma.application.dtos.Usuario.UsuarioPostDTO;
import br.com.santoprograma.application.dtos.Usuario.UsuarioPutDTO;
import br.com.santoprograma.application.entity.Oracao;
import br.com.santoprograma.application.entity.Usuario;
import br.com.santoprograma.application.enums.NivelUsuario;
import br.com.santoprograma.application.enums.SituacaoUsuario;
import br.com.santoprograma.application.frameworksp.ConverterBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class UsuarioConverter implements ConverterBase<Usuario, UsuarioDTO, UsuarioPostDTO, UsuarioPutDTO>{

    @Autowired
    private OracaoConverter oracaoConverter;

    @Override
    public UsuarioDTO mapEntityForDTO(Usuario ent) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setIdUsuario(ent.getIdUsuario());
        usuarioDTO.setNome(ent.getNome());
        usuarioDTO.setDtNascimento(ent.getDtNascimento());
        usuarioDTO.setDtCadastro(ent.getDtCadastro());
        usuarioDTO.setTipoLogradouro(ent.getTipoLogradouro());
        usuarioDTO.setLogradouro(ent.getLogradouro());
        usuarioDTO.setNumero(ent.getNumero());
        usuarioDTO.setComplemento(ent.getComplemento());
        usuarioDTO.setBairro(ent.getBairro());
        usuarioDTO.setCidade(ent.getCidade());
        usuarioDTO.setCep(ent.getCep());
        usuarioDTO.setUf(ent.getUf());
        usuarioDTO.setTelefone(ent.getTelefone());
        usuarioDTO.setEmail(ent.getEmail());
        usuarioDTO.setCpf(ent.getCpf());

        if (ent.getSituacaoUsuario() == null) {
            usuarioDTO.setSituacaoUsuario(SituacaoUsuario.ATIVO.getDescricao() + " *SETADO POIS ESTAVA VAZIO*");
        } else {

            usuarioDTO.setSituacaoUsuario(SituacaoUsuario.toEnum(ent.getSituacaoUsuario()).getDescricao());
        }

        if (ent.getNivelUsuario() == null) {
            usuarioDTO.setNivelUsuario(NivelUsuario.PADRAO.getDescricao() + " *SETADO POIS ESTAVA VAZIO*");
        } else {

            usuarioDTO.setNivelUsuario(NivelUsuario.toEnum(ent.getNivelUsuario()).getDescricao());
        }

        return usuarioDTO;
    }

    @Override
    public List<UsuarioDTO> mapEntityForDTOGetAll(List<Usuario> list) {
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();

        for (Usuario usuario : list) {
            listaUsuariosDTO.add(mapEntityForDTO(usuario));
        }
        return listaUsuariosDTO;
    }

    @Override
    public Usuario mapDTOForInsert(UsuarioPostDTO usuarioPostDTO) {
        Usuario usuario = new Usuario();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        usuario.setNome(usuarioPostDTO.getNome());
        usuario.setDtNascimento(usuarioPostDTO.getDtNascimento());
        usuario.setDtCadastro(Calendar.getInstance().getTime());
        usuario.setTipoLogradouro(usuarioPostDTO.getTipoLogradouro());
        usuario.setLogradouro(usuarioPostDTO.getLogradouro());
        usuario.setNumero(usuarioPostDTO.getNumero());
        usuario.setComplemento(usuarioPostDTO.getComplemento());
        usuario.setBairro(usuarioPostDTO.getBairro());
        usuario.setCidade(usuarioPostDTO.getCidade());
        usuario.setCep(usuarioPostDTO.getCep());
        usuario.setUf(usuarioPostDTO.getUf());
        usuario.setTelefone(usuarioPostDTO.getTelefone());
        usuario.setEmail(usuarioPostDTO.getEmail());
        usuario.setCpf(usuarioPostDTO.getCpf());
        usuario.setSituacaoUsuario(SituacaoUsuario.ATIVO.getCodigo());
        usuario.setNivelUsuario(NivelUsuario.PADRAO.getCodigo());

        String encoder = passwordEncoder.encode(usuarioPostDTO.getSenha());
        usuario.setSenha(encoder);

        return usuario;
    }

    @Override
    public Usuario mapDTOForUpdate(Usuario ent, UsuarioPutDTO usuarioPutDTO) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        ent.setNome(usuarioPutDTO.getNome() != null ? usuarioPutDTO.getNome() : ent.getNome());
        ent.setDtNascimento(usuarioPutDTO.getDtNascimento() != null ? usuarioPutDTO.getDtNascimento() : ent.getDtNascimento());
        ent.setTipoLogradouro(usuarioPutDTO.getTipoLogradouro() != null ? usuarioPutDTO.getTipoLogradouro() : ent.getTipoLogradouro());
        ent.setLogradouro(usuarioPutDTO.getLogradouro() != null ? usuarioPutDTO.getLogradouro() : ent.getLogradouro());
        ent.setNumero(usuarioPutDTO.getNumero() != null ? usuarioPutDTO.getNumero() : ent.getNumero());
        ent.setComplemento(usuarioPutDTO.getComplemento() != null ? usuarioPutDTO.getComplemento() : ent.getComplemento());
        ent.setBairro(usuarioPutDTO.getBairro() != null ? usuarioPutDTO.getBairro() : ent.getBairro());
        ent.setCidade(usuarioPutDTO.getCidade() != null ? usuarioPutDTO.getCidade() : ent.getCidade());
        ent.setCep(usuarioPutDTO.getCep() != null ? usuarioPutDTO.getCep() : ent.getCep());
        ent.setUf(usuarioPutDTO.getUf() != null ? usuarioPutDTO.getUf() : ent.getUf());
        ent.setTelefone(usuarioPutDTO.getTelefone() != null ? usuarioPutDTO.getTelefone() : ent.getTelefone());
        ent.setEmail(usuarioPutDTO.getEmail() != null ? usuarioPutDTO.getEmail() : ent.getEmail());
        ent.setCpf(usuarioPutDTO.getCpf() != null ? usuarioPutDTO.getCpf() : ent.getCpf());

        if (usuarioPutDTO.getSituacaoUsuario() != null) {
            ent.setSituacaoUsuario(SituacaoUsuario.toEnum(usuarioPutDTO.getSituacaoUsuario()).getCodigo());
        }

        if (usuarioPutDTO.getNivelUsuario() != null) {
            ent.setNivelUsuario(NivelUsuario.toEnum(usuarioPutDTO.getNivelUsuario()).getCodigo());
        }

        if (usuarioPutDTO.getSenha() != null) {
            ent.setSenha(passwordEncoder.encode(usuarioPutDTO.getSenha()));
        }

        return ent;
    }

    public UsuarioGetAllDTO mapEntityForList(Usuario usuario) {
        UsuarioGetAllDTO usuarioGetAllDTO = new UsuarioGetAllDTO();

        usuarioGetAllDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioGetAllDTO.setNome(usuario.getNome());

        for (Oracao oracao : usuario.getPedidosOracao()) {
            usuarioGetAllDTO.add(oracaoConverter.oracoesGetAll(oracao));
        }

        return usuarioGetAllDTO;
    }
}
