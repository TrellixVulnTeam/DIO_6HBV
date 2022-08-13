package fabiolima.dio.academia.digital.controller;

import fabiolima.dio.academia.digital.entity.AvaliacaoFisica;
import fabiolima.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import fabiolima.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import fabiolima.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl avaliacaoFisicaService;

    @GetMapping("/aluno/{id}")
    public List<AvaliacaoFisica> buscarAvaliacoesPorAluno(@PathVariable Long id){

        return avaliacaoFisicaService.getAllByAluno(id);
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody AvaliacaoFisicaForm avaliacaoFisicaForm){
        AvaliacaoFisica avaliacaoFisicaSalvo = avaliacaoFisicaService.create(avaliacaoFisicaForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoFisicaSalvo);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody AvaliacaoFisicaUpdateForm avaliacaoFisicaUpdateForm){
        AvaliacaoFisica avaliacaoFisicaAtualizado = avaliacaoFisicaService.update(avaliacaoFisicaUpdateForm);
        return ResponseEntity.ok(avaliacaoFisicaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        avaliacaoFisicaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
