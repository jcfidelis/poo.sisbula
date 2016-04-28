package br.ufpb.sisbula;
import java.util.ArrayList;
import java.util.List;

public class Doenca extends IndicacaoMedicamento{
	

	private List<Sintoma> sintomas;
	
	public Doenca(String n) {
		super(n);
		sintomas = new ArrayList<Sintoma>();
		
		
	}

	public List<Sintoma> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}
	
	public void adicionaSintoma(Sintoma s){
		sintomas.add(s);
	}

	
}
