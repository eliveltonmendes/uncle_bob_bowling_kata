package com.unclebob.bowling;

public class CalculadoraPontuacaoBoliche {
    public int retornaSomaPontuacaoSimples(int[] jogadas){
        int score = 0;

        for(int cursor = 0; cursor < jogadas.length; cursor++) {
            score += jogadas[cursor];
        }

        return score;
    }

    public int pontuacaoTotal(int[] jogadas) {
        int pontuacaoTotal = retornaSomaPontuacaoSimples(jogadas);
        int pontuacaoTotalStrike = 0;
        int pontuacaoTotalSpare = 0;

        System.out.println("Pontuação total simples: " + pontuacaoTotal);

        int maximoJogadas = 10;
        int cursor = 0;
        
        //Somar pontuacaoSimples
        for (int frame = 0; frame < maximoJogadas; frame++) {
            if (jogadas[cursor] == 10) {
                pontuacaoTotalStrike += retornaBonusStrike(jogadas, cursor);
                cursor++;
            } else if (isSpare(jogadas, cursor)) {
                pontuacaoTotalSpare += retornaBonusSpare(jogadas, cursor);
                cursor += 2;
            } else {
                cursor += 2;
            }
        }

        System.out.println("PontuacaoTotal: " + pontuacaoTotal);
        System.out.println("PontuacaoTotalStrike: " + pontuacaoTotalStrike);
        System.out.println("PontuacaoTotalSpare: " + pontuacaoTotalSpare);
        return pontuacaoTotal + pontuacaoTotalStrike + pontuacaoTotalSpare;
    }

    private boolean isSpare(int[] jogadas, int posicao) {
        int somaPinos = jogadas[posicao] + jogadas[posicao + 1];
        System.out.println("Soma Spare: " + somaPinos + " Posicao: " + posicao);
        return (somaPinos == 10);
    }

    public int retornaBonusStrike(int[] jogadas, int posicao) {
        int pino1 = jogadas[posicao + 1];
        int pino2 = jogadas[posicao + 2];
        return pino1 + pino2;
    }
    
    public int retornaBonusSpare(int[] jogadas, int posicao) {
        int bonus = jogadas[posicao + 1];
        System.out.println("Bonus Spare: " + bonus);
        return bonus;
    }
}

/*if (jogadas[cursor] == 10) {
                System.out.println("Strike");
                pontuacaoTotal = pontuacaoTotal + jogadas[cursor] + jogadas[cursor + 1];
                
            }*/

/*if (jogadas[cursor] == 10){
                
                //pontuacaoTotal = pontuacaoTotal + jogadas[cursor + 1] + jogadas[cursor + 2];
                
                maximoJogadas--; //Não teve uma segunda jogada
                pontuacaoSoma = jogadas[cursor];
                System.out.println("Alteração do máximo de jogadas: " + maximoJogadas);
            } else {
                int pontuacaoSpare = jogadas[cursor] + jogadas[cursor + 1];

                if (pontuacaoSpare == 10) {
                    System.out.println("Spare: ");
                    cursor = cursor + 2;
                    pontuacaoSoma = pontuacaoSpare;
                } else {
                    pontuacaoSoma = jogadas[cursor];
                    cursor++;
                }
            }*/
            
            /*if ((jogadas[cursor] + jogadas[cursor + 1]) == 10){
                System.out.println("Spare");
                cursor = cursor + 2;
            }*/

            
            //pontuacaoTotal += pontuacaoSoma;
            

            /*if (cursor == (maximoJogadas - 1)) {
                System.out.println("ultima jogada: " + maximoJogadas);
                jogadasExtras = 2;
                System.out.println("jogadas maximas: " + maximoJogadas);
            }*/