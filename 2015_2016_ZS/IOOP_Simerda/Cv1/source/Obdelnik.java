package obdelnik;

class Obdelnik
{
    private int delka;                          // Delka a sirka obdelniku
    private int sirka;
    
    public Obdelnik(int delka, int sirka)       // Hezky priklad pretezovani konstruktoru. Tyto tri verze konstruktoru berou budto konkretni hodnoty sirky a delky...
    {
        setRozmery(delka, sirka);               // Samotne nastavovani dela ve vsech 3 pripadech funkce setRozmery()
    }
    
    public Obdelnik()                           // ... zadne parametry, pouziji tedy hodnoty 0 ...
    {
        setRozmery(0,0);
    }
    
    public Obdelnik(Obdelnik o)                 // ... nebo jiz existujici objekt Obdelnik ze ktereho si sirku a delku "vypujcime".
    {
        setRozmery(o.delka, o.sirka);
    }
    
    private void setRozmery(int de, int si)
    {
        delka = Math.abs(de);                   // Zajistime ze nedostaneme zaporne hodnoty. Zde jsem pouzil absoultni hodnotu, take by se mohlo dat
        sirka = Math.abs(si);                   // pouzit max(hodnota, 0). V zadani se neupresnilo co pouzit.
    }
    
    public int obvod()                          // Funkce ktera vypocita a vrati obvod obdelniku.
    {
        return ((2*sirka) + (2*delka));
    }
    
    public int obsah()                          // Funkce ktera vypocita a vrati obsah obdelniku.
    {
        return (sirka * delka);
    }
} 
