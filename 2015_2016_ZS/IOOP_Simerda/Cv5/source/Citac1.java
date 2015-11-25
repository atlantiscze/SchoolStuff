package Lekce05;

import java.util.*;

public class Citac1
{
    int citac = 0;                                  // Hodnota kterou si citac v sobe pamatuje
    
    public Citac1(int delay)                        // Konstruktor ktery zaroven spusti cely cyklus citace
    {
        Timer timer = new Timer();                  // Nejprve vytvorime novy Timer
        
        timer.scheduleAtFixedRate(new TimerTask()   // A nyni do timeru pridame anonymni tridu TimerTask.
        {
            @Override
            public void run()                       // V teto anonymni tride prepiseme metodu run() na to co chceme provadet.
            {
                setCitac(getCitac() + 1);           // V nasem pripade to je zvyseni citace o 1.
            }        
        }, delay, delay);                           // Ukoncime deklaraci anonymni tridy pomoci "}". Jako dalsi dva parametry predame delay.
        
    }
    
    public int getCitac()
    {
        return this.citac;
    }
    
    private void setCitac(int c)
    {
        this.citac = c;
    }
    
    @Override
    public String toString()
    {
        return "Timer: " + this.citac;
    }
    

    
}
