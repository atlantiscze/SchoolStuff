package agregace;

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
       Ucet u = banka.dejUcet();
       if(u == null)
       {
           return false;
       }
       if(u.getZustatek() >= castka)
       {
           return u.vyber(castka);
       }
       return false;   
    }
    
}
