package Lekce03;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBankomatu
{
    Bankomat B1, B2;
    Ucet U1;
    
    public TestBankomatu()
    {
        B1 = new Bankomat();
        B2 = new Bankomat();
        U1 = new Ucet();

    }

    @Test
    public void testBankomatu()
    {
        U1.vloz(1000);
        assertEquals(0, B1.vyberPenize(1000), 0.1);
        B1.nastavUcet(U1);
        B2.nastavUcet(U1);
        assertEquals(600, B1.vyberPenize(600), 0.1);
        assertEquals(400, B2.vyberPenize(400), 0.1);
        assertEquals(0, B1.vyberPenize(1000), 0.1);
    }

    
    
    
    
    
    
    
    
}
