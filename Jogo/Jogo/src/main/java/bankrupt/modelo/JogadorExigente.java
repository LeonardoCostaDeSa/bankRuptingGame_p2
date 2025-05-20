package bankrupt.modelo;

public class JogadorExigente extends Jogador {
    @Override
    public boolean decideComprar(Propriedade prop) {
        return prop.getAluguel() > 50 && coins >= prop.getPreco();
    }
}