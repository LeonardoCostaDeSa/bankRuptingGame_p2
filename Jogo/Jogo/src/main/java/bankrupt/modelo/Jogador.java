package bankrupt.modelo;

import java.util.*;

public abstract class Jogador {
    protected int coins = 300;
    protected int posicao = 0;
    protected boolean ativo = true;
    protected List<Propriedade> propriedades = new ArrayList<>();

    public abstract boolean decideComprar(Propriedade prop);

    public void mover(int passos, Tabuleiro tabuleiro) {
        boolean deuVolta = tabuleiro.deuVolta(posicao, passos);
        posicao = tabuleiro.mover(posicao, passos);
        if (deuVolta) coins += 100;
    }

    public void pagar(int valor) {
        coins -= valor;
    }

    public void receber(int valor) {
        coins += valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public int getPosicao() {
        return posicao;
    }

    public int getCoins() {
        return coins;
    }

    public void eliminar() {
        ativo = false;
        propriedades.clear();
    }

    public List<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void adquirir(Propriedade prop) {
        coins -= prop.getPreco();
        prop.setDono(this);
        propriedades.add(prop);
    }
}