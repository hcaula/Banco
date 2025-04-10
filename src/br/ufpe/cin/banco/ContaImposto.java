package br.ufpe.cin.banco;

public class ContaImposto extends ContaAbstrata {
	public static final double CPMF = 0.0038;
	
	public ContaImposto(String numero, double valor) {
		super(numero, valor);
	}
	
	public ContaImposto(String numero) {
		this(numero, 0.0);
	}
	
	public void debitar(double valor) throws SaldoInsuficienteException, OperacaoComValoresNegativoException {
		if (this.getSaldo() < valor)
			throw new SaldoInsuficienteException(this.getNumero(), this.getSaldo());

		if (valor < 0) throw new OperacaoComValoresNegativoException();

		double imposto = valor * CPMF;
	    double total = valor + imposto;
	    this.setSaldo(this.getSaldo() - total);
	}

}