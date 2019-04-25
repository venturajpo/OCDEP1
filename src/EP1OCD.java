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
		int[][] ints = new int[2][];
		String[] priSeg = {"primeiro", "segundo"};
		int inteiro[] = {};
		char operacao = '\0';
		Scanner kbd = new Scanner(System.in);
		for(int i = 0; i < ints.length; ++i) {
			System.out.println("Insira o " + priSeg[i] + " número em binário: ");
			inteiro = stringToIntArray(kbd.next());
			ints[i] = new int[inteiro.length];
		}
		do {
			System.out.println("Insira o tipo de operação '+', '-', '*' ou '/': ");
			operacao = kbd.next().charAt(0);
		}
		while(operacao != '+' && operacao != '-' && operacao != '*' && operacao != '/');
		kbd.close();
		//Inteiro.igualar(ints[0], ints[1]);
		inteiro = null;
		if(operacao == '+') {
			inteiro = Inteiro.soma(ints[0], ints[1]);
		}
		if(operacao == '-') {
			inteiro = Inteiro.subtracao(ints[0], ints[1]);
		}
		if(operacao == '*') {
			inteiro = Inteiro.multiplicacao(ints[0], ints[1]);
		}
		if(operacao == '/') {
			inteiro = Inteiro.divisao(ints[0], ints[1]);
		}
		
		Inteiro.print(inteiro);
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
