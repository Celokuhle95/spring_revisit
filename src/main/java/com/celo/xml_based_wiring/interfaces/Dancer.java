package com.celo.xml_based_wiring.interfaces;

public class Dancer implements Perfomer {

    private int numGenres = 3;

    public Dancer() {
    }

    public Dancer(int beanBags) {
        this.numGenres = beanBags;
    }

    public void perform()  {
        System.out.println("Dancing " + numGenres + " diff moves");
    }
}