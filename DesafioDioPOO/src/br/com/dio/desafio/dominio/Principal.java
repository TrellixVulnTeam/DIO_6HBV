package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.setTitulo("POO java");
        curso.setDescricao("Aprendendo POO com java");
        curso.setCargaHoraria(10);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Java");
        mentoria.setDescricao("Mentoria  java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp java");
        bootcamp.setDescricao("Bootcamp java develop");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(mentoria);

        Dev dev1 = new Dev();
        dev1.setNome("Paulo");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscrito dev1: " + dev1.getConteodosInscritos());
        dev1.progredir();
        System.out.println("Conteúdos inscrito dev1: " + dev1.getConteodosInscritos());
        System.out.println("Conteúdos concluídos dev1: " + dev1.getConteodosConcluidos());
        System.out.println("XP " + dev1.calcularTotalXp());

        Dev dev2 = new Dev();
        dev2.setNome("Teodoro");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscrito dev2: " + dev2.getConteodosInscritos());
        dev2.progredir();
        System.out.println("Conteúdos inscrito dev2: " + dev2.getConteodosInscritos());
        System.out.println("Conteúdos concluídos dev2: " + dev2.getConteodosConcluidos());
        System.out.println("XP " + dev1.calcularTotalXp());








    }
}
