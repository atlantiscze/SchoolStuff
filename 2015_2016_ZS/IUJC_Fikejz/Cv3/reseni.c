#include <stdio.h>

#define KONST_N 5 							// Definice konstanty "KONST_N" pro pouziti v prikladu 2.

void priklad_jedna()
{
	printf("========== PRIKLAD 1 ==========\n");
	int a, b, *p_a, *p_b; 					// Vytvorime si promenne a b typu int a promenne *p_a *p_b typu pointer.
											// Pointer(ukazatel) je narozdil od klasicke promenne odkaz na misto v pameti. Celkove je problematika pointeru
											// dost komplikovana a spatne se takto popisuje, doporucuji alespon precist ve STAGu prednasku 3 pokud pointery neznate.
											
	p_a = &a;								// Pomoci znaku "&" znacim ze chci pointer na promennou a, narozdil od promenne a.
	p_b = &b;								// Stejnym zpusobem ziskam pointer na promennou b.
	printf("Zadejte promennou A: ");
	scanf("%d", p_a);						// Nacteme hodnoty do promennych. Jelikoz jsme si na predchozim radku ziskali pointery na tyto promenne predame je primo,
	printf("Zadejte promennou B: ");
	scanf("%d", p_b);						// nemusime tedy pouzivat scanf("%d", &a).
	
	printf("Promenna A. Adresa: %p    Hodnota: %d    Adresa pointeru: %p\n", p_a, *p_a, &p_a);	// Vypiseme informace o promennych. Operator * ziska obsah promenne na kterou 
	printf("Promenna B. Adresa: %p    Hodnota: %d    Adresa pointeru: %p\n", p_b, *p_b, &p_b);	// ukazuje pointer. Operator & ziska adresu pointeru samotneho.
	printf("Soucet A + B = %d\n", (*p_a + *p_b));	// Nakonec vypiseme soucet. Pomoci operatoru "*" ziskame obsah obou promennych a secteme je.
	
	printf("========== KONEC PRIKLADU 1 ==========\n");
}

void priklad_dva()
{
	printf("========== PRIKLAD 2 ==========\n");
	
	int pole[KONST_N - 1];					// Vytvorime si pole o velikosti N. Vzhledem k indexaci 
	for(int i = 0; i < KONST_N; i++)
	{
		printf("pole[%d] = ", i);
		scanf("%d", &pole[i]);				// Nacteme cislo od uzivatele.
		// pole[i] = nejaka_funkce_na_nahodne_cislo()  // Alternativa
	}
	
	int *max, *min;							// Pointery max a min ktere budou ukazovat na nejvetsi a nejmensi hodnotu v poli.
	max = &pole[0];							// Musime zacit s nejakymi hodnotami. Vememe hodnoty z prvniho indexu pole.
	min = &pole[0];
	// Budeme trochu setrit, nasledujici cyklus vypise cele pole. Zaroven ale budeme hledat nejvetsi a nejmensi cisla.
	for(int i = 0; i < KONST_N; i++)
	{
		printf("pole[%d] = %d     ", i, pole[i]);	// Vypiseme co je na danem indexu pole.
		if(*max < pole[i])							// Pointer max ukazuje na mensi cislo nez je na pole[i]...
		{
			max = &pole[i];							// ... nastavime tedy pointer max na tento index pole.
		}
		if(*min > pole[i])							// Zde delame totez ale s promennou min a s nejmensi hodnotou v poli.
		{
			min = &pole[i];
		}
	}
	printf("\n\nMIN = %d   je na pole[%d]\n", *min, (min - &pole[0]));	// Vypiseme vse uzivateli. Zaroven zjistime na ktery index pole ukazuje pointer. To zjistime
	printf("MAX = %d   je na pole[%d]\n", *max, (max - &pole[0]));		// odectenim adresy prvniho indexu pole od pointeru min/max. (min - &pole[0]).
	
	printf("========== KONEC PRIKLADU 2 ==========\n");
}


int main()
{
	priklad_jedna();
	priklad_dva();
	system("pause");
}
