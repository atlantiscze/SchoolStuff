package zapoctovytest;

public class Auto
{
    // Informace o jizdach a pocet jiz ulozenych jizd. Pole zacinaji petiprvkove, dle potreby se zvetsuji.
    double[] jizdy_vzdalenost = new double[5];
    double[] jizdy_spotreba = new double[5];
    int pocet_zaznamu = 0;
    
    // Konstruktor. Parametrem mu z tridy ZapoctovyTest.java predame pocet jizd ktere chceme vygenerovat.
    // Nasledne cyklem zavolame vygenerovani nahodneho zaznamu o jizde.
    public Auto(int pocetJizd)
    {
        for (int i = 0; i < pocetJizd; i++)
        {
            pridejNahodnyZaznamOJizde();
        }               
    }
    
    
    
    // Zdvojnasobi velikost poli se zachovanim puvodnich dat. Pouziva se pokud pocet prvku v poli
    // dosahne maximalni kapacity toho pole.
    private void zvetsiPole()
    {
        // Vytvorime nove pole o dvojnasobne velikosti
        double[] newP = new double[jizdy_vzdalenost.length * 2];
        // Zkopirujeme obsah stareho pole do noveho, vetsiho.
        System.arraycopy(jizdy_vzdalenost, 0, newP, 0, jizdy_vzdalenost.length);
        // A nahradime stare pole tim ktere jsme prave vytvorili.
        jizdy_vzdalenost = newP;
        // Zopakujeme i pro druhe pole.
        newP = new double[jizdy_spotreba.length * 2];
        System.arraycopy(jizdy_spotreba, 0, newP, 0, jizdy_spotreba.length);
        jizdy_spotreba = newP;
    }
    
    // Vrati prumernou vzdalenost jizdy.
    public double dejPrumernouVzdalenostJizdy()
    {
        // Pomocne promenne pomoci kterych budeme pocitat prumer.
        double vzdalenost_total = 0;
        double vzdalenost_count = 0;
        // Cyklem projdeme vsechny prvky pole.
        for (int i = 0; i < jizdy_vzdalenost.length; i++)
        {
            // Preskocime prazdne prvky pole. Ty jsou v zakladu 0
            if(jizdy_vzdalenost[i] == 0)
            {
                // Continue preskoci tento prvek pole.
                continue;
            }
            // Pricteme vzdalenost tohoto prvku do pomocne promenne.
            vzdalenost_total += jizdy_vzdalenost[i];
            vzdalenost_count++;
        }
        // A nakonec pomoci matematickeho vzorce (soucet vzdalenosti) / (pocet vzdalenosti) udelame prumer na jednu jizdu.
        // Take pouziju funkci zaokrouhliCislo ktera z potencialne osklivych cisel udela cisla zaokrouhlena na jedno desetinne misto.
        return zaokrouhliCislo(vzdalenost_total / vzdalenost_count);
    }
    
    // Vrati celkovou ujetou vzdalenost vozu
    public double dejCelkovouUjetouVzdalenost()
    {
        // Pomocna promenna
        double vzdalenost_total = 0;
        // Jednoduchy cyklus kterym projdeme cele pole.
        for (int i = 0; i < jizdy_vzdalenost.length; i++)
        {
            // Preskocime prazdne prvky pole.
            if(jizdy_vzdalenost[i] == 0)
            {
                continue;
            }
            // Do pomocne promenne pricteme obsah tohoto prvku pole. Diky cyklu tak secteme vsechny prvky.
            vzdalenost_total += jizdy_vzdalenost[i];
        }     
        // A vratime vyse zmineny soucet. Opet zaokrouhlime na jedno desetinne misto.
        return zaokrouhliCislo(vzdalenost_total);
    }
    
    // Vrati celkovou spotrebu vozu.
    public double dejCelkovouSpotrebuPaliva()
    {
        // Trochu slozitejsi verze predchozi funkce.
        double benzin_total = 0;
        for (int i = 0; i < jizdy_spotreba.length; i++)
        {
            // Preskocime prazdne prvky pole.
            if(jizdy_spotreba[i] == 0)
            {
                continue;
            }
            // Benzin mame uvedeny v litrech/100km. Zjistime tedy kolik stovek kilometru jsme ujeli.
            double ujeta_vzdalenost = (jizdy_vzdalenost[i] / 100.0);
            // A pricteme do pomocne promenne.
            benzin_total += jizdy_spotreba[i] * ujeta_vzdalenost;
        }     
        // Opet vratime zaokrouhlene cislo
        return zaokrouhliCislo(benzin_total);
    }    
    
    // Generuje nahodne cislo typu Double z intervalu. Pro vetsi srozumitelnost cisel
    // je zaokrouhluji na 1 desetinne misto.
    public double dejNahodneCislo(double min, double max)
    {
        double vysledek = ((Math.random() * (max-min)) + min);
        return zaokrouhliCislo(vysledek);
    }
    
    // Prida zaznam o jizde
    public void pridejZaznamOJizde(double vzdalenost, double spotreba)
    {
        // Tato funkce jako parametry bere vzdalenost a spotrebu.
        // Nejprve zvysime promennou ktera urcuje kolik mame zaznamu.
        pocet_zaznamu++;
        // Zkontroluji zda se vejdu do existujiciho pole. Pokud ne zavolam funkci zvetsiPole() ktera ho zdvojnasobi.
        if(jizdy_vzdalenost.length >= pocet_zaznamu)
        {
            zvetsiPole();
        }
        // A na odpovidajici indexy ulozim hodnoty predane parametry.
        jizdy_vzdalenost[pocet_zaznamu] = vzdalenost;
        jizdy_spotreba[pocet_zaznamu] = spotreba;
    }
    
    // Tato funkce vola funkci pridejZaznamOJizde() a predava ji nahodne vygenerovane parametry.
    public void pridejNahodnyZaznamOJizde()
    {
        pridejZaznamOJizde(dejNahodneCislo(5.0, 250.0), dejNahodneCislo(4.5,9.0));
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
