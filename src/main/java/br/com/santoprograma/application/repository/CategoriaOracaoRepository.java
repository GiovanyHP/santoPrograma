package br.com.santoprograma.application.repository;

import br.com.santoprograma.application.entity.CategoriaOracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaOracaoRepository extends JpaRepository<CategoriaOracao, Long> {

    CategoriaOracao getById(Long id);
}
