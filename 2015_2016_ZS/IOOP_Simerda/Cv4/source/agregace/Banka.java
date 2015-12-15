package agregace;

public class Banka
{
    private Ucet ucet;
    
    public Banka()
    {
        ucet = new Ucet(123456);
    }
    
    public Ucet dejUcet()
    {
        return this.ucet;
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
    
    public void zrusUcet()
    {
        ucet = null;
    }
}
