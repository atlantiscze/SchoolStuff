package koule;

public class Koule
{
    static final double mojePI = 3.14159;       // Konstanta Pi. Protoze pouzivani math.PI je moc mainstreamova zalezitost. Take to vyzaduje zadani.
    static final int MAX_POLOMER = 10000;       // Maximalni polomer koule.
    static int pocet = 0;                       // Tato promenna pocita kolik objektu koule bylo vytvoreno. Zaciname na 0.
    private double polomer;                     // Polomer a objem teto konkretni koule.
    private double objem;

 
    public Koule()                              // Pretizeny konstruktor. Pokud uzivatel nezada parametr predpokladame ze je zadany polomer 0.
    {
        this(0);                                // Zavolame tedy druhy konstruktor a predame mu cislo 0.
    }

    public Koule(double polomer)                // Druhy konstruktor, tento vyzaduje jednu hodnotu a to polomer.
    {
        _setPolomer(polomer);
        pocet++;                                // Kazde zavolani konstruktoru (a tedy vytvoreni nove promenne typu koule) zvysi promennou pocet o 1.
    }  

    private void _calcObjem()                   // Vypocita objem a ulozi ho do promenne objem tohoto objektu koule. (polomer ^ 3) * (4/3) * pi
    {
        this.objem = (this.polomer * this.polomer * this.polomer) * (4.0/3.0) * mojePI;
    }
    
    public double objem()                       // Toto je jednoduchy getter, vraci hodnotu objemu.
    {
        return this.objem;
    }
            
    
    public void setPolomer(double polomer)      // Jednoduchy setter, preda novy polomer funkci _setPolomer()
    {
        _setPolomer(polomer);
    }
    
    private void _setPolomer(double polomer)
    {
        if((polomer >= 0.0) && (polomer <= MAX_POLOMER))    // Zaporny polomer, nuly, a vice nez MAX_POLOMER nechceme.
        {
            this.polomer = polomer;
        }
        else
        {
            this.polomer = 0.0;
        }
        _calcObjem();                           // Na zaver prepocitame objem.
    }
    public double getPolomer()                  // Jednoduchy getter, vraci hodnotu polomeru.
    {
        return polomer;
    }
}