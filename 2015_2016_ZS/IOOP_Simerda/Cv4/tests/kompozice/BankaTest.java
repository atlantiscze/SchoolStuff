package kompozice;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankaTest
{
    @Test
    public void testBanka()
    {
        Banka KB = new Banka();
        KB.vloz(2000);
        
        Bankomat BA1 = new Bankomat();
        BA1.nastavBanku(KB);
        
        assertEquals(BA1.vyber(750), true);
        assertEquals(KB.dejZustatek(), 1250, 0.1);
    }  
}
