package com.example.sachy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class FXMLDocumentControllerTest {

    private Comparator<Figurka[][]> comparator = new Comparator<Figurka[][]>() {
        @Override
        public int compare(Figurka[][] o1, Figurka[][] o2) {
            for (int i = 0; i <o1.length ; i++) {
                for (int j = 0; j < o1[0].length; j++) {
                    if(o1[i][j] != null && o2[i][j] != null){
                        if (o1[i][j].getTyp() == o2[i][j].getTyp() &&
                                o1[i][j].isBily() == o2[i][j].isBily()) {

                        } else {
                            return 1;
                        }
                    } else if (o1[i][j] != o2[i][j]) {
                        return 1;
                    }
                }
            }
            return 0;
        }
    };

    public FXMLDocumentControllerTest() {

    }

    private Figurka[][] naplnSachovnici(){
        Figurka[][] sachovnice = new Figurka[8][8];

        sachovnice[0][0] = new Figurka(null, TypFigurky.VEZ, false);
        sachovnice[0][1] = new Figurka(null, TypFigurky.STRELEC, false);
        sachovnice[0][2] = new Figurka(null, TypFigurky.KUN, false);
        sachovnice[0][3] = new Figurka(null, TypFigurky.KRALOVNA, false);
        sachovnice[0][4] = new Figurka(null, TypFigurky.KRAL, false);
        sachovnice[0][5] = new Figurka(null, TypFigurky.KUN, false);
        sachovnice[0][6] = new Figurka(null, TypFigurky.STRELEC, false);
        sachovnice[0][7] = new Figurka(null, TypFigurky.VEZ, false);

        sachovnice[1][0] = new Figurka(null, TypFigurky.PESAK, false);
        sachovnice[1][1] = new Figurka(null, TypFigurky.PESAK, false);
        sachovnice[1][2] = new Figurka(null, TypFigurky.PESAK, false);
        sachovnice[1][3] = new Figurka(null, TypFigurky.PESAK, false);
        sachovnice[1][4] = new Figurka(null, TypFigurky.PESAK, false);
        sachovnice[1][5] = new Figurka(null, TypFigurky.PESAK, false);
        sachovnice[1][6] = new Figurka(null, TypFigurky.PESAK, false);
        sachovnice[1][7] = new Figurka(null, TypFigurky.PESAK, false);

        sachovnice[6][0] = new Figurka(null, TypFigurky.PESAK, true);
        sachovnice[6][1] = new Figurka(null, TypFigurky.PESAK, true);
        sachovnice[6][2] = new Figurka(null, TypFigurky.PESAK, true);
        sachovnice[6][3] = new Figurka(null, TypFigurky.PESAK, true);
        sachovnice[6][4] = new Figurka(null, TypFigurky.PESAK, true);
        sachovnice[6][5] = new Figurka(null, TypFigurky.PESAK, true);
        sachovnice[6][6] = new Figurka(null, TypFigurky.PESAK, true);
        sachovnice[6][7] = new Figurka(null, TypFigurky.PESAK, true);

        sachovnice[7][0] = new Figurka(null, TypFigurky.VEZ, true);
        sachovnice[7][1] = new Figurka(null, TypFigurky.STRELEC, true);
        sachovnice[7][2] = new Figurka(null, TypFigurky.KUN, true);
        sachovnice[7][3] = new Figurka(null, TypFigurky.KRALOVNA, true);
        sachovnice[7][4] = new Figurka(null, TypFigurky.KRAL, true);
        sachovnice[7][5] = new Figurka(null, TypFigurky.KUN, true);
        sachovnice[7][6] = new Figurka(null, TypFigurky.STRELEC, true);
        sachovnice[7][7] = new Figurka(null, TypFigurky.VEZ, true);

        return sachovnice;
    }


    @Test
    public void inicializace001() {
        Sachovnice sachy = new Sachovnice();
        sachy.nastavFigurky();
        Figurka[][] actual = sachy.getSachovnice();
        Figurka[][] expected = naplnSachovnici();
        int vysledek = comparator.compare(expected,actual);
        assertEquals(0, vysledek);
    }
}