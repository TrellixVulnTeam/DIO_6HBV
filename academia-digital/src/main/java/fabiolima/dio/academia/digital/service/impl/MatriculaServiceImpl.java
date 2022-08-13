package fabiolima.dio.academia.digital.service.impl;

import fabiolima.dio.academia.digital.entity.Aluno;
import fabiolima.dio.academia.digital.entity.Matricula;
import fabiolima.dio.academia.digital.entity.form.MatriculaForm;
import fabiolima.dio.academia.digital.repository.AlunoRepository;
import fabiolima.dio.academia.digital.repository.MatriculaRepository;
import fabiolima.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    MatriculaRepository matriculaRepository;

    @Override
    public Matricula create(MatriculaForm matriculaForm) {
        Optional<Aluno> aluno = alunoRepository.findById(matriculaForm.getAlunoId());

        if(!aluno.isPresent()) {
            throw new RuntimeException("Informe o aluno");
        }

        Matricula matricula = Matricula.builder().aluno(aluno.get())
                .dataDaMatricula(LocalDateTime.now())
                .build();
        return matriculaRepository.save(matricula) ;
    }

    @Override
    public Matricula get(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElse(null);
        return matricula;
    }

    @Override
    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       matriculaRepository.deleteById(id);
    }

    @Override
    public List<Matricula> buscarAlunoPorBairro(String bairro) {
        return matriculaRepository.findByAlunoBairro(bairro);
    }
}
