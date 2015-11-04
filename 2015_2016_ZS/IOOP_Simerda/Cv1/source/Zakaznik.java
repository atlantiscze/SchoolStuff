package zakaznik;


public class Zakaznik
{
    public static int pocet = 0;            // Na tomto objektu neni nic moc zajimaveho. Pocet se pocita stejne jako u koule.
    private int utratil = 0;                // Utratil je hodnota ktera se da zvysit pomoci funkce platil()
    
    public Zakaznik()
    {
        pocet++;
    }
            
    public void platil(int cena)
    {
        cena = Math.max(cena, 0);           // Zde jen zminim kontrolu, nelze predat zaporne cislo a tim to rozbit.
        utratil += cena;
    }
}
