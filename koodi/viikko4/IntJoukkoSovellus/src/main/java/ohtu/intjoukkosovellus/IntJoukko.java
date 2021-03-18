package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        alustaJoukko(ljono);
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public int[] alustaJoukko(int[] ljono) {
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        return ljono;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        alustaJoukko(ljono);
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        kapasiteettiNegatiivinen(kapasiteetti);
        kasvatuskokoNegatiivinen(kasvatuskoko);
        ljono = new int[kapasiteetti];
        alustaJoukko(ljono);
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public void kapasiteettiNegatiivinen(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }

    }

    public void kasvatuskokoNegatiivinen(int kasvatuskoko) {
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }

    }

    public boolean lisaaLukuJoukkoon(int luku) {

        // int eiOle = 0;
        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return true;
        } else {
        }
        if (!kuuluukoLukuTaulukkoon(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % ljono.length == 0) {
                kasvataTaulukonKokoa();
            }
            return true;
        }
        return false;
    }
        private void kasvataTaulukonKokoa() {
        int[] taulukkoOld = new int[ljono.length];
                taulukkoOld = ljono;
                kopioiTaulukko(ljono, taulukkoOld);
                ljono = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, ljono);
        
    }

    public boolean kuuluukoLukuTaulukkoon(int luku) {
        int on = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                on++;
            }
        }
        if (on > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean poistaLukuTaulukosta(int luku) {
        int kohta = -1;
        int apu = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                ljono[i] = 0;
                break;
            }
        }

        if (kohta != -1) {
            uusiTaulukko(kohta, apu);
        }

        return false;
    }

    public boolean uusiTaulukko(int kohta, int apu) {

        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = apu;
        }
        alkioidenLkm--;
        return true;

    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {

        String tulos = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tulos += ljono[i];
            if (i < alkioidenLkm - 1) {
                tulos += ", ";
            }
        }
        return tulos + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaaLukuJoukkoon(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaaLukuJoukkoon(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaaLukuJoukkoon(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaaLukuJoukkoon(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poistaLukuTaulukosta(bTaulu[i]);
        }

        return z;
    }

}
