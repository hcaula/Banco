package br.ufpe.cin.banco;

public class PoupancaEsp extends Poupanca {
    private double bonus;

    public PoupancaEsp(String numero, double valor) {
        super(numero, valor);
        bonus = 0.0;
    }

    public PoupancaEsp(String numero) {
        this(numero, 0.0);
    }

    public void creditar(double valor) throws OperacaoComValoresNegativoException {
        super.creditar(valor);
        bonus = bonus + (valor * 0.01);
    }

    public void renderBonus() throws OperacaoComValoresNegativoException {
        super.creditar(this.bonus);
        bonus = 0;
    }

    public double getBonus() {
        return this.bonus;
    }
}
