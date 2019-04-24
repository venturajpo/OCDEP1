package numero;

public class Inteiro{
	
	protected int[] inteiro;
	int numBits;
	protected boolean sinalizado;
	protected int resto;
	
	public int getInteiroEm(int indice) {
		int excesso = 0;
		if(sinalizado && inteiro[inteiro.length -1] == 1) excesso = 1;
		if(indice >= numBits) return excesso;
		return inteiro[indice];
	}
	

	public Inteiro() {
	}
	
	public Inteiro(int nBits, int[] valor, boolean sign) {
		this.numBits = nBits;
		this.sinalizado = sign;
		int excesso = 0;
		if(sinalizado && valor[valor.length - 1] == 1) excesso = 1;
		
		this.inteiro = new int[this.numBits];
		
		for(int i: this.inteiro)
		{
			inteiro[i] = excesso;
		}
		for(int i = 0; i < valor.length; ++i) {
			this.inteiro[i] = valor[i];
		}
		this.resto = -1;
	}

	public static Inteiro nega(Inteiro valor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Inteiro soma(Inteiro valor1, Inteiro valor2) {
		
		boolean sign = valor1.sinalizado || valor2.sinalizado;
		int valorSinal = (valor1.sinalizado? 1 : 0) + (valor2.sinalizado? 1 : 0); 
		
		int nBits = 0;
		if(valor1.numBits > valor2.numBits)
			nBits = valor1.numBits;
		else 
			nBits = valor2.numBits;
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
			//if(valorSinal ==)
			
		}
		
		if(carry != 0 && valorSinal != 0) return null;
		
		Inteiro resultado = new Inteiro(nBits, pInteira, sign);
		
		
		return resultado;
	}

	public static Inteiro subtracao(Inteiro valor1, Inteiro valor2) {
		// TODO Auto-generated method stub
		return null;
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
