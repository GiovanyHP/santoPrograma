package br.com.santoprograma.application.config.services;

import br.com.santoprograma.application.entity.Oracao;
import br.com.santoprograma.application.entity.Usuario;
import br.com.santoprograma.application.repository.OracaoRepository;
import br.com.santoprograma.application.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;

@Service
public class DbService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OracaoRepository oracaoRepository;

    public void instanciaDB() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Usuario usuario = new Usuario();
        usuario.setNome("Giovany Henrique Paffrath");
        usuario.setSenha("123");
        usuario.setDtNascimento(Calendar.getInstance().getTime());
        usuario.setDtCadastro(Calendar.getInstance().getTime());
        usuario.setTipoLogradouro("Rua");
        usuario.setLogradouro("Toaldo Tulio");
        usuario.setNumero("150");
        usuario.setComplemento("Bloco T apto 11");
        usuario.setBairro("Santa Felicidade");
        usuario.setCidade("Curitiba");
        usuario.setCep("82520120");
        usuario.setUf("PR");
        usuario.setTelefone("99888-7744");
        usuario.setEmail("teste@teste.com.br");
        usuario.setCpf("09401990921");
        usuario.setSituacaoUsuario(1);
        usuario.setNivelUsuario(0);
        String encoder = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Gilmar da Silva Pontes");
        usuario2.setSenha("999");
        usuario2.setDtNascimento(Calendar.getInstance().getTime());
        usuario2.setDtCadastro(Calendar.getInstance().getTime());
        usuario2.setTipoLogradouro("Rua");
        usuario2.setLogradouro("Getulio Vargas");
        usuario2.setNumero("500");
        usuario2.setComplemento("Fundos");
        usuario2.setBairro("Agua Verde");
        usuario2.setCidade("Curitiba");
        usuario2.setCep("85200150");
        usuario2.setUf("PR");
        usuario2.setTelefone("99542-1122");
        usuario2.setEmail("teste22222@teste2222.com.br");
        usuario2.setCpf("45757670002");
        usuario2.setSituacaoUsuario(1);
        usuario2.setNivelUsuario(2);
        String encoder2 = passwordEncoder.encode(usuario2.getSenha());
        usuario2.setSenha(encoder2);

        Oracao oracao = new Oracao(null, usuario, "pedido de oração Teste", LocalDateTime.now(), 1);

        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario2);
        oracaoRepository.save(oracao);
    }
}
