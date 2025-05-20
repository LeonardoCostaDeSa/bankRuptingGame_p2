package bankrupt;
import bankrupt.config.LeitorGameConfig;
import bankrupt.jogo.ControllerJogo;
import bankrupt.modelo.*;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int partidas = 300;
        int timeouts = 0;
        int totalRodadas = 0;
        Map<String, Integer> vitoriasPorTipo = new HashMap<>();

        for (int i = 0; i < partidas; i++) {
            try {
                // Lê o arquivo de propriedades
                List<Propriedade> propriedades = LeitorGameConfig.lerArquivo("src/gameConfig.txt");
                Tabuleiro tabuleiro = new Tabuleiro(propriedades);

                // Cria os jogadores
                List<Jogador> jogadores = List.of(
                        new JogadorImpulsivo(),
                        new JogadorExigente(),
                        new JogadorCauteloso(),
                        new JogadorAleatorio()
                );

                // Executa a partida
                ControllerJogo jogo = new ControllerJogo(jogadores, tabuleiro);
                jogo.executarPartida();

                // Registra resultados
                Jogador vencedor = jogo.getVencedor();
                String tipo = vencedor.getClass().getSimpleName();
                vitoriasPorTipo.put(tipo, vitoriasPorTipo.getOrDefault(tipo, 0) + 1);

                if (jogo.terminouPorTimeout()) {
                    timeouts++;
                }

                totalRodadas += jogo.getRodadas();

            } catch (Exception e) {
                System.err.println("Erro na partida " + (i + 1) + ": " + e.getMessage());
                e.printStackTrace();
            }
        }

        // Imprimir estatísticas finais
        System.out.println("===== Resultados =====");
        System.out.println("Total de partidas: " + partidas);
        System.out.println("Partidas que terminaram por timeout: " + timeouts);
        System.out.printf("Média de rodadas por partida: %.2f\n", (double) totalRodadas / partidas);

        System.out.println("\nVitórias por tipo de jogador:");
        vitoriasPorTipo.forEach((tipo, qtd) -> {
            double porcentagem = 100.0 * qtd / partidas;
            System.out.printf("- %s: %d vitórias (%.2f%%)\n", tipo, qtd, porcentagem);
        });

        // Comportamento mais vencedor
        String vencedorMaisFrequente = Collections.max(vitoriasPorTipo.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\nComportamento que mais venceu: " + vencedorMaisFrequente);
    }
}
