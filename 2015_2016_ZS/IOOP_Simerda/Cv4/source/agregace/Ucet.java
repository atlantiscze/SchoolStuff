package agregace;

public class Ucet
{
    private int cislo;
    private double zustatek;
    
    public Ucet(int cislo)
    {
        this.cislo = cislo;
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
