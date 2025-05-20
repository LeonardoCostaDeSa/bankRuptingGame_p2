package bankrupt.modelo;

public class JogadorCauteloso extends Jogador {
    @Override
    public boolean decideComprar(Propriedade prop) {
        return coins - prop.getPreco() >= 80;
    }
}