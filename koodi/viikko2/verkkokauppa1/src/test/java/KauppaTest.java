
import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Tuote;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tomi
 */
public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viitegeneraattori;
    Varasto varasto;
    Kauppa kauppa;

    @Before
    public void setUp() {

        pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);

        when(viite.uusi()).thenReturn(42);

        varasto = mock(Varasto.class);

        // m‰‰ritell‰‰n ett‰ tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        when(varasto.saldo(2)).thenReturn(1);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "kahvi", 5));
        
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "pulla", 2));

        kauppa = new Kauppa(varasto, pankki, viite);
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
        // toistaiseksi ei v‰litetty kutsussa k‰ytetyist‰ parametreista
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan2() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }

    @Test
    public void tehdaanKaksiOstosta() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);  // ostetaan tuotetta numero 1 eli maitoa
        kauppa.lisaaKoriin(2); 
        kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 10);
    }
    
    @Test
    public void tehdaanKaksiOstostaJoistaToinenLoppu() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);  // ostetaan tuotetta numero 1 eli maitoa
        kauppa.lisaaKoriin(3); 
        kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }
}
