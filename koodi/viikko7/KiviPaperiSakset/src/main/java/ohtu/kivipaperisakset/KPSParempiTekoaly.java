package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {

    private static final Scanner scanner = new Scanner(System.in);
    TekoalyParannettu tekoaly = new TekoalyParannettu(10);

    @Override
    protected String toisenSiirto(String edellinen) {
        tekoaly.asetaSiirto(edellinen);
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tekoäly valitsi: " + siirto);
        return siirto;
    }
}
