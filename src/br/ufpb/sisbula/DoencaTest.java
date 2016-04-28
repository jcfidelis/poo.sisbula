package br.ufpb.sisbula;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoencaTest {
	Doenca doenca;
	@Before
	public void setUp() throws Exception {
		doenca = new Doenca("Tpm");
		Sintoma colica = new Sintoma("Dor na barriga");
		Sintoma raiva = new Sintoma("raiva");
		doenca.adicionaSintoma(colica);
		doenca.adicionaSintoma(raiva);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(doenca.getNome().equals("Tpm"));
		assertTrue(doenca.getSintomas().get(0).getNome().equals("Dor na barriga"));
		assertTrue(doenca.getSintomas().get(1).getNome().equals("raiva"));
		
		
		
	}

}
