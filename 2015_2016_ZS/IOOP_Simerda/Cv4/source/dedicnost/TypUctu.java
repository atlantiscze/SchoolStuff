package dedicnost;

public enum TypUctu
{
    BEZNY_UCET(1),
    TERMINOVANY_UCET(2),
    SPORICI_UCET(3);
    
    int typ;
    
    TypUctu(int t)
    {
        typ = t;
    }
}
