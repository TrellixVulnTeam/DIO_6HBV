package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteodosInscritos() {
        return conteudosInscritos;
    }

    public void setConteodosInscritos(Set<Conteudo> conteodosInscritos) {
        this.conteudosInscritos = conteodosInscritos;
    }

    public Set<Conteudo> getConteodosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteodosConcluidos(Set<Conteudo> conteodosConcluidos) {
        this.conteudosConcluidos = conteodosConcluidos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    };

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.out.println("Você não está inscrito em nenhum conteúdo");
        }
    };

    public double calcularTotalXp(){
       return  this.conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularxp()).sum();
    };


}
