package dedicnost;

import static dedicnost.TypUctu.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankaTest
{
    @Test
    public void testBanka()
    {
        Banka kb = new Banka(BEZNY_UCET, 771);
        kb.setAdresaBanky("Nad Mostem", 101, "Pardubice", "52 003");
        kb.setNovaAdresaMajiteleUctu("Pod Mostem", 72, "Pardubice", "52 003");
        Majitel m = new Majitel("Smith", "John", "12345-6789", new Adresa("Mezi Mosty", 11, "Pardubice", "52 003"));
        kb.setMajitelUctu(m);
        kb.vloz(2500);
        System.out.println(kb.toString());
    } 
}
