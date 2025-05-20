package bankrupt.jogo;


import bankrupt.modelo.*;
import java.util.*;

public class ControllerJogo {
    private List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private int maxRodadas = 1000;
    private int rodadaAtual = 0;
    private boolean timeout = false;
    private Jogador vencedor = null;
    private List<Jogador> ordemOriginal;

    public ControllerJogo(List<Jogador> jogadores, Tabuleiro tabuleiro) {
        this.jogadores = new ArrayList<>(jogadores);
        this.ordemOriginal = new ArrayList<>(jogadores);
        this.tabuleiro = tabuleiro;
        Collections.shuffle(this.jogadores); // embaralha ordem inicial
    }

    public void executarPartida() {
        while (jogadoresAtivos() > 1 && rodadaAtual < maxRodadas) {
            rodadaAtual++;

            for (Jogador jogador : jogadores) {
                if (!jogador.isAtivo()) continue;

                int dado = new Random().nextInt(6) + 1;
                jogador.mover(dado, tabuleiro);
                Propriedade prop = tabuleiro.getPropriedade(jogador.getPosicao());

                if (prop.getDono() == null) {
                    if (jogador.decideComprar(prop)) {
                        if (jogador.getCoins() >= prop.getPreco()) {
                            jogador.adquirir(prop);
                        }
                    }
                } else if (prop.getDono() != jogador) {
                    Jogador dono = prop.getDono();
                    int aluguel = prop.getAluguel();
                    jogador.pagar(aluguel);
                    dono.receber(aluguel);
                }

                if (jogador.getCoins() < 0) {
                    jogador.eliminar();
                    liberarPropriedades(jogador);
                }

                if (jogadoresAtivos() == 1) {
                    vencedor = getUltimoJogadorAtivo();
                    return;
                }
            }
        }

        // Se terminou por timeout:
        if (jogadoresAtivos() > 1) {
            timeout = true;
            vencedor = jogadores.stream()
                .filter(Jogador::isAtivo)
                .max(Comparator.comparingInt(Jogador::getCoins)
                        .thenComparingInt(ordemOriginal::indexOf))
                .orElse(null);
        }
    }

    private int jogadoresAtivos() {
        return (int) jogadores.stream().filter(Jogador::isAtivo).count();
    }

    private Jogador getUltimoJogadorAtivo() {
        return jogadores.stream().filter(Jogador::isAtivo).findFirst().orElse(null);
    }

    private void liberarPropriedades(Jogador jogador) {
        for (Propriedade prop : jogador.getPropriedades()) {
            prop.setDono(null);
        }
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    public boolean terminouPorTimeout() {
        return timeout;
    }

    public int getRodadas() {
        return rodadaAtual;
    }
}