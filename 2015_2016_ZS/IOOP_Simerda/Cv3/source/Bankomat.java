package Lekce03;

public class Bankomat
{
    private Ucet mUcet;
    
    public void nastavUcet(Ucet ucet)               // Funkce ktera nastavi ucet.
    {
        if(ucet != null)
        {
            mUcet = ucet;
        }
    }
    
    public double vyberPenize(double castka)
    {
        if(mUcet == null)                           // Nemame nastaveny ucet, nelze vybrat penize.
        {
            return 0;
        }
        
        // Takhle jsem to pochopil ze zadani. Zkusime vybrat castku, pokud se to podari tak vratime vybranou castku.
        // Pokud se to nepodari vratime zustatek.
        return mUcet.vyber(castka) ? castka : mUcet.getZustatek();
    }
    
    public double dejZustatek()
    {
        if(mUcet == null)                           // Opet ochrana proti nenastavenemu uctu
        {
            return 0;
        }
        return mUcet.getZustatek();                 // Pokud ucet existuje vratime z nej zustatek.
    }   
}
