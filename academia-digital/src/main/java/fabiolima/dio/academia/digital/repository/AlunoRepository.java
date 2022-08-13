package fabiolima.dio.academia.digital.repository;

import fabiolima.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByCpf(String cpf);

}
