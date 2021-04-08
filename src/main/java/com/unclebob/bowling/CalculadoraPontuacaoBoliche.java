package com.unclebob.bowling;

public class CalculadoraPontuacaoBoliche {
    public int pontuacaoTotal(int[] jogadas) {
        int pontuacaoTotal = 0;
        int cursor = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(jogadas, cursor)) {
                pontuacaoTotal += 10 + retornaBonusStrike(jogadas, cursor);
                cursor++;
            } else if (isSpare(jogadas, cursor)) {
                pontuacaoTotal += 10 + retornaBonusSpare(jogadas, cursor);
                cursor += 2;
            } else {
                pontuacaoTotal += jogadas[cursor] + jogadas[cursor + 1];
                cursor += 2;
            }
        }

        return pontuacaoTotal;
    }

    private boolean isSpare(int[] jogadas, int posicao) {
        return (jogadas[posicao] + jogadas[posicao + 1]) == 10;
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