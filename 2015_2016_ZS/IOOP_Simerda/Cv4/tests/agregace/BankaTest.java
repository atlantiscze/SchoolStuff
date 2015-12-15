package agregace;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankaTest
{   
    @Test
    public void testBanka()
    {
        Banka KB = new Banka();
        Bankomat B1 = new Bankomat();
        
        B1.nastavBanku(KB);
        KB.vloz(1000);
        
        assertEquals(B1.vyber(500), true);
        
        Ucet U1 = KB.dejUcet();
        
        assertEquals(U1.getZustatek(), 500, 0.1);
    }
}
