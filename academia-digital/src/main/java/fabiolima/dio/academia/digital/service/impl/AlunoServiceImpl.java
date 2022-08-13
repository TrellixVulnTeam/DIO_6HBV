package fabiolima.dio.academia.digital.service.impl;

import fabiolima.dio.academia.digital.entity.Aluno;
import fabiolima.dio.academia.digital.entity.form.AlunoForm;
import fabiolima.dio.academia.digital.entity.form.AlunoUpdateForm;
import fabiolima.dio.academia.digital.entity.form.MatriculaForm;
import fabiolima.dio.academia.digital.exception.AlunoNullExcepion;
import fabiolima.dio.academia.digital.repository.AlunoRepository;
import fabiolima.dio.academia.digital.repository.MatriculaRepository;
import fabiolima.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MatriculaServiceImpl matriculaService;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = Aluno.builder().nome(form.getNome())
                .cpf(form.getCpf())
                .bairro(form.getBairro())
                .dataDeNascimento(form.getDataDeNascimento()).build();

        Aluno alunoSalvo = alunoRepository.save(aluno);
        MatriculaForm matriculaForm = MatriculaForm.builder().alunoId(alunoSalvo.getId()).build();
        matriculaService.create(matriculaForm);
        return alunoSalvo;
    }

    @Override
    public Aluno get(Long id) {
        Aluno alunoSelecionado = alunoRepository.findById(id).orElse(null);

        if(alunoSelecionado == null){
            throw new AlunoNullExcepion();
        }

        return alunoSelecionado;
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno update(AlunoUpdateForm formUpdate) {
        Aluno alunoSelecionado = alunoRepository.findByCpf(formUpdate.getCpf());

        if (alunoSelecionado == null) {
            new RuntimeException("Não foi possível atualizar o aluno");
        }

        alunoSelecionado.setNome(formUpdate.getNome());
        alunoSelecionado.setBairro(formUpdate.getBairro());
        alunoSelecionado.setDataDeNascimento(formUpdate.getDataDeNascimento());
        return alunoRepository.save(alunoSelecionado);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }
}
