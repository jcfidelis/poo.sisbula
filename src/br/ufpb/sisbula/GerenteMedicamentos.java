package br.ufpb.sisbula;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufpb.sisbula.persistencia.ArquivoDeMedicamentos;
import br.ufpb.sisbula.persistencia.SisBulaPersisteinciaException;

public class GerenteMedicamentos {
	private Map<String, Medicamento> medicamentos;
	private ArquivoDeMedicamentos arqMed;
	

	public GerenteMedicamentos() throws ClassNotFoundException {
		this.medicamentos = new HashMap<String,Medicamento>();
		this.arqMed = new ArquivoDeMedicamentos();
		try{
			Collection<Medicamento> medRecuperados = arqMed.leMedicamento();
			for(Medicamento m: medRecuperados){
				this.medicamentos.put(m.getId(), m);
			}
		}catch (IOException e){
			System.out.println("Não foi possivel recuperar os arquivos");
		}
	}
	
	public void cadastraMedicamento(String nomeMedicamento)throws MedicamentoJaExisteException{
		Medicamento m = new Medicamento(nomeMedicamento);
		this.cadastraMedicamento(m);
		
	}

	
	public void cadastraMedicamento(Medicamento m) throws MedicamentoJaExisteException {
		Medicamento med = this.medicamentos.get(m.getId());
		if (med!=null){
			throw new MedicamentoJaExisteException("Já existe medicamento com este nome:" + m.getNome());
		} else {
			this.medicamentos.put(m.getId(), m);
		}

	}

	public Medicamento pesquisaMedicamento(String nome, 
			Fabricante fabricante) 
					throws MedicamentoInexistenteException {
		String id = nome+fabricante.toString();
		Medicamento med = this.medicamentos.get(id);
		
		if (med!=null) {
				return med;
		} else {
			throw new MedicamentoInexistenteException("Não existe medicamento com este nome:" + nome);
	
		}
	}
	
	public List<Medicamento> pesquisaMedicamentosDoFabricante(Fabricante fab){
		List<Medicamento> lista = new ArrayList<Medicamento>();
		for (Medicamento m: this.medicamentos.values()){
			if (m.getFabricante().equals(fab)){
				lista.add(m);
			}
		}
		return lista;
	}

	
	public List<Medicamento> pesquisaMedicamentosPara(IndicacaoMedicamento ind) {
		List <Medicamento> lista = new ArrayList<Medicamento>();
		for (Medicamento m: this.medicamentos.values()){
			for (IndicacaoMedicamento i: m.getIndicacoes()){
				if (i.getNome().equals(ind.getNome())){
					lista.add(m);
					break;
				}
			}
		}
		return lista;
	}
	public void cadastraMedicamentoPara(String nomeMed, IndicacaoMedicamento indicacao) throws MedicamentoInexistenteException{
		Medicamento m= this.pesquisaMedicamento(nomeMed, null);
		m.adicionaIndicacao(indicacao);
	}

	
	public void salvaDados()throws SisBulaPersisteinciaException{
		try{
			this.arqMed.gravarMedicamento(medicamentos.values());
		}catch(IOException e){
			throw new SisBulaPersisteinciaException("Não foi possivel gravar os aquivos");
		}
	}


}
