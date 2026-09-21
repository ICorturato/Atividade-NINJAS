package br.com.fatec.ninjas.repository;

import br.com.fatec.ninjas.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NinjaRepository extends JpaRepository<Ninja, Long> {

    // Query Method
    Ninja findByNome (String nome);

    List<Ninja> findByNomeContaining (String Nome);

}
