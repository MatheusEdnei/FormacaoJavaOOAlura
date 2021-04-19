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
		BigDecimal bonus = service.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("25000")));

		assertEquals(new BigDecimal("0.00"), bonus);

	}
	
	@Test
	public void bonusDeveriaSer10PorCentoDoSalario() {

		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);

	}
	
	@Test
	public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {

		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);

	}

}
