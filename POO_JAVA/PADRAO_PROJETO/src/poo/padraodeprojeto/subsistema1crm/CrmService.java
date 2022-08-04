package poo.padraodeprojeto.subsistema1crm;

public class CrmService {

    private CrmService() {
        super();
    }

    public static void gravaCliente(String nome, String cep, String cidade, String estado){
        System.out.println("Cliente salvo no sistema CRM");
        System.out.println(nome);
        System.out.println(cidade);
        System.out.println(estado);
        System.out.println(cep);
    }

}
