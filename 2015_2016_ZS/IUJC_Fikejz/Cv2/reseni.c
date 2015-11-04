#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

// PRIKLAD 1
void priklad_jedna(int pocet_cisel)
{
	int nuly = 0;
	int kladna = 0;
	int zaporna = 0;
	int mala = 0; 								// 0-100
	int velka = 0; 								//101 - 1000
	int random_number;
	for (size_t i = 0; i < pocet_cisel; i++)	// Cyklus se znamym poctem opakovani. Nasledujici kod provedeme pocet_cisel-krat
	{
		random_number = randomInt(2001) - 1000;	// Nejprve si vygenerujeme nahodne cislo v rozsahu -1000 az 1000. Pomuzeme si funkci randomInt ktera je dale v tomto souboru
		if (random_number > 0)					// Vygenerovane cislo je kladne
		{
			kladna++;
			if (random_number > 100)
			{
				velka++;
			}
			else
			{
				mala++;
			}
		}
		else if (random_number < 0)				// Vygenerovane cislo je zaporne
		{
			zaporna++;
		}
		else									// Vygenerovane cislo je nula
		{
			nuly++;
		}
	}
	int check = nuly + kladna + zaporna;		// Kontrolni soucet poctu vsech vygenerovanych cisel.


	printf("===== PRIKLAD 1 =====\n");			// Nasleduje vypsani hodnot uzivateli pomoci funkce printf().
	printf("Vygenerovano cisel: %d\n", pocet_cisel);
	printf("Kladna: %d  Zaporna: %d  Nuly: %d\n", kladna, zaporna, nuly);
	printf("Kontrolni soucet: %d\n", check);
	printf("1-100: %d  101-1000: %d\n", mala, velka);
	printf("===== KONEC PRIKLADU 1 =====\n");
}


// PRIKLAD 2
void priklad_dva(int strana_trojuhelniku)
{
	int a, b, c;								// Jednotlive strany trojuhelniku.
	bool repeat = true;							// Promena bool (true/false). Jeji pouziti zavisi na "#include <stdbool.h>" na zacatku souboru
	printf("===== PRIKLAD 2 =====\n");
	while (repeat)								// Budeme zkouset generovat trojuhelnik dokud nevytvorime takovy ktery muze existovat.
	{
		repeat = false;							// Nejprve nastavime promennou repeat na false. Pokud tak zustane do konce cyklu cyklus se prerusi.
		a = randomInt(strana_trojuhelniku);		// Nasledne vygenerujeme jednotlive strany trojuhelniku.
		b = randomInt(strana_trojuhelniku);
		c = randomInt(strana_trojuhelniku);
		if (((a + b) < c) || ((a + c) < b) || ((b + c) < a))	// Kontrola zda trojuhelnik muze existovat. Soucet dvou stran musi byt vetsi nez strana treti.
		{
			repeat = true;						// Trojuhelnik nevyhovuje. Nastavime promennou repeat zpet na true a tim padem budeme generovat trojuhelnik znovu.
		}
		// Vypiseme informaci o trojuhelniku. Je zde pouzit ternarni operator (podminka ? neco : neco) pro vypsani vyhovuje/nevyhovuje.
		printf("Trojuhelnik a=%d b=%d c=%d   - %s\n", a, b, c, (repeat == true) ? "NEVYHOVUJE" : "VYHOVUJE");
		// Konec tohoto cyklu. Pokud bylo repeat nastaveno zpet na true budeme vse opakovat. Pokud ne tak cyklus konci.
	}
	printf("===== KONEC PRIKLADU 2 =====\n");
}

// PRIKLAD 3
void priklad_tri(int max_cislo)
{
	printf("===== PRIKLAD 3 =====\n");
	int error_count = 0;						// Pocet chyb.
	int random_number = randomInt(max_cislo);	// Nahodne generovane cislo ktere uzivatel hada.
	int player_tip;								// Do teto promenne si ulozime tip uzivatele.
	bool gameover = false;						// Pokud uzivatel tipne cislo spravne nastavime tuto promennou na true a tim prerusime cyklus.
	while (!gameover)							// Cyklus pobezi dokud bude promenna gameover false.
	{
		printf("Zadejte svuj tip. Hledane cislo je mezi 0 a %d:", max_cislo);
		scanf("%d", &player_tip);				// Nacteme tip od uzivatele.
		if (player_tip == random_number)		// Uzivatel uhodl spravne cislo
		{
			printf("Tipovane cislo je spravne. Celkem jste udelal/a %d chyb.\n", error_count);	// Pred koncem oznamime uzivateli pocet chyb.
			gameover = true;					// Nastavenim teto promenne prerusime cyklus.
		}
		else if (player_tip > random_number)	// Tipovane cislo bylo vetsi nez hledane cislo.
		{
			printf("Bohuzel hledane cislo je mensi nez vami zadane cislo.\n");
			error_count++;						// Jelikoz uzivatel cislo neuhadl zvedneme pocet chyb o 1.
		}
		else									// Tipovane cislo bylo mensi nez hledane cislo.
		{
			printf("Bohuzel hledane cislo je vetsi nez vami zadane cislo.\n");
			error_count++;						// Jelikoz uzivatel cislo neuhadl zvedneme pocet chyb o 1.
		}
	}
	printf("===== KONEC PRIKLADU 3 =====\n");
}

// POMOCNA FUNKCE
// Tato pomocna funkce vraci integer v rozsahu 0-max kde max je predano jako parametr.
// Jelikoz v tomto cviceni bylo casto potreba generovat nahodna cisla, je vyhodnejsi to mit jako funkci ktera se lepe pamatuje a upravuje.
int randomInt(int max)
{
	return (rand() % (max));
}

// Metoda main()
// Tato metoda se zavola pri spusteni programu. Postupne zavola priklady 1 2 a 3.
// Parametrem jim predava odpovidajici cisla. Tyto cisla muzete menit.
// Zaroven je mozne tato cisla nacitat od uzivatele pomoci    scanf("%d", &promenna_do_ktere_nacteme_cislo);    ale to zde neni.
int main()
{
	srand(time(NULL));							// Spusti generator nahodnych cisel ze systemoveho casu. Pro kazde spusteni programu dostaneme jinou sadu cisel.
												// Tento radek neni nutny ale jeho absence muze zpusobit ze budeme dostavat stejna cisla pri kazdem spusteni programu.
	priklad_jedna(1000);
	priklad_dva(100);
	priklad_tri(20);

	system("pause");							// Prikaz pro windows ktery zpusobi ze program pocka na stisknuti klavesy.
}