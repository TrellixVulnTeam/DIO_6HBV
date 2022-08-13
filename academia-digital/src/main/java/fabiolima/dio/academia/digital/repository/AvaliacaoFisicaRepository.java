package fabiolima.dio.academia.digital.repository;

import fabiolima.dio.academia.digital.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {

    List<AvaliacaoFisica> findByAluno_id(Long id);

}
