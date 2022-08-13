package fabiolima.dio.academia.digital.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "avaliacao")
public class AvaliacaoFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  private double peso;

  private double altura;

}
