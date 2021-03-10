package ohtu.verkkokauppa;

import ohtu.verkkokauppa.rajapinnat.ViitegeneraattoriIO;

public class Viitegeneraattori implements ViitegeneraattoriIO{

    private static Viitegeneraattori instanssi;

    public static Viitegeneraattori getInstance() {
        if (instanssi == null) {
            instanssi = new Viitegeneraattori();
        }

        return instanssi;
    }
    
    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    public int uusi(){
        return seuraava++;
    }
}
