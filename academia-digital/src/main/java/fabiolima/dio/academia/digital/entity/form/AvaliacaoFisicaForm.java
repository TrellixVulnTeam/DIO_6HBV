package fabiolima.dio.academia.digital.entity.form;

import lombok.Builder;
import lombok.Data;

@Data
public class AvaliacaoFisicaForm {

  private Long alunoId;

  private double peso;

  private double altura;
}
