package zapocet_vaseprijmeni;

import java.util.Random;

public class Matice
{
    double[][] pole;    // Data v tehle matici
    int x;              // Rozmer matice (sloupce)
    int y;              // Rozmer matice (radky)
    
    // Konstruktor. Je univerzalni, umi jak ctvercove tak obdelnikove matice. Hodnoty predam parametry
    public Matice(int x, int y)
    {
        // Zapamatujeme si rozmery matice
        this.x = x;
        this.y = y;
        // A vytvorime pole ktere nam drzi hodnoty v matici
        pole = new double[x][y];
    }
    
    // upravime si toString() tak aby nam vracel pozadovane hodnoty 
    @Override
    public String toString()
    {
        // Tuto hodnotu budeme vracet
        String out = "";
        // Cyklus, projdeme vsechny radky
        for (int i = 0; i < y; i++)
        {
            // A druhy cyklus. Pro kazdy radek projdeme vsechny sloupce
            for (int j = 0; j < x; j++)
            {
                // Zaokrouhlime hodnotu a pridame ji do vystupni promenne
                out += zaokrouhli(pole[j][i]);
                
                // Kontrola posledni hodnoty na radku.
                if(j == (x-1))
                {
                    // Posledni hodnota - pridame %n ktery se zmeni na odradkovani.
                    out += "%n";
                }
                else
                {
                    // Neni to posledni hodnota. Pridame carku pro vizualni oddeleni hodnot.
                    out += ", ";
                }
            }
        }
        // Naformatujeme, to premeni %n na odradkovani atd.
        out = String.format(out);
        // A vratime hodnotu. Hotovo.
        return out;
    }
    
    // Naplni matici hodnotami z rozsahu
    public void generateValues(double min, double max)
    {
        // Dva vnorene cykly, tim projdeme kazdy prvek v matici nezavisle na jeji velikosti
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                // Pouzijeme pomocnou funkci ktera nam vygeneruje cisla z rozsahu min-max
                pole[i][j] = randomDoubleFromRange(min, max);
            }
        }
    }
    
    // Secteme dva sloupce a vysledek dame do tretiho radku.
    public void sumColumns(int c1, int c2)
    {
        // Cyklus, projdeme vsechny radky
        for (int i = 0; i < y; i++)
        {
            // Secteme dane hodnoty a obsah dame do 
            pole[i][2] = (pole[c1][i] + pole[c2][i]);
            // Pro obdelnikove matice, pokud uz nemame kam zapisovat hodnoty muzeme skoncit.
            if(i == x)
            {
                // Prerusi for cyklus
                break;
            }
        }
    }
    
    // Setridi jeden radek matice. Pouzijeme treba bubblesort (nejjednodussi)
    public void sortRowBubble(int row)
    {
        // Bubblesort pracuje se dvema vnorenymi cykly. Kontroluje zda hodnota vlevo neni vetsi nez hodnota v pravo. Pokud ano, prohodi je
        // Je to pekne popsane zde http://www.algoritmy.net/article/3/Bubble-sort
        for (int i = 0; i < (x - 1); i++)
        {
            for (int j = 0; j < (x - 1 - i); j++)
            {
                // Pokud je hodnota vlevo vetsi nez hodnota v pravo tak je prohodime
                if(pole[j][row] > pole[j+1][row])
                {
                    // Prohozeni pouziva pomocnou promennou pom pres kterou ty hodnoty prohodime.
                    double pom = pole[j][row];
                    pole[j][row] = pole [j+1][row];
                    pole[j+1][row] = pom;
                            
                }
            }
        }
    }
    
    // Vrati hodnoty diagonaly
    public double[] getDiagonal()
    {
        // Zjistime kolik prvku bude na diagonale
        int velikost = Math.min(x, y);
        // Vytvorime pole ktere budeme vracet
        double[] out = new double[velikost];
        // Cyklus, staci jeden protoze prochazime diagonalu (tj. body ve kterych se x = y, napr. pole[1][1], pole[2][2] atd.
        for (int i = 0; i < velikost; i++)
        {
            // Zkopirujeme si danou hodnotu
            out[i] = pole[i][i];
        }
        // A vratime pole s hodnotami.
        return out;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    // NASLEDUJICI FUNKCE JSOU POMOCNE
    // Nejsou primo v zadani ale je dobre je mit, usnadnuji praci
    
    // Zaokrouhli cislo na dve desetinna mista
    // Prakticky priklad: Parametrem predam cislo 157.22685
    private double zaokrouhli(double num)
    {
        // Vynasobim hodnotu 100 a prevedu na integer ktery desetinna mista nepodporuje -> 15722
        int pom = (int) (num * 100);
        // Ted vydelim 100 a prevedu opet na double ktery desetinna mista podporuje -> 157.22
        double ret = ((double) pom) / 100;
        // A tuto hodnotu vratim
        return ret;
    }
    
    // Vygeneruje nahodne cele cislo z rozsahu.
    private int randomIntFromRange(int min, int max)
    {
        return (int) (Math.random() * (max-min + 1)) + min;
    } 
    
    // Vygeneruje nahodne cislo s desetinnymi misty z rozsahu.
    private double randomDoubleFromRange(double min, double max)
    {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
}
