package br.ufpe.cin.dados;

import br.ufpe.cin.banco.ContaAbstrata;

import java.util.Vector;

public class RepositorioVector implements RepositorioContas {

    private Vector<ContaAbstrata> contas;

    public RepositorioVector() {
        contas = new Vector<>();
    }

    public void inserir(ContaAbstrata conta) {
        contas.add(conta);
    }

    public ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException {
        int index = getIndex(numero);
        if (index == -1) throw new ContaNaoEncontradaException();

        return contas.get(index);
    }

    public void remover(String numero) throws ContaNaoEncontradaException {
        ContaAbstrata conta = this.procurar(numero);
        contas.remove(conta);
    }

    public void atualizar(ContaAbstrata conta) throws ContaNaoEncontradaException {
        int index = getIndex(conta.getNumero());
        if (index == -1) throw new ContaNaoEncontradaException();

        contas.set(index, conta);
    }

    public boolean existe(String numero) {
        int index = getIndex(numero);
        return index >= 0;
    }

    private int getIndex(String numero) {
        int index = -1;
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumero().equals(numero)) {
                index = i;
            }
        }

        return index;
    }
}
