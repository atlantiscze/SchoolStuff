package zlomek;

import org.junit.Test;
import static org.junit.Assert.*;

public class ZlomekTest
{
    @Test
    public void testKrat()
    {
        Zlomek z1 = new Zlomek(1,5);
        Zlomek z2 = new Zlomek(10,2);
        Zlomek zv = z1.krat(z2);
        assertEquals(zv.toString(), "[10/10]");
    }
    
    
}
