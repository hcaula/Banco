package br.ufpe.cin.ui.main;

import br.ufpe.cin.banco.*;
import br.ufpe.cin.dados.ContaNaoEncontradaException;
import br.ufpe.cin.dados.RepositorioContas;
import br.ufpe.cin.dados.RepositorioContasArray;
import br.ufpe.cin.dados.RepositorioVector;

/**
 * Mova a classe Programa para o pacote aula15.br.ufpe.cin.ui,
 * ela deve tratar todas as excecoes dando uma mensagem de
 * erro para o usuario
 *
 */
public class Programa {

	public static void main(String[] args) {
		try {
			RepositorioContas repositorio = new RepositorioVector();
			Banco banco = new Banco(repositorio);

			banco.cadastrar(new Conta("123"));
			banco.cadastrar(new ContaEspecial("456"));
			banco.cadastrar(new Poupanca("789"));
			banco.cadastrar(new ContaImposto("012"));

			banco.creditar("123", 100);
			banco.creditar("456", 200);
			banco.creditar("789", 300);
			banco.creditar("012", 400);

			banco.debitar("123", 10);
			banco.debitar("456", 20);
			banco.debitar("789", 30);
			banco.debitar("012", 40);

			System.out.println("123: " + banco.getSaldo("123"));
			System.out.println("456: " + banco.getSaldo("456"));
			System.out.println("789: " + banco.getSaldo("789"));
			System.out.println("012: " + banco.getSaldo("012"));

			banco.renderBonus("456");
			banco.renderJuros("789");

			System.out.println("\nDepois de render juros e bonus...");
			System.out.println("123: " + banco.getSaldo("123"));
			System.out.println("456: " + banco.getSaldo("456"));
			System.out.println("789: " + banco.getSaldo("789"));
			System.out.println("012: " + banco.getSaldo("012"));

			banco.transferir("123", "789", 10);

			System.out.println("\nDepois de transferir...");
			System.out.println("123: " + banco.getSaldo("123"));
			System.out.println("456: " + banco.getSaldo("456"));
			System.out.println("789: " + banco.getSaldo("789"));
			System.out.println("012: " + banco.getSaldo("012"));

			System.out.println("\nAgora a proxima linha gera um erro que ser� devidaente tratado");
			banco.debitar("123", -2);
			banco.creditar("123", -2);
			banco.renderBonus("123");
		} catch (ContaJaCadastradaException e) {
			System.out.println(e.getMessage());
		} catch (ContaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		} catch (RenderBonusContaEspecialException e) {
			System.out.println(e.getMessage());
		} catch (RenderJurosPoupancaException e) {
			System.out.println(e.getMessage());
		} catch (OperacaoComValoresNegativoException e) {
			System.out.println(e.getMessage());
		}
	}

}
