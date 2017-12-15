package br.com.caelum.desafio;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnoBissextoTest {

	private AnoBissexto anoBissexto;

	public AnoBissextoTest() {
		anoBissexto = new AnoBissexto();
	}
	
	@Test
	public void eAnoBissexto() {
		assertEquals(true, anoBissexto.ehBissexto(2004));
		assertEquals(true, anoBissexto.ehBissexto(2016));
	}
	
	@Test
	public void  naoEAnoBissexto() {
		
		assertEquals(false, anoBissexto.ehBissexto(2015));
		assertEquals(false, anoBissexto.ehBissexto(2011));
	}
}
