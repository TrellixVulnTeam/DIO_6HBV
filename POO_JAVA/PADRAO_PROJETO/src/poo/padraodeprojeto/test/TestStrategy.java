package poo.padraodeprojeto.test;

import poo.padraodeprojeto.strategy.*;

public class TestStrategy {

    public static void main(String[] args) {

        Comportamento comportamentoNormal = new ComportamentoNormal();

        Comportamento comportamentoDefencivo = new ComportamentoDefensivo();

        Comportamento comportamentoAgressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(comportamentoNormal);
        robo.mover();
        robo.mover();
        robo.setComportamento(comportamentoDefencivo);
        robo.mover();
        robo.setComportamento(comportamentoAgressivo);
        robo.mover();

    }

}
