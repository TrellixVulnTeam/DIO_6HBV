package poo.padraodeprojeto.subsistema2;

import poo.padraodeprojeto.sigleton.SingletonEager;

public class CepApi {

    private static CepApi instancia = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getInstance(){
        return instancia;
    }

    public String recuperarCidade(String cep){
        return "Sobral";
    }

    public String recuperarEstado(String cep){
        return "Ceara";
    }

}
