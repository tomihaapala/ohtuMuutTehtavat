
package ohtu.verkkokauppa;

import java.util.ArrayList;
import ohtu.verkkokauppa.rajapinnat.KirjanpitoIO;
import org.springframework.stereotype.Component;

@Component
public class Kirjanpito implements KirjanpitoIO{
    
    private ArrayList<String> tapahtumat;

    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
