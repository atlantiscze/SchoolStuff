package kompozice;

public class Banka
{
    private long dalsiCislo;
    private Ucet ucet;
    
    public Banka()
    {
        ucet = new Ucet(12345);
    }
    
    public long dejCisloUctu()
    {
        if(ucet == null)
        {
            return 0;
        }
        return ucet.getCisloUctu();
    }
    
    public double dejZustatek()
    {
        if(ucet == null)
        {
            return 0;
        }
        return ucet.getZustatek();
    }
    
    public void vloz(double castka)
    {
        if(ucet == null)
        {
            return;
        }
        ucet.vloz(castka);
    }
    
    public boolean vyber(double castka)
    {
        if(ucet == null)
        {
            return false;
        }
        return ucet.vyber(castka);
    }
    
}
