package zapoctovytest;

import java.util.Scanner;

public class ZapoctovyTest
{

    public static void main(String[] args)
    {
        Ucet u1 = new Ucet();
        Ucet u2 = new Ucet();
        
        
        Scanner s = new Scanner(System.in);
        System.out.println("Zadejte pocet vyberu pro prvni ucet: ");
        u1.generujVybery(s.nextInt());
        System.out.println("Zadejte pocet vyberu pro druhy ucet: ");
        u2.generujVybery(s.nextInt());       
        
        System.out.println("Vypisuji ucet jedna");
        u1.vypisVybery();
        System.out.println("PRUMER: " + u1.dejPrumernyVyber());
        System.out.println("Vypisuji ucet dva");
        u2.vypisVybery();
        System.out.println("PRUMER: " + u2.dejPrumernyVyber());                
        System.out.println("Nyni tridim zaznamy o vyberech...");
        u1.setridVyberyVzestupne();
        u2.setridVyberyVzestupne();
        System.out.println("Vypisuji ucet jedna");
        u1.vypisVybery();
        System.out.println("PRUMER: " + u1.dejPrumernyVyber());
        System.out.println("Vypisuji ucet dva");
        u2.vypisVybery();
        System.out.println("PRUMER: " + u2.dejPrumernyVyber());                     
    }  
}
