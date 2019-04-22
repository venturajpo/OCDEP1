package numero;

public abstract class Numero {
	
	protected boolean sinal;

	public abstract Numero inverte(Numero valor);

	
	public abstract Numero soma(Numero valor);

	
	public abstract Numero subtracao(Numero valor);

	
	public abstract Numero multiplicacao(Numero valor);

	
	public abstract Numero divisao(Numero valor);
	
	public abstract void print();
}
