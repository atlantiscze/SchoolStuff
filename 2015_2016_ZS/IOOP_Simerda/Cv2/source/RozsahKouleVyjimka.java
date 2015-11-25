package Lekce02;

public class RozsahKouleVyjimka extends Exception
{
    // Nase vlastni vyjimka. Chova se stejne jako Exception akorat s jinym textem (viz nize)
    public RozsahKouleVyjimka()
    {
        super("Prekrocen rozsah vstupniho parametru koule");
    }

    public RozsahKouleVyjimka(String msg)
    {
        super(msg);
    }
}
