package fabiolima.dio.academia.digital.entity.form;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoUpdateForm {

  private String nome;

  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;
}
