package ohtu.verkkokauppa;

import ohtu.verkkokauppa.rajapinnat.KirjanpitoIO;
import ohtu.verkkokauppa.rajapinnat.PankkiIO;
import org.springframework.stereotype.Component;

@Component
public class Pankki implements PankkiIO{


    private KirjanpitoIO kio;

    public Pankki(Kirjanpito kirjanpito) {
        this.kio = kirjanpito;
    }

    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kio.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
