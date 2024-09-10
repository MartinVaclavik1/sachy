package com.example.sachy;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

//TODO dodělat šach a šachmat

public class FXMLDocumentController implements Initializable {
    @FXML
    private GridPane grid;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Sachovnice sachovnice = new Sachovnice();
        sachovnice.nastavFigurky();
        sachovnice.vypisPole();
//        posunFigurku(7, 4, 6, 4);
//        vypisPole();
        Scanner vstup = new Scanner(System.in);

        /*
         * loop pro user input - zakomentovat pro testy, nebo pak předělat
         */
        while (true) {
            int odRadek = vstup.nextInt();
            int odSloupec = vstup.nextInt();
            int doRadek = vstup.nextInt();
            int doSloupec = vstup.nextInt();
            sachovnice.posunFigurku(odRadek, odSloupec, doRadek, doSloupec);
            sachovnice.vypisPole();
        }

    }
}
