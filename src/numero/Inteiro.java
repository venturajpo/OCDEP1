package numero;

public class Inteiro{
	
	protected int[] inteiro;
	int numBits;
	//protected boolean sinal;
	protected int[] resto;
	
	public int getInteiroEm(int indice) {
		return inteiro[indice];
	}
	
	protected static Inteiro copiarInteiro(Inteiro A) {
		return new Inteiro(A);
	}
	
	public Inteiro(Inteiro A) {
		this.inteiro = new int[A.inteiro.length];
		for(int i = 0; i < A.inteiro.length; ++i) {
			this.inteiro[i] = A.inteiro[i];
		}
		this.numBits = inteiro.length;
		this.resto = new int[A.resto.length];
		for(int i = 0; i < A.resto.length; ++i) {
			this.resto[i] = A.resto[i];
		}
	}
	
	public Inteiro(int[] valor) {
		this.inteiro = new int[valor.length];
		for(int i = 0; i < valor.length; ++i) {
			this.inteiro[i] = valor[i];
		}
		this.numBits = inteiro.length;
		this.resto = new int[inteiro.length];
	}
	
	public Inteiro(int nBits) {
		this(new int[nBits]);
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
		int[] pInvertido = new int[valor.length];
		int[] pUm = new int[valor.length];
		pUm[0] = 1;		
		for(int i = 0; i < valor.length; ++i) {
			pInvertido[i] = valor[i] == 0 ? 1 : 0;
		}
		Inteiro invertido = new Inteiro(pInvertido);
		Inteiro um = new Inteiro(pUm);
		return Inteiro.soma(invertido, um).inteiro;
		
	}
	
	public static Inteiro nega(Inteiro valor) {
		int[] pInvertido = new int[valor.numBits];
		int[] pUm = new int[valor.numBits];
		pUm[0] = 1;
		
		for(int i = 0; i < valor.numBits; ++i) {
			pInvertido[i] = valor.getInteiroEm(i) == 0 ? 1 : 0;
		}
		Inteiro invertido = new Inteiro(pInvertido);
		Inteiro um = new Inteiro(pUm);
		return Inteiro.soma(invertido, um);
		
	}

	public static Inteiro soma(Inteiro valor1, Inteiro valor2) {
		int nBits = valor1.numBits;
		boolean sinal = valor1.inteiro[nBits - 1] == valor2.inteiro[nBits - 1];
		int[] pInteira = new int[nBits];
		
		int carry = 0;
		
		for(int i = 0; i < nBits; ++i) {
			int s = valor1.getInteiroEm(i) + valor2.getInteiroEm(i) + carry;
			if(s == 2) {
				carry = 1;
				pInteira[i] = 0;
			}else if(s == 3) {
				carry = 1;
				pInteira[i] = 1;
			}
			else {
				carry = 0;
				pInteira[i] = s;
			}			
		}
		
		if(sinal && (valor1.inteiro[nBits-1] != pInteira[nBits-1])) return null;
		
		Inteiro resultado = new Inteiro(pInteira);
		
		
		return resultado;
	}

	public static Inteiro subtracao(Inteiro valor1, Inteiro valor2) {
		return Inteiro.soma(valor1, Inteiro.nega(valor2));
	}
	public static Inteiro multiplicacao(Inteiro Q, Inteiro M) {
		int numBits = Q.numBits + M.numBits;
		Inteiro A = new Inteiro(Q.numBits);
		int Q0 = 0;
		
		for(int contador = Q.numBits; contador != 0; --contador) {
			if(Q.getInteiroEm(0) == 1 && Q0 == 0) {	
				A = subtracao(A, M);
			}else if(Q.getInteiroEm(0) == 0 && Q0 == 1) {
				A = soma(A, M);
			}			
			Q0 = RSH(Q.inteiro);
			Q.inteiro[Q.numBits - 1] = RSH(A.inteiro);
		}
		
		Inteiro resultado = new Inteiro(numBits);
		
		for(int i = 0; i < Q.numBits; ++i)
			resultado.inteiro[i] = Q.inteiro[i];
		for(int i = Q.numBits; i < numBits; ++i)
			resultado.inteiro[i] = A.getInteiroEm(i - Q.numBits);
		return resultado;
	}

	public static Inteiro divisao(Inteiro Q, Inteiro M) {
		int sinalQ = Q.getInteiroEm(Q.numBits-1);
		int sinalM = M.getInteiroEm(M.numBits-1);
		if(sinalQ == 1) Q = nega(Q);
		if(sinalM == 1) M = nega(M);
		int qBits = Q.numBits - 1;
		Inteiro A = new Inteiro(Q.numBits);
		A.resto = new int[Q.numBits];
		
		for(int i = 0; i < Q.numBits ; ++i) {
			A.resto[i] = Q.getInteiroEm(i);
		}
		
		for(int i = qBits-1; i != 0; --i) {
			LSH(A.inteiro);
			A.inteiro[0] = LSH(A.resto);
			Inteiro restaurar = copiarInteiro(A);
			A = subtracao(A, M);
			
			if(A.getInteiroEm(A.numBits-1) == 1) {
				A.resto[0] = 0;
				A = copiarInteiro(restaurar);
			}
			else if (A.getInteiroEm(A.numBits-1) == 0) {
				A.resto[0] = 1;
			}
		}		
		if(sinalQ != sinalM)
			A.inteiro = nega(A.inteiro);
		return A;
	}

	public void print() {
		for(int i = this.numBits - 1; i >= 0; --i) {
			System.out.print(inteiro[i]);
		}
		
	}

}
