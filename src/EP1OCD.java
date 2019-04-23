import java.util.Scanner;

import numero.*;
public class EP1OCD {
	
	private static int[] stringToIntArray(String str) {
		
		return null;
	}
	
	private static void chamaInteiro() {
		Inteiro[] ints = new Inteiro[2];
		String[] priSeg = {"primeiro", "segundo"};
		int numBits = 0;
		int inteiro[] = {};
		boolean sinal = false;
		char sign = '\0';
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
		kbd.close();
		
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
