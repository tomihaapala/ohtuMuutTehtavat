package ohtu.verkkokauppa;


import ohtu.verkkokauppa.rajapinnat.PankkiIO;
import ohtu.verkkokauppa.rajapinnat.VarastoIO;
import ohtu.verkkokauppa.rajapinnat.ViitegeneraattoriIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {

    private VarastoIO vio;
    private PankkiIO pio;
    private ViitegeneraattoriIO vgio;
    private Ostoskori ostoskori;
    String kaupanTili = "33333-44455";
    
    @Autowired
    public Kauppa(Varasto instance, Pankki instance0, Viitegeneraattori instance1) {
        this.pio = instance0;
        this.vgio = instance1;
        this.vio =  instance;
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = vio.haeTuote(id);
        vio.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (vio.saldo(id) > 0) {
            Tuote t = vio.haeTuote(id);
            ostoskori.lisaa(t);
            vio.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = vgio.uusi();
        int summa = ostoskori.hinta();

        return pio.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
