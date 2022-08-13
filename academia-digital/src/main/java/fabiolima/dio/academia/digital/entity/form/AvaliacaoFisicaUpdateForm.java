package fabiolima.dio.academia.digital.entity.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AvaliacaoFisicaUpdateForm {

  private long id;

  private long aluno_id;

  private double peso;

  private double altura;
}
