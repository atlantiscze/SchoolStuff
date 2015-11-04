package bankomat;

public class Bankomat
{
    private int zustatek;                       // Zustatek na uctu v tomto bankomatu.
    
    public int getPenize(double castka)         // Jednoduche gettery a settery. Zavolanim getteru vybirame penize.
    {
        if(zustatek >= castka)                  // Nemuzeme ovsem jit do minusu.
        {
            zustatek -= castka;                 // Pokud muzeme odecteme pozadovanou castku.
        }
        return zustatek;                        // V zadani je pozadovano aby jsme vratili zustatek. Osobne bych vracel true/false zda slo vyber provest ale zadani je zadani.
    }
    
    public void setPenize(int castka)           // Setterem vkladame penize.
    {
        if(castka > 0)                          // Nemuzeme ovsem vlozit zaporne hodnoty
        {
            zustatek += castka;                 // Vlozime tedy pouze pokud je hodnota kladna.
        }
    }
}