package fabiolima.dio.academia.digital.repository;

import fabiolima.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Query(value = "SELECT * FROM matricula m INNER JOIN aluno a " +
           " ON m.aluno_id = a.id WHERE a.bairro = :bairro",  nativeQuery = true)
    List<Matricula> findByAlunoBairro(String bairro);

}
