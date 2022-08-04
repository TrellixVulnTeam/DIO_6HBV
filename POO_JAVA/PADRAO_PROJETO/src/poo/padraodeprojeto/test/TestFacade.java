package poo.padraodeprojeto.test;

import poo.padraodeprojeto.facade.Facade;

public class TestFacade {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.migrarCliente("Lima", "60000000");
    }


}
