package fabiolima.dio.academia.digital.controller;

import fabiolima.dio.academia.digital.entity.Matricula;
import fabiolima.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl matriculaService;

    @GetMapping("/{bairro}")
    public ResponseEntity<List<Matricula>> buscarPorBairro(@PathVariable String bairro) {
        return ResponseEntity.ok(matriculaService.buscarAlunoPorBairro(bairro));
    }


}
