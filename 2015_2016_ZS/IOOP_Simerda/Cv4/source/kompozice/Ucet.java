package kompozice;

public class Ucet
{
    private long cislo;
    private double zustatek;
    
    public Ucet(long cislo)
    {
        this.cislo = cislo;
    }
    
    public long getCisloUctu()
    {
        return cislo;
    }
    
    public double getZustatek()
    {
        return zustatek;
    }
    
    public void vloz(double castka)
    {
        castka = Math.max(castka, 0);
        zustatek += castka;
    }
    
    public boolean vyber(double castka)
    {
        castka = Math.max(castka, 0);
        if(castka > zustatek)
        {
            return false;
        }
        zustatek -= castka;
        return true;
    }
    
}
