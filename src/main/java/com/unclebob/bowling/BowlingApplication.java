package com.unclebob.bowling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BowlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BowlingApplication.class, args);

		int[] jogadas = new int[] {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};
		CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();
		int score = calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas);

		System.out.println("score: " + score);
	}
}