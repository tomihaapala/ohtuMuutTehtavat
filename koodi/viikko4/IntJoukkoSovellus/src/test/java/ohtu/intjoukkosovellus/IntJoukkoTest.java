package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;

    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.lisaaLukuJoukkoon(10);
        joukko.lisaaLukuJoukkoon(3);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.lisaaLukuJoukkoon(4);
        assertEquals(3, joukko.mahtavuus());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.lisaaLukuJoukkoon(10);
        joukko.lisaaLukuJoukkoon(3);
        assertEquals(2, joukko.mahtavuus());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(joukko.kuuluukoLukuTaulukkoon(10));
        assertFalse(joukko.kuuluukoLukuTaulukkoon(5));
        assertFalse(joukko.kuuluukoLukuTaulukkoon(0));
        assertTrue(joukko.kuuluukoLukuTaulukkoon(3));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.poistaLukuTaulukosta(3);
        assertFalse(joukko.kuuluukoLukuTaulukkoon(3));
        assertEquals(1, joukko.mahtavuus());
    }
    
    @Test
    public void palautetaanOikeaTaulukko() {
        int[] odotettu = {3, 55, 99};
        
        joukko.lisaaLukuJoukkoon(55);
        joukko.poistaLukuTaulukosta(10);
        joukko.lisaaLukuJoukkoon(99);

        int[] vastaus = joukko.toIntArray();
        Arrays.sort(vastaus);
        assertArrayEquals(odotettu, vastaus);
    }
    
    
    @Test
    public void toimiiKasvatuksenJalkeen(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.lisaaLukuJoukkoon(luku);
        }
        assertEquals(14, joukko.mahtavuus());
        assertTrue(joukko.kuuluukoLukuTaulukkoon(11));
        joukko.poistaLukuTaulukosta(11);
        assertFalse(joukko.kuuluukoLukuTaulukkoon(11));
        assertEquals(13, joukko.mahtavuus());
    }
    
    @Test
    public void toStringToimii(){
        assertEquals("{10, 3}", joukko.toString());
    }
    
    @Test
    public void toStringToimiiYhdenKokoiselleJoukolla(){
        joukko = new IntJoukko();
        joukko.lisaaLukuJoukkoon(1);
        assertEquals("{1}", joukko.toString());
    }

    @Test
    public void toStringToimiiTyhjallaJoukolla(){
        joukko = new IntJoukko();
        assertEquals("{}", joukko.toString());
    }     
}
