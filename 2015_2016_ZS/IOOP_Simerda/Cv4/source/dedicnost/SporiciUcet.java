package dedicnost;

import java.util.Date;

public class SporiciUcet extends Ucet
{
    Date datumVypovedi;
    
    public SporiciUcet(int cislo, float urok, Date datumvypovedi)
    {
        this.cislo = cislo;
        this.urok = urok;
        this.datumVypovedi = datumvypovedi;
    }
    
    public void setDatumVypovedi(Date t)
    {
        datumVypovedi = t;
    }
    public Date getDatumVypovedi()
    {
        return datumVypovedi;
    }

    @Override
    public String toString()
    {
        return "SporiciUcet{" + "datumVypovedi=" + datumVypovedi + '}';
    }
    
    
}
