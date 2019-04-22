import java.util.Scanner;

import numero.*;
public class EP1OCD {
	
	private static boolean[] stringToBooleanArray(String str) {
		
		return null;
	}
	
	
	public static void main (String[] args){
		System.out.println("Insira o caractere do tipo de operação (sem aspas): 'F' para ponto flutuante e 'I' para inteiros");
		Scanner stdin = new Scanner(System.in);
		stdin.close();
		char entrada = stdin.next().charAt(0);
		
		char tipo = entrada;
		Numero numeroA = new Inteiro();
		Numero numeroB = new Inteiro();
		boolean sinal = false;
		
		
		System.out.println("Entre com o Sinal do primeiro numero (0 ou + para positivo, 1 ou - para negativo)");
		
		entrada = stdin.next().charAt(0);
		stdin.close();
		
		if(entrada == '0' || entrada == '+')
			sinal = false;
		if(entrada == '1' || entrada == '-')
			sinal = true;	
		
		if(tipo == 'F' || tipo == 'f') {
			System.out.println("Insira o expoente do primeiro numero");
			String expoente = stdin.next();
			stdin.close();
			boolean[] exp = stringToBooleanArray(expoente);
			
			System.out.println("Insira a Mantissa do primeiro numero");
			String mantissa = stdin.next();
			stdin.close();
			boolean[] mant = stringToBooleanArray(mantissa);
			
			numeroA = new Flutuante(sinal, exp, mant);stdin.close();
			
			System.out.println("Entre com o Sinal do segundo numero (0 ou + para positivo, 1 ou - para negativo)");
			entrada = stdin.next().charAt(0);
			stdin.close();
			
			if(entrada == '0' || entrada == '+')
				sinal = false;
			if(entrada == '1' || entrada == '-')
				sinal = true;	
			
			System.out.println("Insira o expoente do primeiro numero");
			expoente = stdin.next();
			stdin.close();
			exp = stringToBooleanArray(expoente);
			
			System.out.println("Insira a Mantissa do primeiro numero");
			mantissa = stdin.next();
			stdin.close();
			mant = stringToBooleanArray(mantissa);
			
			numeroB = new Flutuante(sinal, exp, mant);stdin.close();
			
		}
		if(tipo == 'I' || tipo == 'i') {
			System.out.println("Insira a primeira parte inteira");
			String inteiro = stdin.next();
			stdin.close();
			boolean[] inte = stringToBooleanArray(inteiro);
			
			numeroA = new Inteiro(sinal, inte);
			
			System.out.println("Entre com o Sinal do segundo numero (0 ou + para positivo, 1 ou - para negativo)");
			entrada = stdin.next().charAt(0);
			stdin.close();
			
			if(entrada == '0' || entrada == '+')
				sinal = false;
			if(entrada == '1' || entrada == '-')
				sinal = true;	
			
			System.out.println("Insira a segunda parte inteira");
			inteiro = stdin.next();
			stdin.close();
			inte = stringToBooleanArray(inteiro);
			
			numeroB = new Inteiro(sinal, inte);
		}
		
		System.out.println("Insira a operação ('+', '-', '*' ou '/')");
		char operacao = stdin.next().charAt(0);
		stdin.close();
		
		System.out.println("\n");
		
		numeroA.print(); System.out.print(" " + operacao + " "); numeroB.print();
		
		if(operacao == '+')
			numeroA.soma(numeroB);
		if(operacao == '-')
			numeroA.subtracao(numeroB);
		if(operacao == '*')
			numeroA.multiplicacao(numeroB);
		if(operacao == '/')
			numeroA.divisao(numeroB);
		
		numeroA.print();		
	}
}
