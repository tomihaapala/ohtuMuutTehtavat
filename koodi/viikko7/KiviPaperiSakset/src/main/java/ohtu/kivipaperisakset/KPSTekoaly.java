package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {

    private static final Scanner scanner = new Scanner(System.in);
    Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String toisenSiirto(String edellinen) {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tekoäly valitsi: " + siirto);
        return siirto;
    }
}
