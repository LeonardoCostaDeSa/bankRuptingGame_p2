Claro! Aqui está um **README.md** completo e bem estruturado para o jogo **Bankrupt**. O conteúdo está dividido em seções que ajudam tanto no entendimento do jogo quanto na execução do projeto:

---

# 🏦 Bankrupt - Simulador de Jogo de Propriedades

**Bankrupt** é uma simulação de um jogo de tabuleiro inspirado em *Banco Imobiliário*, com regras simplificadas para análises estatísticas e estudos de estratégias. O objetivo é identificar qual estilo de jogador tende a vencer mais partidas dentro de um conjunto de simulações automatizadas.

---

## 📋 Sumário

* [Visão Geral](#visão-geral)
* [Regras do Jogo](#regras-do-jogo)
* [Comportamentos dos Jogadores](#comportamentos-dos-jogadores)
* [Formato do Arquivo gameConfig.txt](#formato-do-arquivo-gameconfigtxt)
* [Execução do Programa](#execução-do-programa)
* [Saída Esperada](#saída-esperada)
* [Exemplo de gameConfig.txt](#exemplo-de-gameconfigtxt)
* [Licença](#licença)

---

## 🎮 Visão Geral

Bankrupt simula 300 partidas entre 4 jogadores com estilos diferentes, interagindo em um tabuleiro com 20 propriedades. O programa busca identificar padrões de vitória por comportamento e média de duração das partidas.

---

## 🧩 Regras do Jogo

* O tabuleiro possui 20 propriedades em sequência.
* Todos os jogadores começam com **300 coins**.
* A ordem de jogada dos jogadores é aleatória.
* Cada jogador, em seu turno, lança um dado de 6 lados e avança no tabuleiro.
* Ao passar pela última propriedade, o jogador recebe **100 coins**.
* Ao cair em uma propriedade:

  * **Sem dono**: o jogador pode optar por comprá-la.
  * **Com dono**: o jogador paga aluguel ao proprietário.
* Jogadores **não podem** construir ou melhorar propriedades.
* Jogadores com saldo negativo são eliminados, e suas propriedades voltam a ficar disponíveis.
* O jogo termina quando sobra apenas **um jogador** ou após **1000 rodadas**.
* Em caso de empate por tempo, vence quem tiver mais coins. Se ainda houver empate, vence quem começou antes.

---

## 🧠 Comportamentos dos Jogadores

1. **Impulsivo**: compra qualquer propriedade que cair.
2. **Exigente**: compra apenas se o **aluguel > 50** coins.
3. **Cauteloso**: compra apenas se, após a compra, ainda tiver **≥ 80 coins**.
4. **Aleatório**: compra com **50% de chance**.

Esses perfis são fixos e simulados igualmente nas 300 partidas.

---

## 📁 Formato do Arquivo `gameConfig.txt`

O arquivo `gameConfig.txt` define os preços de venda e aluguel das 20 propriedades. Ele deve estar na mesma pasta do programa.

* Cada linha representa uma propriedade do tabuleiro.
* Cada linha tem **dois números inteiros**, separados por espaço:

  * **Preço de venda**
  * **Valor do aluguel**

### Exemplo:

```
100 20
120 30
150 35
80 15
200 60
...
```

---

## ▶️ Execução do Programa

1. Certifique-se de que o arquivo `gameConfig.txt` esteja presente no mesmo diretório dos arquivos de código.
2. Execute o programa principal (`main.py`, `BankruptSimulator.exe`, ou outro conforme o projeto).
3. O programa irá simular 300 partidas automaticamente e exibir os resultados no console.

---

## 📊 Saída Esperada

Após a simulação, os seguintes dados serão exibidos:

* Quantas partidas **terminaram por limite de turnos** (1000 rodadas);
* **Média de turnos** por partida;
* **Distribuição de vitórias** entre os quatro tipos de jogadores (%);
* **Comportamento mais vitorioso**.

### Exemplo de saída:

```
Partidas encerradas por timeout: 35
Média de turnos por partida: 872
Vitórias por comportamento:
- Impulsivo: 28.3%
- Exigente: 24.0%
- Cauteloso: 20.7%
- Aleatório: 27.0%
Comportamento mais vitorioso: Impulsivo
```

---

## 📄 Exemplo de `gameConfig.txt`

```
100 10
120 15
130 20
140 25
150 30
160 35
170 40
180 45
190 50
200 55
100 10
120 15
130 20
140 25
150 30
160 35
170 40
180 45
190 50
200 60
```

---

## ⚖️ Licença

Este projeto é de domínio público para fins acadêmicos, de aprendizado e de demonstração de simulações em jogos por computador.

---

Se quiser, posso gerar esse arquivo `.md` para você baixar. Deseja isso?
