package dedicnost;

import java.util.Date;

public class TerminovanyUcet extends Ucet
{
    private Date termin;
    
    public TerminovanyUcet(int cislo, float urok, Date termin)
    {
        this.cislo = cislo;
        this.urok = urok;
        this.termin = termin;
    }
    
    public void setTermin(Date t)
    {
        termin = t;
    }
    public Date getTermin()
    {
        return termin;
    }

    @Override
    public String toString()
    {
        return "TerminovanyUcet{" + "termin=" + termin + '}';
    }
    
    
}
