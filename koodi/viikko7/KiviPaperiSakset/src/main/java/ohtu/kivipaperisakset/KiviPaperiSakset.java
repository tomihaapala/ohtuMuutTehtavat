/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author Tomi
 */
public abstract class KiviPaperiSakset{

    static final Scanner scanner = new Scanner(System.in);
    //public String ekanSiirto;

    static KiviPaperiSakset luoUusiPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }

    static KiviPaperiSakset luoUusiPelaajaVsTekoaly() {
        return new KPSTekoaly();
    }

    static KiviPaperiSakset luoUusiPelaajaVsVahvaTekoaly() {
        return new KPSParempiTekoaly();
    }

    // tämä on ns template metodi
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.println("Anna eka:");
        String ekanSiirto = ensimmaisenSiirto();

        System.out.println("Toisen pelaajan siirto: ");
        String tokanSiirto = toisenSiirto(ekanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = ensimmaisenSiirto();

            System.out.println("Toisen pelaajan siirto: ");
            tokanSiirto = toisenSiirto(ekanSiirto);

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected String ensimmaisenSiirto() {
        return scanner.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto(String ekanSiirto);

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
