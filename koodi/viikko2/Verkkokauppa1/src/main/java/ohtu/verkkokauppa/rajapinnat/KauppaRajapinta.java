/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa.rajapinnat;

import ohtu.verkkokauppa.Ostoskori;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Tuote;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;

/**
 *
 * @author Tomi
 */
public class KauppaRajapinta implements IO {

    private Varasto varasto;
    private Pankki pankki;
    private Viitegeneraattori vg;
    private Ostoskori ostoskori;
    String kaupanTili = "33333-44455";
    
    public KauppaRajapinta(){
        varasto = new Varasto();
        pankki = new Pankki();
        vg = new Viitegeneraattori();
        ostoskori = new Ostoskori();
        
    }

    @Override
    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id);
        varasto.palautaVarastoon(t);

    }

    @Override
    public void aloitaAsiointi() {
        Ostoskori ostoskori = new Ostoskori();
  
    }

    @Override
    public void lisaaKoriin(int id) {
        if (varasto.saldo(id) > 0) {
            Tuote t = varasto.haeTuote(id);
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }

    }

    @Override
    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = vg.uusi();
        int summa = ostoskori.hinta();

        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }
}
