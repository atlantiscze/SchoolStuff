package zakaznik;

import org.junit.Test;
import static org.junit.Assert.*;

public class ZakaznikTest
{
    Zakaznik zakaznik;
    
    public ZakaznikTest()
    {
        zakaznik = new Zakaznik();
    }
    
    @Test
    public void testPocet()
    {
        assertEquals(1, Zakaznik.pocet, 0.1);          // Vyuziti staticke promenne pocet. Mel by existovat jen jeden objekt zakaznik a tudiz pocet bude 1.
    }

}
