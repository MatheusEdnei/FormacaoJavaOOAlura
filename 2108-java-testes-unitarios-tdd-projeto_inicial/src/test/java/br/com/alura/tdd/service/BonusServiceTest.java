package br.com.alura.tdd.service;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Test;
import br.com.alura.tdd.modelo.Funcionario;

public class BonusServiceTest {

	@Test
	public void bonusDeveriaSerZeroParaFuncionariosComSalarioMuitoAlto() {

		BonusService service = new BonusService();
/*		assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Jo?o", LocalDate.now(), new BigDecimal("25000")));*/

		try {
			service.calcularBonus(new Funcionario("Jo?o", LocalDate.now(), new BigDecimal("25000")));
			fail("Teste falhou, n?o deu a exception");
		} catch (Exception e) {
			assertEquals("Funcion?rio com mais de 10000 de sal?rio n?o pode receber b?nus", e.getMessage());
		}


	}
	
	@Test
	public void bonusDeveriaSer10PorCentoDoSalario() {

		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Jo?o", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);

	}
	
	@Test
	public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {

		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Jo?o", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);

	}

}
