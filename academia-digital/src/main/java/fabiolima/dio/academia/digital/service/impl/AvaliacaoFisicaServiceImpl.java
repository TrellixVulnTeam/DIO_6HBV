package fabiolima.dio.academia.digital.service.impl;

import fabiolima.dio.academia.digital.entity.Aluno;
import fabiolima.dio.academia.digital.entity.AvaliacaoFisica;
import fabiolima.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import fabiolima.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import fabiolima.dio.academia.digital.repository.AlunoRepository;
import fabiolima.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import fabiolima.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm avaliacaoFisicaForm) {
        Optional<Aluno> alunoSelecionado = alunoRepository.findById(avaliacaoFisicaForm.getAlunoId());
        if (!alunoSelecionado.isPresent()) {
            throw new RuntimeException("Aluno não foi informado");
        }
        AvaliacaoFisica avaliacaoFisica = AvaliacaoFisica.builder()
                .altura(avaliacaoFisicaForm.getAltura())
                .peso(avaliacaoFisicaForm.getPeso())
                .aluno(alunoSelecionado.get())
                .build();
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        Optional<AvaliacaoFisica> avaliacaoFisica = avaliacaoFisicaRepository.findById(id);
        return avaliacaoFisica.get();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(AvaliacaoFisicaUpdateForm formUpdate) {
        Optional<Aluno> aluno = alunoRepository.findById(formUpdate.getAluno_id());

        if (!aluno.isPresent()) {
            throw new RuntimeException("Aluno não encontrado");
        }

        Optional<AvaliacaoFisica> avaliacaoFisica = avaliacaoFisicaRepository.findById(formUpdate.getId());

        if (!avaliacaoFisica.isPresent()) {
            throw new RuntimeException("Avaliação não encontrada");
        }

        avaliacaoFisica.get().setAltura(formUpdate.getAltura());
        avaliacaoFisica.get().setPeso(formUpdate.getPeso());

        return avaliacaoFisicaRepository.save(avaliacaoFisica.get());
    }

    @Override
    public void delete(Long id) {
       avaliacaoFisicaRepository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAllByAluno(Long id) {
        return avaliacaoFisicaRepository.findByAluno_id(id);
    }


}
