import java.util.Scanner;

import numero.*;
public class EP1OCD {
	
	private static int[] stringToIntArray(String str) {
		int[] retorno = new int[str.length()];
		for(int i = 0; i < str.length(); ++i) {
			if(str.charAt((str.length())- 1 - i) != '0' && str.charAt((str.length())- 1 - i) != '1')
				return null;
			else
				retorno[i] = str.charAt((str.length())- 1 - i) == '0' ? 0 : 1;
		}
		return retorno;
	}
	
	private static void chamaInteiro() {
		Inteiro[] ints = new Inteiro[2];
		String[] priSeg = {"primeiro", "segundo"};
		int numBits = 0;
		int inteiro[] = {};
		boolean sinal = false;
		char sign = '\0';
		char operacao = '\0';
		Scanner kbd = new Scanner(System.in);
		for(int i = 0; i < ints.length; ++i) {
			System.out.println("Insira a quantidade de bits do " + priSeg[i] + " numero: ");
			numBits = kbd.nextInt();
			System.out.println("Insira o número em binário: ");
			inteiro = stringToIntArray(kbd.next());
			while (true) {
				System.out.println("O inteiro possui sinal? [S/N] ");
				sign = kbd.next().charAt(0);
				if(sign == 'S' || sign == 's') {
					sinal = true;
					break;
				}
				else if (sign == 'N' || sign == 'n') {
					sinal = false;
					break;
				}
			}
			ints[i] = new Inteiro(numBits, inteiro, sinal);
		}
		
		System.out.println("Insira o tipo de operação '+', '-', '*' ou '/': ");
		operacao = kbd.next().charAt(0);
		kbd.close();
		
		if(operacao == '+') {
			Inteiro soma = Inteiro.soma(ints[0], ints[1]);
			soma.print();
		}
		if(operacao == '-') {
			Inteiro subtracao = Inteiro.subtracao(ints[0], ints[1]);
			subtracao.print();
		}
		if(operacao == '*') {
			Inteiro multiplicacao = Inteiro.multiplicacao(ints[0], ints[1]);
			multiplicacao.print();
		}
		if(operacao == '/') {
			Inteiro divisao = Inteiro.divisao(ints[0], ints[1]);
			divisao.print();
		}
	}
	private static void chamaFlutuante() {
		
	}
	
	
	public static void main (String[] args){
		System.out.println("Insira o caractere do tipo de operação (sem aspas): 'F' para ponto flutuante e 'I' para inteiros");
		Scanner stdin = new Scanner(System.in);
		char tipo = stdin.next().charAt(0);

		if(tipo == 'F' || tipo == 'f') {
			chamaFlutuante();			
		}
		if(tipo == 'I' || tipo == 'i') {
			chamaInteiro();
		}
		stdin.close();
	}
}
