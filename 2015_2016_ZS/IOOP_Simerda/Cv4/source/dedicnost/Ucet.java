package dedicnost;

public abstract class Ucet
{
    protected int cislo;
    protected float urok;
    protected float zustatek;
    protected Majitel majitel;


    public void vloz(float amount)
    {
        amount = Math.max(amount, 0);
        zustatek += amount;
    }
    
    public boolean vyber(float amount)
    {
        amount = Math.max(amount, 0);
        if(amount > zustatek)
        {
            return false;
        }
        zustatek -= amount;
        return true;
    }
    
    public float getZustatek()
    {
        return zustatek;
    }
    
    public void setMajitel(Majitel m)
    {
        this.majitel = m;
    }

    @Override
    public String toString()
    {
        return "Ucet{" + "cislo=" + cislo + ", urok=" + urok + ", zustatek=" + zustatek + ", majitel=" + majitel + '}';
    }
    
    
}
