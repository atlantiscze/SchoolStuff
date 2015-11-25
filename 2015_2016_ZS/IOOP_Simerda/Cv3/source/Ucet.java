package Lekce03;

public class Ucet
{
    private double zustatek = 0;            // Zustatek na tomto uctu
    
    public boolean vyber(double castka)     // Funkce ktera zkusi vybrat penize. Pokud uspeje odecte je ze zustatku a vrati true. Jinak false.
    {
        castka = Math.max(0, castka);       // Ochrana proti zaporne castce pri vyberu.
        if(castka <= zustatek)              // Mame-li dostatek penez v zustatku
        {
            zustatek -= castka;             // Odecteme castku ze zustatku a vratime true.
            return true;
        }
        return false;                       // V opacnem pripade vratime false.
    }
    
    public double getZustatek()             // Vraci zustatek na uctu
    {
        return zustatek;
    }
    
    public void vloz(double castka)         // Funkce ktera vlozi penize na ucet.
    {
        castka = Math.max(0, castka);       // Ochrana proti zaporne castce pri vkladu.
        zustatek += castka;                 // Pricteme castku ke zustatku.
    }
    
}
