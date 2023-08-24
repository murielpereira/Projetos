#include <iostream>
#include <stdlib.h>
#include <locale>

using namespace std;

float nota[4];
float media, soma = 0;
int numero, contador = 0, escolha, escolha2, multiplicador = 0;


int main()
{
	cout << "O que voce deseja fazer?\n";
	cout << "1 - Tabuada\n";
	cout << "2 - Calculo de Medias\n";
	cin >> escolha2;
	system("cls");

	if (escolha2 == 1)
	{

		/* Inicio Tabuada */
		do {
			cout << "Qual tabuada voce quer saber? \n";
			"\n";
			cin >> numero;
			"\n";
			system("cls");
			cout << "Ate que numero voce quer multiplicar? \n";
			cin >> multiplicador;
			system("cls");
			cout << "Segue a tabuada do " << numero << "\n";

			for (contador = 0; contador <= multiplicador; contador++) {
				cout << numero << " x " << contador << " = " << numero * contador << "\n";
			}

			cout << "Digite 1 para recomecar ou qualquer outra tecla para sair \n";
			cin >> escolha;
			system("cls");
		} while (escolha == 1);

		/* Fim Tabuada */
	}

	else 
	{

		/* Inicio Media */

		for (int i = 0; i <= 4; i++)
		{
			cout << "Digite a nota numero " << (i + 1) << ": " "\n";
			cin >> nota[i];
			soma = soma + nota[i];
			system("cls");
		}

		media = soma / 5;

		cout << "A media do aluno foi: " << media;

		/* Fim Media */
	}
}
	
