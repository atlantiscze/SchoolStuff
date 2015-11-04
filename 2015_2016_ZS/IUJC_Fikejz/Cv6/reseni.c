# include <math.h>
# include <string.h>
# include <stdio.h>
# include <stdlib.h>

// Priklad 1
int soucetCisel(int n)			// Parametrem n je predano cislo od ktereho scitame. Pokud to bude treba 5 tak vratime (5 + 4 + 3 + 2 + 1) atd.
{
	int vysledek = 0;			// Tuto promennou nakonec vratime.
	while (n > 0)				// Dokud je n nenulova hodnota budeme pocitat.
	{
		vysledek += n;			// V kazdem cyklu pricteme hodnotu n k promenne vysledek. Nasledne snizime promennou n o 1.
		n--;					// Nakonec se dostaneme na hodnotu n = 0 a cyklus skonci.
	}
	return vysledek;			// Vratime vypocitanou hodnotu.
}

// Priklad 2
int KvadrRov(int a, int b, int c, float body[])		// Pro matematicke antitalenty jako jsem i ja popisuji take metodu vypoctu
{
	double D = b*b - 4 * a * c;				// Nejprve vypocitame determinant...
	double q = sqrt(D);						// A odmocninu z determinantu...
	if (D >= 0)								// Determinant vetsi nebo roven nule znamena ze muzeme vypocitat koreny kv. rovnice.
	{
		body[0] = (-b + q) / 2 * a;			// Jako parametr jsme dostali pole vytvorene v metode main. Jelikoz pole jiz existuje muzeme do nej zapisovat a zmeny budou
		body[1] = (-b - q) / 2 * a;			// "videt" i z metody main. Zapiseme tedy oba koreny do pole.
		return 1;							// Vratime hodnotu 1 coz znamena ze jsme nasli vysledek.
	}
	else
	{
		return 0;							// V opacnem pripade vratime 0 coz znamena ze nelze nalezt reseni.
	}
}

// Priklad 2 (alternativni s pointery)
int KvadrRov2(int a, int b, int c, float *xx1, float *xx2)
{
	double D = b*b - 4 * a*c;
	double q = sqrt(D);
	if (D >= 0)
	{
		*xx1 = (-b + q) / 2 * a;			// Jediny rozdil je zde. Nepouzijeme pole ale dva pointery. Tyto pointery ukazuji na promenne vytvorene v metode main.
		*xx2 = (-b - q) / 2 * a;			// My je muzeme pouzit a zmenit tak hodnotu techto promennych aniz by jsme je vraceli pomoci prikazu return.
		return 1;
	}
	else
	{
		return 0;
	}
}

// Priklad 3
int CetnostZn(char str[], char znak)
{
	int len = strlen(str);					// Zjistime si delku stringu (pole char-u) str ktery jsme dostali jako parametr.
	int found = 0;							// Pomocna promenna do ktere si budeme ukladat kolikrat jsme dany znak nasli.
	for (int i = 0; i < len; i++)			// Projdeme cele pole charu (string), po jednotlivych pismenech (char-ech)
	{
		if (str[i] == znak)					// Pokud se pismeno shoduje s hledanym pismenem ...
		{
			found++;						// ... zvysime pomocnou promennou o 1.
		}
	}
	return found;							// Nakonec vratime pocet nalezenych hodnot.
}



// Tyto procedury jsou volane z mainu. V zadani se sice pise ze hlavni program nacte hodnoty, ale psat vse do mainu je dost neprehledne,
// proto jsem tuto cast zadani trochu preskocil. Pokud to chcete mit v mainu staci obsah techto tri procedur vratit do mainu.
// Tyto procedury se hlavne staraji o vstup/vystup. Nedaval jsem tam moc komentaru, pokud jste prosli predchozi cviceni tak by vetsina veci mela byt jasna.
void priklad_jedna()
{
	printf("========== PRIKLAD 1 ==========\n");
	int n;
	printf("Zadejte cislo pro priklad 1: ");
	scanf("%i", &n);
	printf("Soucet cisel je: %d \n", soucetCisel(n));
	printf("========== KONEC PRIKLADU 1 ==========\n");
}

void priklad_dva()
{
	printf("========== PRIKLAD 2 ==========\n");
	printf("Zadani cisel pro priklad 2.\n");
	printf("A = ");
	int a, b, c;
	scanf("%i", &a);
	printf("B = ");
	scanf("%i", &b);
	printf("C = ");
	scanf("%i", &c);
	float vysledek[2];
	float x1, x2;
	if (KvadrRov(a, b, c, vysledek))						// Zde akorat zminim rozdil mezi pouzitim pole a pointeru. Toto je verze s polem.
	{
		printf("Koreny(funkce s polem): %f  %f\n", vysledek[0], vysledek[1]);
	}
	else
	{
		printf("Nelze vypocitat (funkce s polem)\n");
	}

	if (KvadrRov2(a, b, c, &x1, &x2))						// A toto verze s pointery.
	{
		printf("Koreny(funkce s pointery): %f  %f\n", x1, x2);
	}
	else
	{
		printf("Nelze vypocitat (funkce s pointery)\n");
	}
	printf("========== KONEC PRIKLADU 2 ==========\n");
}

void priklad_tri()
{
	printf("========== PRIKLAD 3 ==========\n");
	char znak;
	char str1[100];
	printf("Zadejte text pro priklad 3: ");
	gets(str1);
	printf("Zadejte pismeno pro hledani v textu: ");
	scanf("%c", &znak);
	printf("Pismeno nalezeno %dx\n", CetnostZn(str1, znak));
	printf("========== KONEC PRIKLADU 3 ==========\n");
}

int main()
{
	priklad_jedna();
	fflush(stdin);			// Jak jsem psal jiz v minulem cviceni, toto vycisti buffer vstupu. Pokud to nepouzijeme mohou v nem zustat nejake znaky coz muze delat
	priklad_dva();			// neporadek v dalsim cteni vstupu od uzivatele.
	fflush(stdin);
	priklad_tri();
	
	system("pause");
}