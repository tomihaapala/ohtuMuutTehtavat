/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author Tomi
 */
public abstract class KiviPaperiSakset {
    static final Scanner scanner = new Scanner(System.in);

    static KiviPaperiSakset luoUusiPelaajaVsPelaaja() {
       return new KPSPelaajaVsPelaaja();
    }
    
    
    // tämä on ns template metodi
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        
        String ekanSiirto = ensimmaisenSiirto();
        
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = toisenSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            
            System.out.println("Toisen pelaajan siirto: ");
            tokanSiirto = toisenSiirto();
            
           // tekoaly.asetaSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto();
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
