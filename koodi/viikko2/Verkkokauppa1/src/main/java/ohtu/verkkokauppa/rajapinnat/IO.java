/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa.rajapinnat;

/**
 *
 * @author Tomi
 */
public interface IO {

    void aloitaAsiointi();
    void poistaKorista(int id);
    void lisaaKoriin(int id);
    boolean tilimaksu(String nimi, String tilinumero);
    
    
}
