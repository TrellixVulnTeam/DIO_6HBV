package poo.padraodeprojeto.facade;

import poo.padraodeprojeto.subsistema1crm.CrmService;
import poo.padraodeprojeto.subsistema2.CepApi;

public class Facade {
    public void migrarCliente(String nome, String cep){

        String cidade = CepApi.getInstance().recuperarCidade(cep);
        String estado = CepApi.getInstance().recuperarEstado(cep);

        CrmService.gravaCliente(nome, cep, cidade, estado);
    }
}
