package Lekce02;

public final class Koule
{
    public final double MAX_MERNA_HMOTNOST = 100;           // Finalni promenne ktere nam limituji velikost merne hmotnosti a polomeru
    public final double MAX_POLOMER = 10;
    private BarvaTvaru barva;                               // Ostatni promenne.
    private long hmotnost;
    private double mernaHmotnost;
    private double objem;
    private static int pocet = 0;
    private long polomer;
    private long povrch;
    private final int desetinnaMista = 5;                   // Podle zadani maji nektere promenne byt typu long (velky integer) ale my chceme desetinna mista. Timto to obejdeme.
    
    // Konstruktor
    Koule(BarvaTvaru barva, double mh, double r) throws RozsahKouleVyjimka
    {
        setBarva(barva);
        setMernaHmotnost(mh);
        setPolomer(r);
        prepocitej();                                       // Prepocitame hmotnosti a podobne promenne.
        pocet++;
    }

    // Samotne vypocty pomoci matematickych vzorecku ktere nebudu popisovat. U hmotnosti a povrchu nasobim 10 ^ desetinnaMista.
    // Tak obejdu limit longu ktery neumi desetinna mista. Gettery nasledne tyto hodnoty zase vydeli stejnou mocninou deseti a tak vrati cislo s des. misty.
    // Jednoduseji by to slo pouzitim datoveho typu ktery umi desetinna mista (double napr.) ale v zadani je float, tak je i zde.
    private void vypoctiHmotnost()
    {
        this.hmotnost = (long) ((this.mernaHmotnost * this.getObjem()) * Math.pow(10, desetinnaMista));
    }
    
    private void vypoctiObjem()
    {
        this.objem = (double) (4.0 * Math.PI * Math.pow(this.getPolomer(), 3.0) / 3.0);
    }
    
    private void vypoctiPovrch()
    {
        this.povrch = (long) ((4.0 * Math.PI * Math.pow(this.getPolomer(), 2.0)) * Math.pow(10, desetinnaMista));
    }
    
    // Settery ktere nastavi urcite promenne.
    public void setBarva(BarvaTvaru barva)
    {
        this.barva = barva;
    }
    
    public void setMernaHmotnost(double mh) throws RozsahKouleVyjimka
    {
        // Zkontrolujeme zda jsme v rozsahu 0 - MAX, pokud ne hodime vyjimku.
        if((mh > MAX_MERNA_HMOTNOST) || (mh < 0))
        {
            throw new RozsahKouleVyjimka();
        }
        this.mernaHmotnost = (double) mh;               // Nastavime promennou
        prepocitej();                                   // Nezapomeneme prepocitat hodnoty
    }

    public void setPolomer(double r) throws RozsahKouleVyjimka
    {
        // Stejne jako v predchozi funkci provedeme kontrolu
        if((r > MAX_POLOMER) || (r < 0))
        {
            throw new RozsahKouleVyjimka();
        }
        this.polomer = (long) (r * Math.pow(10, desetinnaMista));
        prepocitej();
    }
     
    // Zkratka ktera zavola prepocitani vsech tri promennych (hmotnost, objem, povrch)
    private void prepocitej()
    {
        vypoctiObjem();
        vypoctiHmotnost();
        vypoctiPovrch();
    }
    
    // Nasleduji gettery ktere vraci jednotlive promenne. Nektere z nich nasobi mocninou deseti - viz. nahore, obchazime tim limit desetinnych mist.
    public BarvaTvaru getBarva()
    {
        return barva;
    }
    
    public double getHmotnost()
    {
        // Nasobime zde tisici protoze vysledek ma zrejme byt v mensich jednotkach, soude podle hodnot v testu.
        return hmotnost / Math.pow(10, desetinnaMista) * 1000.0;
    }
    
    public double getObjem()
    {
        return objem;
    }
    
    public int getPocet()
    {
        return pocet;
    }
    
    public double getPolomer()
    {
        return polomer / Math.pow(10, desetinnaMista);
    }
    
    public double getPovrch()
    {
        return (double) (povrch / Math.pow(10, desetinnaMista));
    }
}
