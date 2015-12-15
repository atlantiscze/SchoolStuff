package kolekce;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static kolekce.IKolekce.StavKolekce.*;

public class Fronta<E> implements IKolekce
{
    private final int kapacita;
    private int pocetPrvku;
    private final E[] pole;
    private StavKolekce stav;
    
    @SuppressWarnings("unchecked")
    public Fronta(int kapacita)
    {
        if(kapacita <= 1)
        {
            throw new IllegalArgumentException("Fronta musi mit kladnou kapacitu!");
        }
        this.kapacita = kapacita;
        pocetPrvku = 0;
        pole = (E[]) new Object[kapacita];
        stav = PRAZDNY;
    }

    @Override
    public int getPocetPrvku()
    {
        return pocetPrvku;
    }

    @Override
    public int getKapacita()
    {
        return kapacita;
    }

    @Override
    public boolean jePlny()
    {
        return (pocetPrvku >= kapacita);
    }

    @Override
    public boolean jePrazdny()
    {
        return (pocetPrvku == 0);
    }

    @Override
    public Object odeber() throws KolekceException
    {
        if(jePrazdny() || (stav == PRETECENI))
        {
            if(jePrazdny())
            {
                stav = PODTECENI;
            }
            throw new KolekceException("Kolekce je prazdna nebo doslo k preteceni.");
        }
        Object o = pole[0];
        // Preskladame prvky pole
        for (int i = 0; i < kapacita; i++)
        {
            // Posledni prvek pole, pokud by jsme zde zkouseli i+1 dostaneme chybu.
            if(i == kapacita-1)
            {
                pole[i] = null;
            }
            else
            {
                pole[i] = pole[i+1];
            }
        }
        pocetPrvku--;
        if(pocetPrvku == 0)
        {
            stav = PRAZDNY;
        }
        return o;
    }

    @Override
    public void vloz(Object element) throws KolekceException
    {
        if(pocetPrvku >= kapacita)
        {
            stav = PRETECENI;
            throw new KolekceException("Kolekce je plna");
        }
       
        pocetPrvku++;
        pole[pocetPrvku-1] = (E) element;
        
        if(pocetPrvku == kapacita)
        {
            stav = PLNY;
        }
        else if (pocetPrvku < kapacita)
        {
            stav = NEPRAZDNY;
        }
            
    }

    @Override
    public void zrus()
    {
        stav = PRAZDNY;
        pocetPrvku = 0;
        for (int i = 0; i < kapacita; i++)
        {
            pole[i] = null;
        }
    }

    @Override
    public StavKolekce getStav()
    {
        return stav;
    }    

    // Nejde vytvorit instance tridy Iterator, nastavil jsem tam tedy return null protoze to tu byt musi.
    @Override
    public Iterator<E> iterator()
    {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E>
    {
        private int pozice;

        public MyIterator()
        {
            this.pozice = 0;
        }

        @Override
        public boolean hasNext()
        {
            return pozice < pocetPrvku;
        }

        @Override
        public E next()
        {
            if(this.hasNext())
            {
                E soucasny = pole[pozice];
                pozice++;
                return soucasny;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }    
    
}
