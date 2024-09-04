package com.example.sachy;

public enum TypFigurky {
    VEZ("věž"),
    STRELEC("střelec"),
    KUN("kůň"),
    KRAL("král"),
    KRALOVNA("královna"),
    PESAK("pěšák");
    String nazev;
    TypFigurky(String nazev) {
        this.nazev = nazev;
    }
    public String getNazev() {
        return nazev;
    }
}
