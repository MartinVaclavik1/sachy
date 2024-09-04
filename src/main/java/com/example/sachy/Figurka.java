package com.example.sachy;

import javafx.scene.image.Image;

public class Figurka {
    Image obrazek;
    TypFigurky typ;
    boolean bily;

    public Figurka(Image obrazek, TypFigurky typ, boolean bily) {
        this.obrazek = obrazek;
        this.typ = typ;
        this.bily = bily;
    }

    public Figurka(){

    }

    public Image getObrazek() {
        return obrazek;
    }

    public TypFigurky getTyp() {
        return typ;
    }

    public boolean isBily() {
        return bily;
    }
}
