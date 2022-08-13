package fabiolima.dio.academia.digital.controller;

import fabiolima.dio.academia.digital.entity.Aluno;
import fabiolima.dio.academia.digital.entity.form.AlunoForm;
import fabiolima.dio.academia.digital.entity.form.AlunoUpdateForm;
import fabiolima.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoService;

    @GetMapping
    public ResponseEntity listar() {
        return ResponseEntity.ok(alunoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.get(id);
        AlunoForm alunoForm = new AlunoForm();
        alunoForm.setNome(aluno.getNome());
        alunoForm.setBairro(aluno.getBairro());
        alunoForm.setDataDeNascimento(aluno.getDataDeNascimento());
        return ResponseEntity.ok(alunoForm);
    }

    @PostMapping
    public ResponseEntity salvar(@Valid @RequestBody AlunoForm alunoForm) {
        Aluno aluno = alunoService.create(alunoForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @PutMapping
    public ResponseEntity atualizar(@Valid @RequestBody AlunoUpdateForm alunoUpdateForm) {
        return ResponseEntity.ok(alunoService.update(alunoUpdateForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
