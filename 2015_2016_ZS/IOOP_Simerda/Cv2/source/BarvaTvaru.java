package Lekce02;

import java.awt.Color;

// Enum barev. Pouzijeme nektere barvy ze tridy Color.
public enum BarvaTvaru
{
    BILA(Color.WHITE),          // Zde jsou konkretni barvy a jejich cesky ekvivalent.
    CERNA(Color.BLACK),
    CERVENA(Color.RED),
    MODRA(Color.BLUE),
    ZELENA(Color.GREEN);
    
    private final Color barva;
    
    BarvaTvaru(Color c)         // Jelikoz si potrebujeme pamatovat barvu typu Color mame ji zde v konstruktoru.
    {
        barva = c;
    }
    
    @Override
    public String toString()    // Prepiseme nas toString() tak aby volal toString() na nasi barve typu Color.
    {
        return barva.toString();
    }
}
