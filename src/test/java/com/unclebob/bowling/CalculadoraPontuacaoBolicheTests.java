package com.unclebob.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraPontuacaoBolicheTests {
    CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche;

    @BeforeEach
    public void setUp() {
        calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();
    }

    @Test
    public void testSpareStrike() {
        int[] jogadas = new int[] {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};
        assertEquals(133, calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas));
    }

    @Test
    public void testStrike() {
        int[] jogadas = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0};
        assertEquals(20, calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas));
    }

    @Test
    public void testSpare() {
        int[] jogadas = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0,0};
        assertEquals(17, calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas));
    }

    @Test
    public void testPerfectGame() {
        int[] jogadas = new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        assertEquals(300, calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas));
    }
}