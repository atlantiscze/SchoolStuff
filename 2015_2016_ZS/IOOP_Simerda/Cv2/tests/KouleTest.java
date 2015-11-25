package Lekce02;

import static Lekce02.BarvaTvaru.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

public class KouleTest {

    Koule k;

    public KouleTest() throws RozsahKouleVyjimka
    {
        k = new Koule(CERNA, 1, 1);
    }

    @Test
    public void testPolomer() throws RozsahKouleVyjimka
    {
        double r = 0.0;
        k.setPolomer(r);
        assertEquals(r, k.getPolomer(), 0.001);

        r = .001;
        k.setPolomer(r);
        assertEquals(r, k.getPolomer(), 0.001);

        r = 1.0;
        k.setPolomer(r);
        assertEquals(r, k.getPolomer(), 0.001);
            
        r = 10.0;
        k.setPolomer(r);
        assertEquals(r, k.getPolomer(), 0.001);
    }

    @Test(expected=RozsahKouleVyjimka .class)
    public void testPolomerNaVyjimku1() throws RozsahKouleVyjimka 
    {
        k.setPolomer(-0.001);
    }
    
    @Test(expected=RozsahKouleVyjimka .class)
    public void testPolomerNaVyjimku2() throws RozsahKouleVyjimka
    {
        k.setPolomer(10.001);
     }
    
    @Test
    public void testBarva()
    {
        assertEquals(CERNA, k.getBarva());
        k.setBarva(BILA);
        assertEquals(BILA, k.getBarva());
        k.setBarva(CERVENA);
        assertEquals(CERVENA, k.getBarva());
        k.setBarva(MODRA);
        assertEquals(MODRA, k.getBarva());
        k.setBarva(ZELENA);
        assertEquals(ZELENA, k.getBarva());
    }

    @Test
    public void testHmotnost()
    {
        try
        {
            k.setPolomer(1.0);
            k.setMernaHmotnost(1.0);
        } 
        catch (RozsahKouleVyjimka ex)
        {
            Logger.getLogger(KouleTest.class.getName()).log(Level.SEVERE,null,ex);
        }
        assertEquals(4188.79, k.getHmotnost(), 0.001);
    }
    
    @Test(expected=RozsahKouleVyjimka .class)
    public void testMernaHmotnost1() throws RozsahKouleVyjimka
    {
        k.setMernaHmotnost(-0.001);
    }
    
    @Test(expected=RozsahKouleVyjimka .class)
    public void testMernaHmotnost() throws RozsahKouleVyjimka 
    {
        k.setPolomer(100.001);
    }

    @Test
    public void testObjem() 
    {
        try 
        {
            k.setPolomer(1.0);
        } 
        catch (RozsahKouleVyjimka ex) 
        {
            Logger.getLogger(KouleTest.class.getName()).log(Level.SEVERE,null,ex);
        }
        assertEquals(4.1888, k.getObjem(), 0.001);
    }

    @Test
    public void testPovrch() 
    {
        try 
        {
            k.setPolomer(1.0);
        } 
        catch (RozsahKouleVyjimka ex) 
        {
            Logger.getLogger(KouleTest.class.getName()).log(Level.SEVERE, null,ex);
        }
        assertEquals(12.56637, k.getPovrch(), 0.001);
  }
}

