package bankrupt.modelo;

import java.util.Random;

public class JogadorAleatorio extends Jogador {
    private Random random = new Random();

    @Override
    public boolean decideComprar(Propriedade prop) {
        return random.nextBoolean() && coins >= prop.getPreco();
    }
}