package bankrupt.modelo;

public class JogadorImpulsivo extends Jogador {
    @Override
    public boolean decideComprar(Propriedade prop) {
        return coins >= prop.getPreco();
    }
}