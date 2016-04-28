package br.ufpb.sisbula;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
	
	/*
	 * Essa é a fachada do programa, onde ela delega as funções 
	 * que seram executadas pelas classes que obtem todos os metodos. 
	 * @a
	 */

public class SisBulaMemory implements SisBula {

	private GerenteMedicamentos gerenteMed;
	private GerenteDeDoencasESintomas gerenteDS;

	public SisBulaMemory() throws ClassNotFoundException {
		this.gerenteMed = new GerenteMedicamentos();
		this.gerenteDS = new GerenteDeDoencasESintomas();
	}
	
	public void cadastraMedicamento(String nomeMedicamento)throws MedicamentoJaExisteException{
		gerenteMed.cadastraMedicamento(nomeMedicamento);
	}
	/**
	 * Cadastra um novo medicamento no sistema 
	 * @param m O novo medicamento a ser cadastrado.
	 * @throws MedicamentoJaExisteException Quando já existe
	 * um medicamento com o mesmo nome do medicamento a ser
	 * cadastrado.
	 */
	
	@Override
	public void cadastraMedicamento(Medicamento m) throws MedicamentoJaExisteException {
		gerenteMed.cadastraMedicamento(m);

	}
	/**
	 * Retorna um medicamento de acordo com o seu nome e seu fabricante
	 * @param nome o nome do medicamento
	 * @param fabricante o nome do fabricante desse medicamento
	 * @return o medicamento com o nome pesquisado e seu fabricante
	 */
	@Override
	public Medicamento pesquisaMedicamento(String nome, 
			Fabricante fabricante) 
					throws MedicamentoInexistenteException {
		return gerenteMed.pesquisaMedicamento(nome, fabricante);
	}
	
	@Override
	public List<Medicamento> pesquisaMedicamentosDoFabricante(Fabricante fab){
		return gerenteMed.pesquisaMedicamentosDoFabricante(fab);
	}
	/**
	 * Retorna uma lista dos medicamentos indicados para certas
	 * doenças ou sintomas. 
	 * @param ind Um sintoma ou doença
	 * @return a lista dos medicamentos para o sintoma
	 * ou doença pesquisado
	 */
	
	@Override
	public List<Medicamento> pesquisaMedicamentosPara(IndicacaoMedicamento ind) {
		return gerenteMed.pesquisaMedicamentosPara(ind);
	}
	/**
	 * Cadastra uma doença pelo seu nome 
	 * @param nomeDoenca o nome da doenca a ser cadastrada
	 * 
	 */
	@Override
	public void cadastraDoenca(String nomeDoenca) throws DoencaJaExisteException{
		gerenteDS.cadastraDoenca(nomeDoenca);
	}
	/**
	 * Cadastra um sintoma pelo seu nome 
	 * @param nomeSintoma o nome do sintoma a ser cadastrado
	 */
	@Override
	public void cadastraSintoma(String nomeSintoma) throws SintomaJaExisteException{
		gerenteDS.cadastraSintoma(nomeSintoma);
	}

}

	



