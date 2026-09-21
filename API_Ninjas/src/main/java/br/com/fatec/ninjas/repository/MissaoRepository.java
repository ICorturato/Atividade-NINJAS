package br.com.fatec.ninjas.repository;

import br.com.fatec.ninjas.model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MissaoRepository extends JpaRepository<Missao, Long> {

    // Query Method
    Missao findByTitulo (String titulo);

    List<Missao> findByDescricaoContaining (String descricao);

}
