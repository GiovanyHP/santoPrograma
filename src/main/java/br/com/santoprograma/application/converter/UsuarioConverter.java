package br.com.santoprograma.application.converter;

import br.com.santoprograma.application.dtos.UsuarioDTO;
import br.com.santoprograma.application.dtos.UsuarioPostDTO;
import br.com.santoprograma.application.dtos.UsuarioPutDTO;
import br.com.santoprograma.application.entity.Usuario;
import br.com.santoprograma.application.enums.NivelUsuario;
import br.com.santoprograma.application.enums.SituacaoUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class UsuarioConverter {

    public static UsuarioDTO mapEntityForDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setDtNascimento(usuario.getDtNascimento());
        usuarioDTO.setDtCadastro(usuario.getDtCadastro());
        usuarioDTO.setTipoLogradouro(usuario.getTipoLogradouro());
        usuarioDTO.setLogradouro(usuario.getLogradouro());
        usuarioDTO.setNumero(usuario.getNumero());
        usuarioDTO.setComplemento(usuario.getComplemento());
        usuarioDTO.setBairro(usuario.getBairro());
        usuarioDTO.setCidade(usuario.getCidade());
        usuarioDTO.setCep(usuario.getCep());
        usuarioDTO.setUf(usuario.getUf());
        usuarioDTO.setTelefone(usuario.getTelefone());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setCpf(usuario.getCpf());

        if (usuario.getSituacaoUsuario() == null) {
            usuarioDTO.setSituacaoUsuario(SituacaoUsuario.ATIVO.getDescricao() + " *SETADO POIS ESTAVA VAZIO*");
        } else {

            usuarioDTO.setSituacaoUsuario(SituacaoUsuario.toEnum(usuario.getSituacaoUsuario()).getDescricao());
        }

        if (usuario.getNivelUsuario() == null) {
            usuarioDTO.setNivelUsuario(NivelUsuario.PADRAO.getDescricao() + " *SETADO POIS ESTAVA VAZIO*");
        } else {

            usuarioDTO.setNivelUsuario(NivelUsuario.toEnum(usuario.getNivelUsuario()).getDescricao());
        }

        return usuarioDTO;
    }

    public static List<UsuarioDTO> mapEntityForDTOGetAll(List<Usuario> listUsuarios) {
        List<UsuarioDTO> listaUsuariosDTO = new ArrayList<>();

        for (Usuario usuario : listUsuarios) {
            listaUsuariosDTO.add(mapEntityForDTO(usuario));
        }
        return listaUsuariosDTO;
    }

    public static Usuario mapDTOForInsert(UsuarioPostDTO usuarioPostDTO) {
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

    public static Usuario mapDTOForUpdate(Usuario usuarioOld, UsuarioPutDTO usuarioPutDTO) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        usuarioOld.setNome(usuarioPutDTO.getNome() != null ? usuarioPutDTO.getNome() : usuarioOld.getNome());
        usuarioOld.setDtNascimento(usuarioPutDTO.getDtNascimento() != null ? usuarioPutDTO.getDtNascimento() : usuarioOld.getDtNascimento());
        usuarioOld.setTipoLogradouro(usuarioPutDTO.getTipoLogradouro() != null ? usuarioPutDTO.getTipoLogradouro() : usuarioOld.getTipoLogradouro());
        usuarioOld.setLogradouro(usuarioPutDTO.getLogradouro() != null ? usuarioPutDTO.getLogradouro() : usuarioOld.getLogradouro());
        usuarioOld.setNumero(usuarioPutDTO.getNumero() != null ? usuarioPutDTO.getNumero() : usuarioOld.getNumero());
        usuarioOld.setComplemento(usuarioPutDTO.getComplemento() != null ? usuarioPutDTO.getComplemento() : usuarioOld.getComplemento());
        usuarioOld.setBairro(usuarioPutDTO.getBairro() != null ? usuarioPutDTO.getBairro() : usuarioOld.getBairro());
        usuarioOld.setCidade(usuarioPutDTO.getCidade() != null ? usuarioPutDTO.getCidade() : usuarioOld.getCidade());
        usuarioOld.setCep(usuarioPutDTO.getCep() != null ? usuarioPutDTO.getCep() : usuarioOld.getCep());
        usuarioOld.setUf(usuarioPutDTO.getUf() != null ? usuarioPutDTO.getUf() : usuarioOld.getUf());
        usuarioOld.setTelefone(usuarioPutDTO.getTelefone() != null ? usuarioPutDTO.getTelefone() : usuarioOld.getTelefone());
        usuarioOld.setEmail(usuarioPutDTO.getEmail() != null ? usuarioPutDTO.getEmail() : usuarioOld.getEmail());
        usuarioOld.setCpf(usuarioPutDTO.getCpf() != null ? usuarioPutDTO.getCpf() : usuarioOld.getCpf());

        if (usuarioPutDTO.getSituacaoUsuario() != null) {
            usuarioOld.setSituacaoUsuario(SituacaoUsuario.toEnum(usuarioPutDTO.getSituacaoUsuario()).getCodigo());
        }

        if (usuarioPutDTO.getNivelUsuario() != null) {
            usuarioOld.setNivelUsuario(NivelUsuario.toEnum(usuarioPutDTO.getNivelUsuario()).getCodigo());
        }

        if (usuarioPutDTO.getSenha() != null) {
            usuarioOld.setSenha(passwordEncoder.encode(usuarioPutDTO.getSenha()));
        }

        return usuarioOld;
    }
}
