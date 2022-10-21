package br.com.santoprograma.application.service;

import br.com.santoprograma.application.converter.UsuarioConverter;
import br.com.santoprograma.application.dtos.UsuarioDTO;
import br.com.santoprograma.application.dtos.UsuarioLoginDTO;
import br.com.santoprograma.application.dtos.UsuarioPostDTO;
import br.com.santoprograma.application.dtos.UsuarioPutDTO;
import br.com.santoprograma.application.entity.Usuario;
import br.com.santoprograma.application.repository.UsuarioRepository;
import br.com.santoprograma.application.service.exceptions.DataIntegratyViolationException;
import br.com.santoprograma.application.service.exceptions.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Long id) {

        Usuario usuario = usuarioRepository.getByIdUsuario(id);

        if (usuario == null) {
            throw new InternalServerErrorException("Usuário Não encontrado na base de dados");
        }

        return usuario;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public UsuarioDTO create(UsuarioPostDTO usuarioPostDTO) {
        if (validarCpSeExisteNaBaseDeDados(usuarioPostDTO.getCpf()) != null) {
            throw new DataIntegratyViolationException("CPF Já Cadastrado na base de dados");
        }

        if (validarEmailSeJaExisteCadastrado(usuarioPostDTO.getEmail()) != null) {
            throw new DataIntegratyViolationException("Email Já Cadastrado na base de dados");
        }

        Usuario usuario = UsuarioConverter.mapDTOForInsert(usuarioPostDTO);
        usuarioRepository.save(usuario);
        return UsuarioConverter.mapEntityForDTO(usuario);
    }

    public UsuarioDTO update(Long id, UsuarioPutDTO usuarioPutDTO) {
        Usuario usuarioOld = findById(id);

        if (usuarioPutDTO.getCpf() != null
                && validarCpSeExisteNaBaseDeDados(usuarioPutDTO.getCpf()) != null
                && validarCpSeExisteNaBaseDeDados(usuarioPutDTO.getCpf()).getIdUsuario() != id) {
            throw new DataIntegratyViolationException("CPF Já Cadastrado na base de dados");
        }

        if (usuarioPutDTO.getEmail() != null
                && validarEmailSeJaExisteCadastrado(usuarioPutDTO.getEmail()) != null
                && validarEmailSeJaExisteCadastrado(usuarioPutDTO.getEmail()).getIdUsuario() != id) {
            throw new DataIntegratyViolationException("Email Já Cadastrado na base de dados");
        }

        UsuarioConverter.mapDTOForUpdate(usuarioOld, usuarioPutDTO);
        usuarioRepository.save(usuarioOld);
        return UsuarioConverter.mapEntityForDTO(usuarioOld);
    }

    public void delete(Long id) {
        findById(id);
        usuarioRepository.deleteById(id);

    }

    public Usuario usuarioLogin(UsuarioLoginDTO usuarioLoginDTO) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Usuario usuario;
        usuario = usuarioRepository.findByEmail(usuarioLoginDTO.getEmail());

        if (usuario != null) {
            boolean valid = passwordEncoder.matches(usuarioLoginDTO.getSenha(), usuario.getSenha());
            if (valid) {
                return usuario;
            }
        }
        return null;
    }

    private Usuario validarCpSeExisteNaBaseDeDados(String cpf) {
        Integer countCPF = usuarioRepository.countByCpf(cpf);

        if (countCPF > 0) {
            return usuarioRepository.findByCpf(cpf);
        }
        return null;
    }

    private Usuario validarEmailSeJaExisteCadastrado(String email) {

        if (usuarioRepository.findByEmail(email) != null) {
            return usuarioRepository.findByEmail(email);
        }

        return null;
    }
}
