package br.com.santoprograma.application.repository;

import br.com.santoprograma.application.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Integer countByCpf(String cpf);

    Usuario findByCpf(String cpf);

    Usuario findByEmail(String email);

    Usuario getByIdUsuario(Long id);

}
