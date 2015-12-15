package dedicnost;

public class Majitel
{
    private String prijmeni;
    private String jmeno;
    private String rodneCislo;
    private Adresa adresa;
    
    public Majitel(String prijmeni, String jmeno, String rodneCislo, Adresa adresa)
    {
        this.prijmeni = prijmeni;
        this.jmeno = jmeno;
        this.rodneCislo = rodneCislo;
        this.adresa = adresa;
    }
    
    public Adresa getAdresa()
    {
        return adresa;
    }
    
    public void setAdresa(Adresa a)
    {
        adresa = a;
    }

    @Override
    public String toString()
    {
        return "Majitel{" + "prijmeni=" + prijmeni + ", jmeno=" + jmeno + ", rodneCislo=" + rodneCislo + ", adresa=" + adresa + '}';
    }
}
