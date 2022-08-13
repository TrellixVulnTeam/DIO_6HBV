package fabiolima.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Informe o campo nome")
  @Size(min = 1, max = 50, message = " '${validateValue}' tem que ser entre {min} e {max} " )
  private String nome;

  @Column(unique = true)
  @CPF(message = " '${validateValue}' é inválido ")
  private String cpf;

  @NotBlank(message = "Informe o campo nome")
  @Size(min = 1, max = 50, message = " '${validateValue}' tem que ser entre {min} e {max} " )
  private String bairro;

  @NotNull(message = "Preencha o campo corretamente")
  @Past(message = " '${validateValue}' é inválida ")
  @Column(name = "data_nascimento")
  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
