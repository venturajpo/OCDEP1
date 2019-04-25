package numero;

public class Inteiro{
	
	public static void igualar(int[] A, int[] B) {	//NÃO FUNCIONA ESSA DESGRAÇA
		if(A.length == B.length)
			return;
		int[] realocado;
		int nBits = A.length;
		int[] menor = B;
		int excesso = B[B.length -1];
		if(B.length > nBits) {
			nBits = B.length;
			menor = A;
			excesso = A[A.length - 1];
		}
		realocado = new int[nBits];
		for(int i = 0; i < menor.length; ++i) {
			realocado[i] = menor[i];
		}
		
		for(int i = menor.length; i < nBits; ++i) {
			realocado[i] = excesso;
		}
		
		if(A.length > B.length)
			B = realocado;
		else
			A = realocado;
		return;	
		
	}
	
	public static int LSH(int[] valor) {
		int retorno = valor[valor.length-1];
		for(int i = 0; i < valor.length-1; ++i) {
			valor[i+1] = valor[i];
		}
		
		return retorno;
	}
	
	public static int RSH(int[] valor) {
		int retorno = valor[0];
		for(int i = 1; i < valor.length; ++i) {
			valor[i-1] = valor[i];
		}
		
		return retorno;
	}

	public static int[] nega(int[] valor) {
		int[] invertido = new int[valor.length];
		int[] um = new int[valor.length];
		um[0] = 1;		
		for(int i = 0; i < valor.length; ++i) {
			invertido[i] = valor[i] == 0 ? 1 : 0;
		}
		return Inteiro.soma(invertido, um);
		
	}
	
	public static int[] soma(int[] valor1, int[] valor2) {
		int nBits = valor1.length;
		boolean sinal = valor1[nBits -1 ] == valor2[nBits - 1];
		int[] resultado = new int[nBits];
		int carry = 0;
		for (int i = 0; i < nBits; ++i ) {
			int s = valor1[i] + valor2[i] + carry;
			if(s == 2) {
				carry = 1;
				resultado[i] = 0;
			}
			else if(s == 3) {
				carry = 1;
				resultado[i] = 1;
			}
			else {
				carry = 0;
				resultado[i] = s;
			}
		}
		if(sinal && (valor1[nBits - 1] != valor2[nBits - 1]))
			return null;
		return resultado;
	}
	
	public static int[] subtracao(int[] valor1, int[] valor2) {
		return soma(valor1, nega(valor2));
	}
	
	public static int[] multiplicacao(int[] Q, int[] M) {
		int numBits = Q.length + M.length;
		int[] A = new int[numBits];
		int Q0 = 0;
		
		for(int contador = Q.length; contador != 0; --contador) {
			if(Q[0] == 1 && Q0 == 0) {
				A = subtracao(A, M);
			}
			else if (Q[0] == 1 && Q0 == 1) {
				A = soma(A, M);
			}
			Q0 = RSH(Q);
			Q[Q.length - 1] = RSH(A);
		}
		
		int[] resultado = new int[numBits];
		
		for(int i = 0; i < Q.length; ++i)
			resultado[i] = Q[i];
		for(int i = Q.length; i < numBits; ++i)
			resultado[i] = A[i - Q.length];
		return resultado;

		
	}
	

	public static int[] divisao(int[] Q, int[] M) {
		int sinalQ = Q[Q.length-1];
		int sinalM = M[M.length-1];
		if(sinalQ == 1) Q = nega(Q);
		if(sinalM == 1) M = nega(M);
		int qBits = Q.length - 1;
		int[] A = new int[Q.length];
		int[] resto = new int[Q.length];
		int[] restaurar = new int[A.length];
		
		
		
		for(int i = 0; i < Q.length ; ++i) {
			resto[i] = Q[i];
		}
		
		for(int i = qBits-1; i != 0; --i) {
			LSH(A);
			A[0] = LSH(resto);
			
			for(int j = 0; j < A.length; ++j) {
				restaurar[j] = A[j];
			}
			
			A = subtracao(A, M);
			
			if(A[A.length - 1] == 1) {
				resto[0] = 0;
				for(int j = 0; j < A.length; ++j) {
					A[j] = restaurar[j];
				}
			}
			else if (A[A.length - 1] == 0) {
				resto[0] = 1;
			}
		}		
		if(sinalQ != sinalM)
			A = nega(A);
		return A;
	}

	public static void print(int[] P) {
		if(P == null) {
			System.out.print("Overflow");
			return;
		}
		for(int i = P.length - 1; i >= 0; --i) {
			System.out.print(P[i]);
		}
		
	}

}
