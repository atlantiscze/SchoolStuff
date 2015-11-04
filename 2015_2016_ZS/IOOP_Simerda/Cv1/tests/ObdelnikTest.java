package obdelnik;

import org.junit.Test;
import static org.junit.Assert.*;

public class ObdelnikTest
{
    
    @Test
    public void testObvod()
    {
        Obdelnik o1 = new Obdelnik();
        assertEquals(0, o1.obvod());
        Obdelnik o2 = new Obdelnik(6,5);
        assertEquals(22, o2.obvod());
        Obdelnik ox = new Obdelnik(2,3);
        Obdelnik o3 = new Obdelnik(ox);
        assertEquals(10, o3.obvod());
    }
    
    @Test
    public void testObsah()
    {
        Obdelnik o1 = new Obdelnik();
        assertEquals(0, o1.obsah());
        Obdelnik o2 = new Obdelnik(6,5);
        assertEquals(30, o2.obsah());
        Obdelnik ox = new Obdelnik(2,3);
        Obdelnik o3 = new Obdelnik(ox);
        assertEquals(6, o3.obsah());
    }
}