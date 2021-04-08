package com.unclebob.bowling;

public class CalculadoraPontuacaoBoliche {
    int maximoJogadas = 10;
    boolean strikeSpareUltimaPosicao = false;

    public int pontuacaoTotal(int[] jogadas) {
        int pontuacaoTotal = retornaSomaPontuacaoSimples(jogadas);
        int cursor = 0;

        for (int frame = 0; frame < maximoJogadas; frame++) {
            if (isStrike(jogadas, cursor)) {
                pontuacaoTotal += retornaBonusStrike(jogadas, cursor);
                cursor++;
            } else if (isSpare(jogadas, cursor)) {
                pontuacaoTotal += retornaBonusSpare(jogadas, cursor);
                cursor += 2;
            } else {
                cursor += 2;
            }
        }

        int score = (pontuacaoTotal < 300) ? pontuacaoTotal : 300;
        return score;
    }

    private int retornaSomaPontuacaoSimples(int[] jogadas){
        int score = 0;

        for(int cursor = 0; cursor < jogadas.length; cursor++) {
            score += jogadas[cursor];
        }

        return score;
    }

    private boolean isSpare(int[] jogadas, int posicao) {
        boolean isSpare = false;

        if (posicao + 2 < (jogadas.length - 1)) {
            int somaPinos = jogadas[posicao] + jogadas[posicao + 1];
            isSpare = (somaPinos == 10);
        }

        return isSpare;
    }

    private boolean isStrike(int[] jogadas, int posicao) {
        return (jogadas[posicao] == 10);
    }

    public int retornaBonusStrike(int[] jogadas, int posicao) {
        int pino1 = jogadas[posicao + 1];
        int pino2 = jogadas[posicao + 2];
        return pino1 + pino2;
    }
    
    public int retornaBonusSpare(int[] jogadas, int posicao) {
        int bonus = jogadas[posicao + 2];
        return bonus;
    }
}