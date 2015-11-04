#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

void priklad_jedna()
{
	printf("========== PRIKLAD 1 ==========\n");
	char str[50];						// Stringy v C jsou reprezentovany polem znaku. Takto vytvorim string o urcite velikosti (max. delce)
	printf("Zadejte text: ");			// V komentarich budu casto pouzivat oznaceni string, cimz je mysleno takoveto pole znaku.
	gets(str);							// gets(str) nacte znaky ze vstupu do promenne str.
	int delka = strlen(str);			// strlen() nam zjisti delku stringu str. Neznaci kapacitu ale skutecnou vyuzitou delku.
	for (int i = 2; i < delka; i += 3)	// Kazdy treti znak nahradime hvezdickou. Zacneme na indexu 2 a postupujeme po 3 znacich.
	{
		str[i] = '*';
	}
	puts(str);							// Nakonec vypiseme "vylepseny" string s hvezdickami.
	printf("========== KONEC PRIKLADU 1 ==========\n");
}

void priklad_dva()
{
	printf("========== PRIKLAD 2 ==========\n");
	char str1[50], str2[50], str3[50], zn;			// Vytvorime stringy. Zamerne vyuzivam vetsi hodnoty, hodnota 20 se da snadno prekrocit coz by zpusobilo 
	char *ukStr = NULL;								// overflow (preteceni) coz je nezadouci.
	int porovnej = 0;								// Pomocna promenna kterou pouzijeme pro porovnani stringu
	printf("Zadejte STR1: ");						// Nacteme data od uzivatele
	gets(str1);
	printf("Zadejte STR2: ");
	gets(str2);
	printf("STR1= %d  STR2= %d\n", strlen(str1), strlen(str2));		// Vypiseme delky zadanych stringu
	*strcpy(str3, str2);							// Zkopirujeme str2 do str3
	*strcat(str1, str3);							// Na konec stringu str1 "prilepi" string str3
	printf("STR1+3= ");
	puts(str1);										// Vypiseme spojene stringy str1 a str3

	printf("Zadejte ZN: ");
	zn = getchar();									// Ziskame od uzivatele jeden znak.
	for (int i = 0; i < strlen(str1); i++)			// Nyni projdeme cely string po jednotlivych pismenech a budeme hledat zadany znak.
	{
		if (str1[i] == zn)							// Zadany znak se shoduje s pismenem na tomto indexu.
		{
			ukStr = &str1[i];						// Ulozime si na nej pointer (ukazatel) a vyskocime z for cyklu pomoci prikazu break.
			break;
		}
	}
	if (ukStr == NULL)								// Pointer ukStr je null, coz znamena ze jsme ho nenastavili v predchozim cyklu, protoze jsme pismeno nenasli.
	{
		printf("Hledany znak nebyl nalezen.");
	}
	else											// V opacnem pripade obsahuje ukazatel na index ve kterem se nachazi hledane pismeno.
	{
		printf("Hledany znak je na indexu %d.\n", ukStr - &str1[0]);	// Hodnotu indexu ziskame odectenim pointeru na prvni index celeho stringu od nalezeneho pointeru.
	}

	porovnej = between(-1, strcmp(str1, str2), 1);		// Pomoci strcmp() porovname stringy. Nize jsem vytvoril funkci between() ktera omezi vysledek na rozsah 1 az -1
	switch (porovnej)
	{
	case 0:
		printf("STR1 = STR2\n");
		break;
	case 1:
		printf("STR1 > STR2\n");
		break;
	case -1:
		printf("STR1 < STR2\n");
		break;
	}
	printf("========== KONEC PRIKLADU 2 ==========\n");
}

void priklad_tri()
{
	printf("========== PRIKLAD 3 ==========\n"); 
	char str1[100];									// Do tohoto pole nacteme vstup od uzivatele.
	char vzor[6] = {'a','e','i','o','u','y'};		// Hledame samohlasky, ty jsou vypsane zde. Toto pole je propojeno s nasledujicim polem. Pismeno vzor[n] jsme nasli
	int vzorCetnost[6] = {0,0,0,0,0,0};				// tolikrat kolik je hodnota v poli vzorCetnost[n]
	gets(str1);										// Ziskame od uzivatele vstup.
	for (int i = 0; i < strlen(str1); i++)			// Nyni projdeme cely string ktery uzivatel zadal, pismeno po pismenu.
	{
		str1[i] = tolower(str1[i]);					// Osetreni velkych/malych pismen. Z velkych pismen udelame mala.
		
		for(int j = 0; j < strlen(vzor); j++)		// Nyni projdeme pole vzor (cyklus v cyklu) a budeme porovnavat zda je pismeno jedna ze samohlasek.
		{
			if(str1[i] == vzor[j])					// Pismeno se shoduje s nejakou samohlaskou. Zvysime odpovidajici hodnotu v poli vzorCetnost o 1.
			{
				vzorCetnost[j]++;
			}
		}
	}
	
	for (int i = 0; i < strlen(vzor); i++)			// Nyni vypiseme seznam nalezenych samohlasek.
	{
		printf("%c existuje %dx\n", vzor[i], vzorCetnost[i]);
	}
	printf("========== KONEC PRIKLADU 3 ==========\n");
}

// Mala pomocna funkce. Oseka hodnotu mid do rozsahu min az max.
int between(int min, int mid, int max)
{
	if(mid > max)
	{
		mid = max;
	}
	if(mid < min)
	{
		mid = min;
	}
	
	return mid;
}

int main()
{
	priklad_jedna();
	fflush(stdin);			// Mezi jednotlivymi priklady vycistime buffer vstupu. Pokud to neudelame muzou nam v nem zustat nejake znaky ktere nechceme
	priklad_dva();			// coz muze pekne rozbit cteni vstupu od uzivatele.
	fflush(stdin);
	priklad_tri();

	system("pause");
}