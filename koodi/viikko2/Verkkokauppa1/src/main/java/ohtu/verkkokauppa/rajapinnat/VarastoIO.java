/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa.rajapinnat;

import ohtu.verkkokauppa.Tuote;

/**
 *
 * @author Tomi
 */
public interface VarastoIO {
    
  

    public Tuote haeTuote(int id);

    public void palautaVarastoon(Tuote t);

    public int saldo(int id);

    public void otaVarastosta(Tuote t);
    
}
