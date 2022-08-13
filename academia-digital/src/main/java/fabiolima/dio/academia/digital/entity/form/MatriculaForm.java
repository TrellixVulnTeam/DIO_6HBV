package fabiolima.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {

  @NotNull(message = "Informe a matricula do aluno")
  @Positive
  private Long alunoId;

}
