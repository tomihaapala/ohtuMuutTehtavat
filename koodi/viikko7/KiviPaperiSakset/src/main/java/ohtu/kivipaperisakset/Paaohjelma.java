package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);
    private static KiviPaperiSakset uusiPeli;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistÃ¤ vastaan "
                    + "\n (b) tekoÃ¤lyÃ¤ vastaan"
                    + "\n (c) parannettua tekoÃ¤lyÃ¤ vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.equals("a")) {
                uusiPeli = KiviPaperiSakset.luoUusiPelaajaVsPelaaja();
            }
            if (vastaus.endsWith("b")) {
                uusiPeli = KiviPaperiSakset.luoUusiPelaajaVsTekoaly();

            }
            if (vastaus.endsWith("c")) {
                uusiPeli = KiviPaperiSakset.luoUusiPelaajaVsVahvaTekoaly();

            }

            uusiPeli.pelaa();
        }

    }
}
