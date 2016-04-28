package br.ufpb.sisbula;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SisBulaMemoryTest {

	SisBula sis;
	@Before
	public void setUp() throws Exception {
		sis = new SisBulaMemory();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaCadastroDeMedicamentoOK() {
		Medicamento m = new Medicamento("Novalgina");
		try {
			sis.cadastraMedicamento(m);
		} catch (Exception e){
			fail("Lançou exceção sem necessidade");
		}	
	}
	
	
	@Test
	public void testaCadastroDeMedicamentoDuasVezes() {
		Medicamento m = new Medicamento("Novalgina");
		try {
			sis.cadastraMedicamento(m);
		} catch (Exception e){
			fail("Lançou exceção sem necessidade");
		}	
		
		try {
			sis.cadastraMedicamento(new Medicamento("Novalgina"));
			fail("Deveria ter lançado a exceção");
		} catch (MedicamentoJaExisteException e) {
			System.out.println("Muito bem, lançou a excecao direito");
		}
	}
	
	@Test
	public void testaCadastroDoenca(){
		try{
			sis.cadastraDoenca("Zika");
		}catch (Exception e){
			fail("Foi lançado a exceção sem necessidade ");
			
		}
		try{
			sis.cadastraDoenca("Zika");
			fail("Deveria ter lançado a exceção");
		}catch (DoencaJaExisteException e){
			System.out.println("OK, a Exceção foi lançada direito");
		}
	}
	@Test
	public void testaCadastroDoencaDuasVezes(){
		Doenca d = new Doenca("Zika");
		try{
			sis.cadastraDoenca("Zika");
		}catch (Exception e){
			fail("Foi lançado a exceção sem necessidade ");
			
		}
	}
	
	
	@Test
	public void testaCastraSintoma(){
		
		try{
			sis.cadastraSintoma("Febre");
		}catch (Exception e){
			fail("Foi lançado a exceção sem necessidade "+e.getMessage());
			e.printStackTrace();
			
		}
	}
	
	
	@Test
	public void testeDaProva() throws ClassNotFoundException{
		SisBula sisBula = new SisBulaMemory();
		List<Medicamento> lista = sisBula.pesquisaMedicamentosDoFabricante(Fabricante.MEDLEY);
		assertEquals(0, lista.size());
		Medicamento dip = new Medicamento("Dipirona", Fabricante.MEDLEY);
		try {
			sisBula.cadastraMedicamento(dip);
		} catch (MedicamentoJaExisteException e){
			fail("Não deveria lançar exceção. Cadastro autorizado");
		}
		List<Medicamento> lista2 = sisBula.pesquisaMedicamentosDoFabricante(Fabricante.MEDLEY);
		assertEquals(1, lista2.size());
		assertTrue(lista2.get(0).getNome().equals("Dipirona"));
		Medicamento dip2 = new Medicamento("Dipirona",Fabricante.MEDLEY);
		try {
			sisBula.cadastraMedicamento(dip2);
			fail("Deveria ter lançado a exceção");
		} catch (MedicamentoJaExisteException e2){
			System.out.println("Exceção esperada");
		}
		
	}

}
