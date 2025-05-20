package bankrupt.config;

import java.io.*;
import java.util.*;
import bankrupt.modelo.Propriedade;

public class LeitorGameConfig {
    public static List<Propriedade> lerArquivo(String caminho) throws IOException {
        List<Propriedade> propriedades = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] partes = linha.trim().split(" ");
            int preco = Integer.parseInt(partes[0]);
            int aluguel = Integer.parseInt(partes[1]);
            propriedades.add(new Propriedade(preco, aluguel));
        }
        br.close();
        return propriedades;
    }
}
