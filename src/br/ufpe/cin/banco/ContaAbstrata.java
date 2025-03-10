package br.ufpe.cin.banco;

/**
 * Modifique a classe Conta para lancar a excecao SaldoInsuficienteException 
 * e ajuste das demais classes da aplicacao
 *
 */
public abstract class ContaAbstrata {
	private String numero;
	private double saldo;
	
	public ContaAbstrata(String numero, double valor) {
		this.numero = numero;
		this.saldo = valor;
	}
	
	public ContaAbstrata(String numero) {
		this(numero, 0.0);
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void creditar(double valor) throws OperacaoComValoresNegativoException {
		if (valor < 0) throw new OperacaoComValoresNegativoException();
		this.saldo = this.saldo + valor;
	}
	
	public abstract void debitar(double valor) throws SaldoInsuficienteException, OperacaoComValoresNegativoException;

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
		
}
