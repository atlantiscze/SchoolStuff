package kolekce;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kolekce.IKolekce.KolekceException;
import static kolekce.IKolekce.StavKolekce.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FrontaTest {

    final TestClass to1 = new TestClass(1);
    final TestClass to2 = new TestClass(2);
    final TestClass to3 = new TestClass(3);
    final TestClass to4 = new TestClass(4);

    /**
     * TestovacĂ­ tĹ™Ă­da je urÄŤena jako konkrĂ©tnĂ­ tĹ™Ă­da k vklĂˇdĂˇnĂ­ do kolekce
     */
    class TestClass {

        int a;

        TestClass(int v) {
            a = v;
        }

        @Override
        public String toString() {
            return "TestObj{" + "a=" + a + '}';
        }
    }

    @Test
    public void testKontrolaPrazdneFronty() {
        Fronta<TestClass> fronta = new Fronta(2);
        assertEquals(0, fronta.getPocetPrvku());
        assertEquals(2, fronta.getKapacita());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPokusVytvoreniFrontyDelkaNula() {
        Fronta<TestClass> fronta = new Fronta(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPokusVytvoreniFrontyDelkaPlusJedna() {
        Fronta<TestClass> fronta = new Fronta(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPokusVytvoreniFrontyDelkaMinusJedna() {
        Fronta<TestClass> fronta = new Fronta(-1);
    }

    @Test
    public void testPocetPrvkuJedna() {
        try {
            Fronta<TestClass> fronta = new Fronta(3);
            fronta.vloz(to1);
            assertEquals(1, fronta.getPocetPrvku());
        } catch (KolekceException ex) {
            fail();
        }
    }

    @Test
    public void testPocetPrvkuDva() {
        try {
            Fronta<TestClass> fronta = new Fronta(3);
            fronta.vloz(to1);
            fronta.vloz(to2);
            assertEquals(2, fronta.getPocetPrvku());
        } catch (KolekceException ex) {
            fail();
        }
    }

    @Test
    public void testOdeberJedenPrvek() {
        try {
            Fronta<TestClass> fronta = new Fronta(3);
            fronta.vloz(to1);
            assertEquals(to1, fronta.odeber());
        } catch (KolekceException ex) {
            fail();
        }
    }

    @Test
    public void testVlozDoPodteceneFronty() {
        Fronta<TestClass> fronta = new Fronta(3);
        try {
            assertEquals(to1, fronta.odeber());
            fail();
        } catch (KolekceException ex) {
            try {
                fronta.vloz(to1);
                assertEquals(1, fronta.getPocetPrvku());
                assertFalse(fronta.jePrazdny());
            } catch (KolekceException ex1) {
                fail();
            }
        }
    }

    @Test
    public void testOdeberDvaPrvky() {
        try {
            Fronta<TestClass> fronta = new Fronta(3);
            fronta.vloz(to1);
            fronta.vloz(to2);
            assertEquals(to1, fronta.odeber());
            assertEquals(to2, fronta.odeber());
        } catch (KolekceException ex) {
            fail();
        }
    }

   
    @Test
    public void testJePrazdnaFronta() {
        try {
            Fronta<TestClass> fronta = new Fronta(2);
            assertTrue(fronta.jePrazdny());
            fronta.vloz(to1);
            assertFalse(fronta.jePrazdny());
        } catch (KolekceException ex) {
            fail();
        }
    }

    @Test
    public void testJePlnaFronta() {
        try {
            Fronta<TestClass> fronta = new Fronta(2);
            assertFalse(fronta.jePlny());
            fronta.vloz(to1);
            assertFalse(fronta.jePlny());
            fronta.vloz(to2);
            assertTrue(fronta.jePlny());
        } catch (KolekceException ex) {
            fail();
        }
    }

    @Test
    public void testNaPlnouFrontu() {
        Fronta<TestClass> fronta = new Fronta(2);
        try {
            fronta.vloz(to1);
            fronta.vloz(to2);
        } catch (KolekceException ex) {
            fail();
        }
        assertTrue(fronta.jePlny());
    }

    
    @Test
    public void testNePrazdnaFrontaOdeberJeden() {
        try {
            Fronta<TestClass> fronta = new Fronta(3);
            fronta.vloz(to1);
            assertEquals(to1, fronta.odeber());
        } catch (KolekceException ex) {
            fail();
        }
    }

    @Test
    public void testNaOdebraniPreplneneFronty() {
        try {
            Fronta<TestClass> fronta = new Fronta(2);
            try {
                fronta.vloz(to1);
                fronta.vloz(to2);
                fronta.vloz(to3);
                fail();
            } catch (KolekceException ex) {
            }
            fronta.odeber();
        } catch (KolekceException ex) {
            return;
        }
        fail();
    }

    @Test
    public void testNaPretecenouFrontu() {

        Fronta<TestClass> fronta = new Fronta(2);
        try {
            fronta.vloz(to1);
            fronta.vloz(to2);
            fronta.vloz(to3);
            fail();
        } catch (KolekceException ex) {
            assertEquals(PRETECENI, fronta.getStav());
            assertEquals(2, fronta.getPocetPrvku());
        }
    }

    @Test
    public void testNaPodtecenouFrontu() {

        Fronta<TestClass> fronta = new Fronta(2);
        try {
            fronta.vloz(to1);
            fronta.vloz(to2);
            fronta.odeber();
            fronta.odeber();
            fronta.odeber();
            fail();
        } catch (KolekceException ex) {
            assertEquals(PODTECENI, fronta.getStav());
            assertEquals(0, fronta.getPocetPrvku());
        }
    }

    @Test
    public void testNaVlozeniDoPreplneneFronty() {
        Fronta<TestClass> fronta = new Fronta(2);
        try {
            try {
                fronta.vloz(to1);
                fronta.vloz(to2);
                fronta.vloz(to3);
                fail();
            } catch (KolekceException ex) {
            }
            fronta.vloz(to4);
            fail();
        } catch (KolekceException ex) {
            assertEquals(PRETECENI, fronta.getStav());
            assertEquals(2, fronta.getPocetPrvku());
            return;
        }
        fail();
    }

    @Test
    public void testZrusPrazdnouFrontu() {
        Fronta<TestClass> fronta = new Fronta(2);
        fronta.zrus();
        assertEquals(0, fronta.getPocetPrvku());
        assertFalse(fronta.jePlny());
    }

    @Test
    public void testZrusNePrazdnouFrontu() {
        Fronta<TestClass> fronta = new Fronta(2);
        try {
            fronta.vloz(to1);
            fronta.vloz(to2);
        } catch (KolekceException ex) {
            fail();
        }
        fronta.zrus();
        assertEquals(0, fronta.getPocetPrvku());
        assertFalse(fronta.jePlny());
    }

    @Test
    public void testZrusPlnouFrontu() {
        Fronta<TestClass> fronta = new Fronta(2);
        try {
            fronta.vloz(to1);
            fronta.vloz(to2);
            fronta.zrus();
            assertEquals(0, fronta.getPocetPrvku());
            assertFalse(fronta.jePlny());
        } catch (KolekceException ex) {
            fail();
        }
    }

    @Test
    public void testZrusPreplnenouFrontu() {
        Fronta<TestClass> fronta = new Fronta(2);
        try {
            fronta.vloz(to1);
            fronta.vloz(to2);
            fronta.vloz(to3);
            fail();
        } catch (KolekceException ex) {
            fronta.zrus();
            assertEquals(0, fronta.getPocetPrvku());
            assertFalse(fronta.jePlny());
            return;
        }
        fail();
    }

    @Test
    public void testZrusPodtecenouFronta() {
        Fronta<TestClass> fronta = new Fronta(3);
        try {
            assertEquals(to1, fronta.odeber());
        } catch (KolekceException ex) {
            fronta.zrus();
            assertEquals(0, fronta.getPocetPrvku());
            assertFalse(fronta.jePlny());
            return;
        }
        fail();
    }

    @Test
    public void testIteratorPrazdnaFronta() {
        Fronta<TestClass> fronta = new Fronta(2);
        Iterator<TestClass> prohlidka = fronta.iterator();
        assertFalse(prohlidka.hasNext());
    }

    @Test
    public void testIteratorJedenPrvek() {
        try {
            Fronta<TestClass> fronta = new Fronta(2);
            fronta.vloz(to1);
            Iterator<TestClass> prohlidka = fronta.iterator();
            assertTrue(prohlidka.hasNext());
            assertEquals(to1, prohlidka.next());
            assertFalse(prohlidka.hasNext());
        } catch (KolekceException ex) {
            fail();
        }
    }

    @Test
    public void testIteratorDvaPrvky() {
        try {
            Fronta<TestClass> fronta = new Fronta(2);
            fronta.vloz(to1);
            fronta.vloz(to2);
            Iterator<TestClass> prohlidka = fronta.iterator();
            assertTrue(prohlidka.hasNext());
            assertEquals(to1, prohlidka.next());
            assertTrue(prohlidka.hasNext());
            assertEquals(to2, prohlidka.next());
            assertFalse(prohlidka.hasNext());
        } catch (KolekceException ex) {
            fail();
        }
    }

    @Test
    public void testIteratorPrekroceni() {
        try {
            Fronta<TestClass> fronta = new Fronta(2);
            fronta.vloz(to1);
            Iterator<TestClass> prohlidka = fronta.iterator();
            assertEquals(to1, prohlidka.next());
            prohlidka.next();
            fail();
        } catch (NoSuchElementException | KolekceException | ArrayIndexOutOfBoundsException ex) {
            return;
        }
        fail();
    }


    @Test
    public void testIteratorForEach() {
        try {
            Fronta<TestClass> fronta = new Fronta(2);
            fronta.vloz(to1);
            fronta.vloz(to2);
            int i = 0;
            for (Object prvek : fronta) {
                TestClass p = (TestClass) prvek;
                i++;
                assertEquals(i, p.a);
            }
            assertEquals(2, i);
        } catch (KolekceException ex) {
            fail();
        }
    }
}