package bankrupt.modelo;

import java.util.List;

public class Tabuleiro {
    private List<Propriedade> propriedades;

    public Tabuleiro(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    public Propriedade getPropriedade(int posicao) {
        return propriedades.get(posicao);
    }

    public int mover(int posicaoAtual, int passos) {
        return (posicaoAtual + passos) % propriedades.size();
    }

    public boolean deuVolta(int posicaoAtual, int passos) {
        return (posicaoAtual + passos) >= propriedades.size();
    }

    public int tamanho() {
        return propriedades.size();
    }
}