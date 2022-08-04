package poo.padraodeprojeto.test;

import poo.padraodeprojeto.sigleton.SingletonEager;
import poo.padraodeprojeto.sigleton.SingletonHolder;
import poo.padraodeprojeto.sigleton.SingletonLazy;

public class TestSingleton {

    public static void main(String[] args) {
        //Teste padrão sigleton
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        System.out.println(singletonLazy1);

        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        System.out.println(singletonLazy2);

        SingletonEager singletonEager = SingletonEager.getInstance();
        System.out.println(singletonEager);

        singletonEager = SingletonEager.getInstance();
        System.out.println(singletonEager);

        SingletonHolder singletonHolder = SingletonHolder.getInstance();
        System.out.println(singletonHolder);

        singletonHolder = SingletonHolder.getInstance();
        System.out.println(singletonHolder);





    }





}
