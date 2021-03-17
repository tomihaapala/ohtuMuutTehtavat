/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Tomi
 */
public class Nollaus extends Komento {


    public Nollaus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);

    }

    @Override
    public void suorita() {
        
        nollaa.disableProperty().set(false);
        
        sovellus.nollaa();
        
        tuloskentta.setText("0");
        
      
    
       
    }

}

