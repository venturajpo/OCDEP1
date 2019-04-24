package numero;

public class Inteiro{
	
	protected int[] inteiro;
	int numBits;
	//protected boolean sinal;
	protected int resto;
	
	public int getInteiroEm(int indice) {
		return inteiro[indice];
	}
	

	public Inteiro() {
	}
	
	public Inteiro(int[] valor) {
		this.inteiro = new int[valor.length];
		for(int i = 0; i < valor.length; ++i) {
			this.inteiro[i] = valor[i];
		}
		this.numBits = inteiro.length;
		this.resto = -1;
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
//		if(valor1.numBits > valor2.numBits)
//			nBits = valor1.numBits;
//		else 
//			nBits = valor2.numBits;
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
	public static Inteiro multiplicacao(Inteiro valor1, Inteiro valor2) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Inteiro divisao(Inteiro valor1, Inteiro valor2) {
		// TODO Auto-generated method stub
		return null;
	}
	public static Inteiro divisao(Inteiro valor) {
		// TODO Auto-generated method stub
		return null;
	}

	public void print() {
		for(int i = this.numBits - 1; i >= 0; --i) {
			System.out.print(inteiro[i]);
		}
		
	}

}
