package com.celo.xml_based_wiring;

import com.celo.xml_based_wiring.interfaces.Dancer;

public class SingingDancer  extends Dancer {

    private Song song;

    public SingingDancer(int numMoves, Song song) {
        super(numMoves);
        this.song = song;
    }

    @Override
    public void perform() {
        song.play();
    }
}
