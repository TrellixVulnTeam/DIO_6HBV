package fabiolima.dio.academia.digital.service;

import fabiolima.dio.academia.digital.entity.AvaliacaoFisica;
import fabiolima.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import fabiolima.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;

import java.util.List;

public interface IAvaliacaoFisicaService {
  /**
   * Cria uma Avaliação Física e salva no banco de dados.
   * @param form - formulário referente aos dados para criação da Avaliação Física no banco de dados.
   * @return - Avaliação Física recém-criada.
   */
  AvaliacaoFisica create(AvaliacaoFisicaForm form);

  /**
   * Retorna uma Avaliação Física que está no banco de dados de acordo com seu Id.
   * @param id - id da Avaliação Física que será exibida.
   * @return - Avaliação Física de acordo com o Id fornecido.
   */
  AvaliacaoFisica get(Long id);

  /**
   * Retorna todas as Avaliações Física que estão no banco de dados.
   * @return - Uma lista com todas as Avaliações Física que estão salvas no DB.
   */
  List<AvaliacaoFisica> getAll();

  /**
   * Atualiza a avaliação física.
   * @param id - id da Avaliação Física que será atualizada.
   * @param formUpdate - formulário referente aos dados necessários para atualização da Avaliação
   * Física no banco de dados.
   * @return - Avaliação Física recém-atualizada.
   */
  AvaliacaoFisica update(AvaliacaoFisicaUpdateForm formUpdate);

  /**
   * Deleta uma Avaliação Física específica.
   * @param id - id da Avaliação Física que será removida.
   */
  void delete(Long id);

  /**
   *  Listar as avaliações fisicas de um aluno
   * @param id - id do aluno
   */
  List<AvaliacaoFisica> getAllByAluno(Long id);

}
