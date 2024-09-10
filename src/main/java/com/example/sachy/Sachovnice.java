package com.example.sachy;

public class Sachovnice {

    //TODO dodělat šach a šachmat
    public Sachovnice() {
    }

    private Figurka[][] sachovnice;
    private Marka marka = null;
    private boolean novaMarka = false;
    private boolean bilyNaTahu = true;

    /*
     *   inicializace figurek a nastavení jejich startovního místa na šachovnici
     */
    public void nastavFigurky() {
        sachovnice = new Figurka[8][8];

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

    }

    /*
     * vypíše figurky z pole do commandLine
     */
    public void vypisPole() {
        int nejdelsiNazev = 8;
        vypisOhraniceni();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (sachovnice[i][j] != null) {

                    if (sachovnice[i][j].isBily()) {
                        System.out.print("b-" + sachovnice[i][j].getTyp().getNazev());
                        zarovnej(nejdelsiNazev - sachovnice[i][j].getTyp().getNazev().length());

                    } else {
                        System.out.print("c-" + sachovnice[i][j].getTyp().getNazev());
                        zarovnej(nejdelsiNazev - sachovnice[i][j].getTyp().getNazev().length());
                    }

                } else {
                    System.out.print("-");
                    zarovnej(nejdelsiNazev + 1);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        vypisOhraniceni();
    }

    /*vypíše čárkované ohraničení o délce 8 (počet figurek) x 11 (délka nejdelší figurky [8]
     * barva s pomlčkou [2] + mezera [1])
     */
    private void vypisOhraniceni() {
        for (int i = 0; i < 88; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    /*
     *  vypíše mezery podle zadaného počtu
     */
    private void zarovnej(int pocetMezer) {
        for (int k = 0; k < pocetMezer; k++) {
            System.out.print(" ");
        }
    }

    /*
     *   kontrola platnosti tahu podle typu figurky z Y X souřadnic do Y X souřadnic
     *   v případě kolize/neplatného tahu vypíše chybovou hlášku
     */
    public void posunFigurku(int odRadek, int odSloupec, int doRadek, int doSloupec) {
        if (jeMimoPole(odRadek) || jeMimoPole(odSloupec) || jeMimoPole(doRadek) || jeMimoPole(doSloupec)) {
            System.err.println("Hodnoty jsou mimo pole");
            return;
        }
        if (odRadek == doRadek && odSloupec == doSloupec) {
            System.err.println("Startovací s konečná pozice je stejná!");
            return;
        }
        if (sachovnice[odRadek][odSloupec] == null) {
            System.err.println("Ve vybraném poli není žádná figurka");
            return;
        }
        if (sachovnice[doRadek][doSloupec] != null) {
            if (sachovnice[odRadek][odSloupec].isBily() == sachovnice[doRadek][doSloupec].isBily()) {
                System.err.println("Figurka stejné barvy na poli!");
                return;
            }
        }
        //TODO zakomentovat při testování a po testování odkomentovat
//        if (sachovnice[odRadek][odSloupec].isBily() != bilyNaTahu) {
//            if (bilyNaTahu) {
//                System.err.println("Na tahu je bílý");
//            } else {
//                System.err.println("Na tahu je černý");
//            }
//            return;
//        }


        Figurka figurka = sachovnice[odRadek][odSloupec];
        switch (figurka.getTyp()) {
            case KRAL:
                System.out.println("král");
                if (doRadek <= odRadek + 1 && doRadek >= odRadek - 1
                        && doSloupec <= odSloupec + 1 && doSloupec >= odSloupec - 1
                        && (odRadek != doRadek || odSloupec != doSloupec)) {
                    pohyb(odRadek, odSloupec, doRadek, doSloupec);
                }
                break;
            case VEZ:
                //musí se lišit jen jedna hodnota - buď řádek, nebo sloupec
                //forloopem zkontrolovat cestu od do pole, jestli není prvek v cestě
                //dát pozor, aby to ignorovalo marku/změnit marku, aby to viděli jen pěšáci - kontrola jen při skoku do strany
                int mensi, vetsi;
                if (odRadek == doRadek && odSloupec != doSloupec) {

                    if (odSloupec < doSloupec) {
                        mensi = odSloupec;
                        vetsi = doSloupec;
                    } else {
                        mensi = doSloupec;
                        vetsi = odSloupec;
                    }

                    for (int i = mensi + 1; i < vetsi; i++) {
                        if (sachovnice[odRadek][i] != null) {
                            System.err.println("prvek v cestě");
                            return;
                        }
                    }
                    pohyb(odRadek, odSloupec, doRadek, doSloupec);
                } else if (odRadek != doRadek && odSloupec == doSloupec) {
                    if (odRadek < doRadek) {
                        mensi = odRadek;
                        vetsi = doRadek;
                    } else {
                        mensi = doRadek;
                        vetsi = odRadek;
                    }
                    for (int i = mensi + 1; i < vetsi; i++) {
                        if (sachovnice[i][odSloupec] != null) {
                            System.err.println("prvek v cestě");
                            return;
                        }
                    }
                    pohyb(odRadek, odSloupec, doRadek, doSloupec);
                } else {
                    System.err.println("neplatný tah věží");
                    return;
                }


                break;
            case KUN:
                //2 do strany 1 na výšku, nebo obráceně ==> x = 2y || y = 2x
                //x + x by mělo být rychlejší, než 2 * x
                //odečíst jako u střelce, použít absolutní hodnotu, zjistit rozdíl a zkontrolovat zda sedí do rovnice výše
                if (Math.abs(odRadek - doRadek) == 2 * Math.abs(odSloupec - doSloupec) ||
                        2 * Math.abs(odRadek - doRadek) == Math.abs(odSloupec - doSloupec)) {
                    pohyb(odRadek, odSloupec, doRadek, doSloupec);
                } else {
                    System.err.println("Neplatný skok koněm");
                }

                break;
            case PESAK:
                System.out.println("pěšák");
                int skok1, skok2 = 0;
                int startovaciRadek = 0;

                if (figurka.isBily()) {
                    skok1 = -1;
                    skok2 = -2;
                    startovaciRadek = 6;
                } else {
                    skok1 = 1;
                    skok2 = 2;
                    startovaciRadek = 1;
                }

                //kontrola skoku o 1 do strany a 1 dopředu/dozadu ==> <+-1,+-1>
                if ((odSloupec + 1 == doSloupec || odSloupec - 1 == doSloupec) && odRadek + skok1 == doRadek) {

                    //kontrola jestli je buňka prázdná
                    if (sachovnice[doRadek][doSloupec] != null) {

                        pohyb(odRadek, odSloupec, doRadek, doSloupec);
                        return;

                        //kontrola, zda je na místě marka pro enPeasant
                    } else if (marka != null) {
                        if (doRadek == marka.getRadek() && doSloupec == marka.getSloupec()) {
//                            odstranMarku();
                            pohyb(odRadek, odSloupec, doRadek, doSloupec);
                            return;
                        }
                        System.err.println("nenalezena figurka pro skok");
                        return;
                    } else {
                        System.err.println("nenalezena figurka pro skok");
                        return;
                    }

                }

                if (sachovnice[odRadek + skok1][odSloupec] != null) {
                    System.out.println("Figurka před pěšákem. Nelze pohnout dopředu");
                    return;
                }

                if (odSloupec == doSloupec && odRadek + skok1 == doRadek) {
                    pohyb(odRadek, odSloupec, doRadek, doSloupec);
                    return;
                }

                if (odSloupec == doSloupec && odRadek + skok2 == doRadek
                        && odRadek == startovaciRadek) {
                    if (sachovnice[odRadek + skok2][odSloupec] != null) {
                        System.out.println("Figurka o 2 pole před pěšákem. Nelze pohnout dopředu");
                        return;
                    }

                    marka = new Marka(odRadek + skok1, odSloupec);
                    novaMarka = true;

                    pohyb(odRadek, odSloupec, doRadek, doSloupec);
                    return;
                }

                break;
            case STRELEC:
                int rozdilRadku = odRadek - doRadek;
                int rozdilSloupcu = odSloupec - doSloupec;
                //kontrola zda jsou políčka diagonálně
                if (Math.abs(rozdilRadku) == Math.abs(rozdilSloupcu)) {
                    //kontrola zda je objekt v cestě
                    int posunRadku, posunSloupcu;
                    if (odRadek > doRadek) {
                        posunRadku = -1;
                    } else {
                        posunRadku = 1;
                    }
                    if (odSloupec > doSloupec) {
                        posunSloupcu = -1;
                    } else {
                        posunSloupcu = 1;
                    }

                    //kontrola, zda po cestě od figurky do cílového pole je jiná figurka
                    for (int r = odRadek + posunRadku, s = odSloupec + posunSloupcu; r < doRadek || r > doRadek; r += posunRadku, s += posunSloupcu) {
                        if (sachovnice[r][s] != null) {
                            System.err.println(sachovnice[r][s].getTyp().getNazev() + " v cestě");
                            return;
                        }
                    }
                    pohyb(odRadek, odSloupec, doRadek, doSloupec);

                } else {
                    System.err.println("Neplatný tah střelcem");
                    break;
                }
                break;
            case KRALOVNA:
                //kombinace věže a střelce -
                // TODO zatím překopírované. Později upravit, aby nebylo tolik duplikátů
                //  - udělat metody pro pohyb, nebo něco

                rozdilRadku = odRadek - doRadek;
                rozdilSloupcu = odSloupec - doSloupec;
                //kontrola zda jsou políčka diagonálně
                if (Math.abs(rozdilRadku) == Math.abs(rozdilSloupcu)) {
                    //kontrola zda je objekt v cestě
                    int posunRadku, posunSloupcu;
                    if (odRadek > doRadek) {
                        posunRadku = -1;
                    } else {
                        posunRadku = 1;
                    }
                    if (odSloupec > doSloupec) {
                        posunSloupcu = -1;
                    } else {
                        posunSloupcu = 1;
                    }

                    //kontrola, zda po cestě od figurky do cílového pole je jiná figurka
                    for (int r = odRadek + posunRadku, s = odSloupec + posunSloupcu; r < doRadek || r > doRadek; r += posunRadku, s += posunSloupcu) {
                        if (sachovnice[r][s] != null) {
                            System.err.println(sachovnice[r][s].getTyp().getNazev() + " v cestě");
                            return;
                        }
                    }
                    pohyb(odRadek, odSloupec, doRadek, doSloupec);

                } else if (odRadek == doRadek && odSloupec != doSloupec) {


                    if (odSloupec < doSloupec) {
                        mensi = odSloupec;
                        vetsi = doSloupec;
                    } else {
                        mensi = doSloupec;
                        vetsi = odSloupec;
                    }

                    for (int i = mensi + 1; i < vetsi; i++) {
                        if (sachovnice[odRadek][i] != null) {
                            System.err.println("prvek v cestě");
                            return;
                        }
                    }
                    pohyb(odRadek, odSloupec, doRadek, doSloupec);
                } else if (odRadek != doRadek && odSloupec == doSloupec) {
                    if (odRadek < doRadek) {
                        mensi = odRadek;
                        vetsi = doRadek;
                    } else {
                        mensi = doRadek;
                        vetsi = odRadek;
                    }
                    for (int i = mensi + 1; i < vetsi; i++) {
                        if (sachovnice[i][odSloupec] != null) {
                            System.err.println("prvek v cestě");
                            return;
                        }
                    }
                    pohyb(odRadek, odSloupec, doRadek, doSloupec);
                } else {
                    System.err.println("Neplatný tah");
                    break;
                }
                break;
        }
    }


    /*
     * posun figurky z dané souřadnice na jinou (volané po kontrole tahu)
     */
    private void pohyb(int odRadek, int odSloupec, int doRadek, int doSloupec) {
        sachovnice[doRadek][doSloupec] = sachovnice[odRadek][odSloupec];
        sachovnice[odRadek][odSloupec] = null;

        if (novaMarka) {
            novaMarka = false;
        } else {
            marka = null;
        }

        bilyNaTahu = !bilyNaTahu;
    }

    /*
     *  vrací true, když je číslo mimo pole o velikosti 8
     */
    private boolean jeMimoPole(int cislo) {
        return cislo < 0 || cislo > 7;
    }

    //vrací šachovnici - pro testy
    public Figurka[][] getSachovnice() {
        return sachovnice;
    }

}
