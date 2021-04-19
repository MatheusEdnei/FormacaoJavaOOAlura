package br.com.alura.tdd.test;

import org.junit.Test;
import org.junit.Assert;
import br.com.alura.tdd.modelo.Calculadora;

public class CalculadoraTest {

	@Test
	public void deveriaSomarDoisNumerosPositivos() {
		Calculadora calc = new Calculadora();
		int soma = calc.somar(3,7);
		
		Assert.assertEquals(10, soma);
		
	}
}
