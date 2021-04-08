package com.unclebob.bowling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BowlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BowlingApplication.class, args);

		int[] jogadas = new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();
		int score = calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas);

		System.out.println("score: " + score);
	}
}