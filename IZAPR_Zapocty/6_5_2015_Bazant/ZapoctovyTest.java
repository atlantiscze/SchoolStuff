package zapoctovytest;

public class ZapoctovyTest
{
    public static void main(String[] args)
    {
        // Konfigurace, ovlivni minimum a maximum jizd ktere vygenerujeme pro kazde auto.
        final int POCET_JIZD_MIN = 3;
        final int POCET_JIZD_MAX = 15;
        
        // Vytvorime dve auta, konstruktorem predame cislo v rozsahu definovanem v predchozim kroku
        Auto a1 = new Auto(randomIntFromRange(POCET_JIZD_MIN, POCET_JIZD_MAX));
        Auto a2 = new Auto(randomIntFromRange(POCET_JIZD_MIN, POCET_JIZD_MAX));        
        
        
        // A ted pouze vypiseme ruzne informace o obou autech.
        System.out.println("UVEDENA CISLA JSOU ZAOKROUHLENA");
        System.out.println("PRUMERNA VZDALENOST JIZDY:");
        System.out.println("A1 - " + a1.dejPrumernouVzdalenostJizdy());
        System.out.println("A2 - " + a2.dejPrumernouVzdalenostJizdy());
        System.out.println("CELKOVA UJETA VZDALENOST:");
        System.out.println("A1 - " + a1.dejCelkovouUjetouVzdalenost());
        System.out.println("A2 - " + a2.dejCelkovouUjetouVzdalenost());    
        System.out.println("CELKOVA SPOTREBA PALIVA:");
        System.out.println("A1 - " + a1.dejCelkovouSpotrebuPaliva());
        System.out.println("A2 - " + a2.dejCelkovouSpotrebuPaliva());  
        System.out.println("POCET JIZD CELKEM:");
        System.out.println("A1 - " + a1.pocet_zaznamu);
        System.out.println("A2 - " + a2.pocet_zaznamu);     
    
    }
    
    // Vygeneruje nahodne cele cislo z rozsahu.
    public static int randomIntFromRange(int min, int max)
    {
        return (int) (Math.random() * (max-min + 1)) + min;
    }
}
