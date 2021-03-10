package ohtu;

import ohtu.verkkokauppa.*;
import ohtu.verkkokauppa.rajapinnat.KauppaRajapinta;

public class Main {

    public static void main(String[] args) {
        Kauppa kauppa = new Kauppa(new KauppaRajapinta());

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();

        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : Kirjanpito.getInstance().getTapahtumat()) {
            System.out.println(tapahtuma);
        }

    }
}
