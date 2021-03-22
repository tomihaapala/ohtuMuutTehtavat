package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {
   


    @Override
    protected String toisenSiirto() {
        return scanner.nextLine();  
    }

  
}