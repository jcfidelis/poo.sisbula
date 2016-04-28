package br.ufpb.sisbula;

public abstract class IndicacaoMedicamento {
	
	private String nome;
	
	public IndicacaoMedicamento(String n){
		this.nome = n;
		
	}

	public String getNome() {
		return nome;
	}

	
	
}
