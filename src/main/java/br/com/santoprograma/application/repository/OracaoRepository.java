package br.com.santoprograma.application.repository;

import br.com.santoprograma.application.entity.Oracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracaoRepository extends JpaRepository<Oracao, Long> {

    Oracao getById(Long id);
}
