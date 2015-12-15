package dedicnost;

import static dedicnost.TypUctu.*;
import java.util.Date;

public class Banka
{
    private Adresa adresa;
    private Ucet ucet;
    private TypUctu typ;
    private int kodBanky;
    private Majitel majitel;
    
    public Banka(TypUctu typ, int kodBanky)
    {
        this.kodBanky = kodBanky;
        this.typ = typ;
        majitel = new Majitel(null, null, null, null);
        Date d = new Date();
        // TODO: Nejake generovani nahodneho data?
        switch(typ)
        {
            case BEZNY_UCET:
                ucet = new BeznyUcet(1234567, (float) 0.02);
                break;
            case SPORICI_UCET:
                ucet = new SporiciUcet(1234567, (float) 0.04, d);
                break;
            case TERMINOVANY_UCET:
                ucet = new TerminovanyUcet(1234567, (float) 0.05, d);
                break;
        }
        
    }
    
    // Tahle funkce mela brat jako parametr instanci tridy Majitel, ale netusil sem jak to je mysleno, tak jsem to udelal takhle.
    public void setAdresaBanky(String ulice, int cislo, String mesto, String psc)
    {
        adresa = new Adresa(ulice, cislo, mesto, psc);
    }
    
    public void setMajitelUctu(Majitel m)
    {
        if(ucet == null)
        {
            return;
        }
        ucet.setMajitel(m);
    }
    
    public void setTermin(Date d)
    {
        if(typ != TERMINOVANY_UCET)
        {
            return;
        }
        TerminovanyUcet t = (TerminovanyUcet) ucet;
        t.setTermin(d);
    }
    
    public void setDatumVypovedi(Date d)
    {
        if(typ != SPORICI_UCET)
        {
            return;
        }
        SporiciUcet u = (SporiciUcet) ucet;
        u.setDatumVypovedi(d);
    }
    
    public void vloz(float amt)
    {
        if(ucet == null)
        {
            return;
        }
        ucet.vloz(amt);
    } 

    public float getZustatek()
    {
        if(ucet == null)
        {
            return 0;
        }
        return ucet.getZustatek();
    }
    
    public Adresa getAdresaBanky()
    {
        return adresa;
    }
    
    public Adresa getAdresaMajitele()
    {
        if(majitel == null)
        {
            return null;
        }
        return majitel.getAdresa();
    }
    
    public void setNovaAdresaMajiteleUctu(String ulice, int cislo, String mesto, String psc)
    {
        if(majitel == null)
        {
            return;
        }
        Adresa a = new Adresa(ulice, cislo, mesto, psc);
        majitel.setAdresa(a);   
    }

    @Override
    public String toString()
    {
        return "Banka{" + "adresa=" + adresa + ", ucet=" + ucet + ", typ=" + typ + ", kodBanky=" + kodBanky + ", majitel=" + majitel + '}';
    }
    

}
