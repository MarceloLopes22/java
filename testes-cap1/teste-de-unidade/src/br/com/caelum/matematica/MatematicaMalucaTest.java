package br.com.caelum.matematica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaMalucaTest {

	@Test
	public void numeroMaiorQueTrinta() {
		MatematicaMaluca maluca = new MatematicaMaluca();
		int retorno = maluca.contaMaluca(31);
		assertEquals(124, retorno);
	}
	
	@Test
	public void numeroMaiorQueDez() {
		MatematicaMaluca maluca = new MatematicaMaluca();
		int retorno = maluca.contaMaluca(11);
		assertEquals(33, retorno);
	}
	
	@Test
	public void numeroMenorQueDez() {
		MatematicaMaluca maluca = new MatematicaMaluca();
		int retorno = maluca.contaMaluca(9);
		assertEquals(18, retorno);
	}
	
}