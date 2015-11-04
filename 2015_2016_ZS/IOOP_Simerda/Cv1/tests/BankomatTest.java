package bankomat;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankomatTest
{
    Bankomat bankomat;
    
    public BankomatTest()
    {
        bankomat = new Bankomat();
    }
    
    @Test
    public void testVkladVyber()
    {
        bankomat.setPenize(250);
        assertEquals(0, bankomat.getPenize(250), 0.1);          // assertEquals() shodi test pokud bankomat.getPenize vrati hodnotu jinou nez 0.
    }                                                           // Treti parametr je tolerance, napriklad hodnota 0.09 by jeste nespadla.
    
    @Test
    public void testVelkyVyber()
    {
        bankomat.setPenize(50);
        assertEquals(50, bankomat.getPenize(250000), 0.1);      // Tento vyber neprojde protoze na uctu neni dost penez.
    }
    
    
    
    
}
