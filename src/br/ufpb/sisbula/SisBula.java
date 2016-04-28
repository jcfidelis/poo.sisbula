package br.ufpb.sisbula;


import java.util.List;

/**
 * Mostra as funcionalidades de um sistema de informa��es
 * sobre uma bula de medicamentos
 * 
 * @author Joao Carlos
 *
 */
public interface SisBula {
	/**
	 * Cadastra um novo medicamento no sistema 
	 * @param m O novo medicamento a ser cadastrado.
	 * @throws MedicamentoJaExisteException Quando j� existe
	 * um medicamento com o mesmo nome do medicamento a ser
	 * cadastrado.
	 */
	public void cadastraMedicamento(Medicamento m) throws MedicamentoJaExisteException;
	
	/**
	 * Retorna uma lista dos medicamentos indicados para certas
	 * doen�as ou sintomas. 
	 * @param ind Um sintoma ou doen�a
	 * @return a lista dos medicamentos para o sintoma
	 * ou doen�a pesquisado
	 */
	public List<Medicamento> pesquisaMedicamentosPara(IndicacaoMedicamento ind);

	public Medicamento pesquisaMedicamento(String nome, Fabricante fabricante) throws MedicamentoInexistenteException;

	public void cadastraSintoma(String nomeSintoma) throws SintomaJaExisteException;

	public void cadastraDoenca(String nomeDoenca) throws DoencaJaExisteException;
	/**
	 * Retorna uma lista dos medicamentos de um certo fabricante 
	 * @param fab um fabricante 
	 * @return uma lista dos medicamentos de um certo fabricante
	 */
	public List<Medicamento> pesquisaMedicamentosDoFabricante(Fabricante fab);
}

