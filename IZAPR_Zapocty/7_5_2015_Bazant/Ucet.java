package zapoctovytest;

public class Ucet
{
    int[] vybery = new int[5]; // Bereme cela cisla
    int pocet_vyberu = 0;
    
    // Vygeneruje urcity pocet vyberu v intervalu od 200 do 50000
    public void generujVybery(int pocet)
    {
        // Cyklus, v parametru jsme dostali promennou pocet tak ji zde vyuzijeme
        for (int i = 0; i < pocet; i++)
        {
            // A X-krat tedy zavolame vytvorZaznam. Parametrem predame nahodne cislo z intervalu.
            vytvorZaznam(dejNahodneCislo(200,50000));
        }
    }
    
    // Vypise vsechny vybery
    public void vypisVybery()
    {
        // Opet vyuzijeme cyklus
        for (int i = 0; i < vybery.length; i++)
        {
            // Kontrola. Pokud je na indexu 0 jsme v prazdne casti pole, nebudeme ji tedy vypisovat.
            if(vybery[i] == 0)
            {
                continue;   
            }
            System.out.print(vybery[i] + ",   ");    
        }
        System.out.println("");
    }
    
    // Vypocita prumerny vyber a vrati jej (zaokruhli na 1 des. misto)
    public double dejPrumernyVyber()
    {
        // Pomocne promenne
        int vybery_pocet = 0;
        int vybery_soucet = 0;
        // Cyklus, projdeme cele pole
        for (int i = 0; i < vybery.length; i++)
        {
            // Kontrola, pokud je na indexu 0 jsme v prazdne casti pole a nebudeme ji tedy pocitat.
            if(vybery[i] == 0)
            {
                continue;   
            }
            // Vyuzijeme vzorce (soucet prvku) / (pocet prvku) = prumer
            vybery_pocet++;
            vybery_soucet += vybery[i];
        }        
        // Vratime zaokrouhleny prumer.
        return  zaokrouhliCislo((double) vybery_soucet) / ((double)vybery_pocet);
    }
    
    // Setridi prvky v poli.
    public void setridVyberyVzestupne()
    {
        // Asi nejjednoduzssi, obvzlaste do testu. Nemusim se psat s bubblesortem nebo necim takovym.
        java.util.Arrays.sort(vybery);
    }
    
    // ============================================
    
    // Zdvojnasobi velikost poli se zachovanim puvodnich dat. Pouziva se pokud pocet prvku v poli
    // dosahne maximalni kapacity toho pole.
    private void zvetsiPole()
    {
        // Vytvorime nove pole o dvojnasobne velikosti
        int[] newP = new int[vybery.length * 2];
        // Zkopirujeme obsah stareho pole do noveho, vetsiho.
        System.arraycopy(vybery, 0, newP, 0, vybery.length);
        // A nahradime stare pole tim ktere jsme prave vytvorili.
        vybery = newP;
    }

    // Vygeneruje nahodne cele cislo z rozsahu.
    private int dejNahodneCislo(int min, int max)
    {
        return (int) (Math.random() * (max-min + 1)) + min;
    }    
    
    // Zapise zaznam do pole vyberu
    private void vytvorZaznam(int vyber)
    {
        pocet_vyberu++;
        // Kontrola poctu prvku v poli. Pokud nam pole nestaci zvetsime ho.
        if(pocet_vyberu >= vybery.length)
        {
            zvetsiPole();
        }
        // A pridame zaznam.
        vybery[pocet_vyberu] = vyber;
    }
    
    // Zaokrouhlime cislo na jedno desetinne misto.
    private double zaokrouhliCislo(double cislo)
    {
        // Rekneme ze puvodni cislo je 35.919292
        // Vynasobim jej deseti, bude tedy 359.19292
        // A prevedu jej na integer, tim padem se desetinna mista ztrati, 359
        int zaokrouhleni = (int) (cislo * 10.0);
        // Nasledne prevedu zpet na Double ktery desetinna mista podporuje.
        // Cislo vydelim deseti, vysledkem tedy bude 35.9
        return ((double) zaokrouhleni) / 10.0;        
        // Pokud chci zaokrouhlit na vice desetinnych mist staci zmenit 10.0 - pro dve desetinna mista 100.0 atd.
    }
    
}
