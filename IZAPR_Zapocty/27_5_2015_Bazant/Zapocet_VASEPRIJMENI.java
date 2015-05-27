package zapocet_vaseprijmeni;
/*
          /\
         /  \
        / !! \
       /______\
Pro pripadne odevzdani musite upravit jmeno, do Zapocet_VASEPRIJMENI doplnte prijmeni.
Lze to udelat rightclickem na "public class Zapocet_VASEPRIJMENI" tady dole.
Vyberte moznost "Refactor" a pak "Rename". Tim se vse spravne prejmenuje.
Dale je nutne prepsat i package, to je to tady nad touhle poznamkou. Zase pouzijte refactor (idealne).

*/


public class Zapocet_VASEPRIJMENI
{
    public static void main(String[] args)
    {
        // A jdeme testovat. Udelame si dve matice, ctvercovou a obdelnikovou
        Matice mc = new Matice(5,5);
        Matice mo = new Matice(10,5);
        // Vygenerujeme nejake hodnoty
        mc.generateValues(0.0, 50.0);
        mo.generateValues(0.0, 50.0);
        // Vypiseme matice pres nas upraveny toString()
        System.out.println(mc.toString());
        System.out.println(mo.toString());
        // Vypiseme diagonaly
        System.out.println(java.util.Arrays.toString(mc.getDiagonal()));
        System.out.println(java.util.Arrays.toString(mo.getDiagonal()));
        // Zavolame soucty radku
        mc.sumColumns(1, 4);
        mo.sumColumns(4, 7);
        // Setridime nejake radky (5. radek, posledni odspodu)
        mc.sortRowBubble(4);
        mo.sortRowBubble(4);
        // A nakonec opet vypiseme matice pres nas upraveny toString()
        System.out.println(mc.toString());
        System.out.println(mo.toString());
    }
    
}
