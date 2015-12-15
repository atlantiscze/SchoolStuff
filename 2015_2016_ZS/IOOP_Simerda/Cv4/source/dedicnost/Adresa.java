package dedicnost;

public class Adresa
{
    private String ulice;
    private int cislo;
    private String mesto;
    private String psc;
    
    public Adresa(String ulice, int cislo, String mesto, String psc)
    {
        this.ulice = ulice;
        this.cislo = cislo;
        this.mesto = mesto;
        this.psc = psc;
    }

    @Override
    public String toString()
    {
        return "Adresa{" + "ulice=" + ulice + ", cislo=" + cislo + ", mesto=" + mesto + ", psc=" + psc + '}';
    }
    


    public String getUlice()
    {
        return ulice;
    }

    public void setUlice(String ulice)
    {
        this.ulice = ulice;
    }

    public int getCislo()
    {
        return cislo;
    }

    public void setCislo(int cislo)
    {
        this.cislo = cislo;
    }

    public String getMesto()
    {
        return mesto;
    }

    public void setMesto(String mesto)
    {
        this.mesto = mesto;
    }

    public String getPsc()
    {
        return psc;
    }

    public void setPsc(String psc)
    {
        this.psc = psc;
    }
}
