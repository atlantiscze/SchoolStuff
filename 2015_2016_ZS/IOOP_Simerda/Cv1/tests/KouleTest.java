package koule;

import org.junit.Test;
import static org.junit.Assert.*;

public class KouleTest
{
    Koule koule;
    
    public KouleTest()
    {
        koule = new Koule();
    }

    @Test
    public void testObjem( )
    {
        koule.setPolomer(10.0);
        double result = koule.objem();
        double expResult = 4188.790205;             // Toto je ocekavany vysledek. Lze si ho spocitat rucne, pomoci kalkulacky, etc.
        assertEquals(expResult, result, 0.1);       // Porovname zda se ocekavany a skutecny vysledek shoduji.
    }
    
    @Test
    public void testPolomer( )
    {
        koule.setPolomer(15.0);
        double result = koule.getPolomer();
        double expResult = 15;
        assertEquals(expResult, result, 0.1);
    }
} 