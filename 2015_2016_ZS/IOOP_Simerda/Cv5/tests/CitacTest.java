package Lekce05;

import org.junit.Test;

public class CitacTest
{
    
// Z nejakeho duvodu nefunguje, a pretezuje procesor (zere cele jadro), nejspis nekonecna smycka do-while.
//    @Test(timeout = 10000)
//    public void testMujTimer()
//    {
//        int c = 0;
//        int citac = 0;
//        Citac1 timer = new Citac1(1000);
//        do
//        {
//            c = timer.getCitac();
//            if(citac != c)
//            {
//                System.out.println("Citac = " + c);
//                citac = c;
//            }
//        } while (c < 10);
//    }    
    
    
    @Test(timeout = 20000)                                  // Prepsano na 20s protoze 10 nestacilo (je to o par milisekund vice)
    public void testMujTimerAlt() throws InterruptedException
    {
        int c;
        int citac = 0;
        Citac1 timer = new Citac1(1000);                    // Vytvorime si citac a nastavime mu 1000ms (1 vterina) interval
        System.out.println("Test Started");
        while(true)                                         // Nekonecna smycka, pobezi dokud v ni nezavolame return.
        {
            Thread.sleep(100);                              // Bez tohoto se roztavi procesor jelikoz to je v nekonecne smycce. Takhle to ma zanedbatelnou zatez
            c = timer.getCitac();                           // Predchozi prikaz nam program "zmrazi" na 100ms (0.1 vteriny). Nyni si nacteme hodnotu citace
            if(citac != c)                                  // Zmenila-li se hodnota citace vypiseme uzivateli novou hodnotu
            {
                System.out.println("Citac = " + c);
                citac = c;  
                if(citac >= 10)                             // Je-li citac vetsi nebo roven 10 tak koncime. Zavolame return.
                {
                    System.out.println("Test Ended");
                    return;
                }
            } 
        }  
    }
}
