package ohtu.verkkokauppa;

import ohtu.verkkokauppa.rajapinnat.ViitegeneraattoriIO;
import org.springframework.stereotype.Component;

@Component
public class Viitegeneraattori implements ViitegeneraattoriIO{

    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    public int uusi(){
        return seuraava++;
    }
}
