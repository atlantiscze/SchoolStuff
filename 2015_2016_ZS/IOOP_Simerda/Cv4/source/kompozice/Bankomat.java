package kompozice;

public class Bankomat
{
    private Banka banka;
    
    public void nastavBanku(Banka b)
    {
        banka = b;
    }
    
    public boolean vyber(double castka)
    {
        if(banka == null)
        {
            return false;
        }
        return banka.vyber(castka);
    }
    
}
