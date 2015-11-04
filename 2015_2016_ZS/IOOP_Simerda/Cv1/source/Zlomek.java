package zlomek;

public class Zlomek
{
    protected int citatel, jmenovatel;              // Citatel a jmenovatel tohoto zlomku.
    
    public Zlomek(int citatel, int jmenovatel)      // Jednoduchy konstruktor
    {
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;               // Zde by se jeste dalo overovat zda jmenovatel neni 0, pokud ano tak nejspis hodit vyjimku.
    }
    
    public Zlomek krat(Zlomek z)                    // Nasobeni dvou zlomku.
    {
        return new Zlomek((citatel * z.citatel), (jmenovatel * z.jmenovatel));  // Vytvorime novy objekt zlomek a tomu predame novy citatel a jmenovatel.   
    }                                                                           // Tento zlomek vratime returnem.
               
    @Override
    public String toString()
    {
        return "[" + citatel + "/" + jmenovatel + "]";      // tostring() upraveny tak aby vypsal hodnotu zlomku, napr:  [2/3]
    }
}

