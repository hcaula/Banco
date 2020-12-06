package br.ufpe.cin.banco;

public class OperacaoComValoresNegativoException extends Exception {
    public OperacaoComValoresNegativoException () {
        super("Erro ao realizar transação: valor negativo não é permitido.");
    }
}
