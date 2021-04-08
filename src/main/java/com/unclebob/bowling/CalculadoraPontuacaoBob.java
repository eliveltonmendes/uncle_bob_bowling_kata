package com.unclebob.bowling;

public class CalculadoraPontuacaoBob {
    private int roll = 0;
    private int[] rolls = new int[21];

    public int pontuacaoTotal(int[] jogadas) {
        for(int i = 0; i < jogadas.length; i++) {
            roll(jogadas[i]);
        }

        return score();
    }

    public void roll(int pinDown) {
        rolls[roll++] = pinDown;
    }

    public int score() {
        int score = 0;
        int cursor = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(cursor)) {
                score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
                cursor++;
            } else if (isSpare(cursor)) {
                System.out.println("cursor: " + cursor + " Bonus: " + rolls[cursor + 2]);
                score += 10 + rolls[cursor + 2];
                cursor += 2;
            } else {
                score += rolls[cursor] + rolls[cursor + 1];
                cursor += 2;
            }
        }

        return score;
    }

    private boolean isStrike(int cursor) {
        return rolls[cursor] == 10;
    }

    private boolean isSpare(int cursor) {
        return rolls[cursor] + rolls[cursor + 1] == 10;
    }
}
