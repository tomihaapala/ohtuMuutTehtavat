package ohtu.verkkokauppa;

import ohtu.verkkokauppa.rajapinnat.IO;

public class Kauppa {

    private IO io;
    
    public Kauppa(IO io) {   
        this.io = io;
    }

    public void aloitaAsiointi() {
        io.aloitaAsiointi();
    }

    public void poistaKorista(int id) {
       io.poistaKorista(id);
    }

    public void lisaaKoriin(int id) {
       io.lisaaKoriin(id);
        }
    

    public boolean tilimaksu(String nimi, String tiliNumero) {
        return io.tilimaksu(nimi, tiliNumero);

    }

}
