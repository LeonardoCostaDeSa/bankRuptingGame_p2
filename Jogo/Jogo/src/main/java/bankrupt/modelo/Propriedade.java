package bankrupt.modelo;

public class Propriedade {
    private int preco;
    private int aluguel;
    private Jogador dono;

    public Propriedade(int preco, int aluguel) {
        this.preco = preco;
        this.aluguel = aluguel;
        this.dono = null;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }

    public int getPreco() {
        return preco;
    }

    public int getAluguel() {
        return aluguel;
    }  
}
