package br.ufpb.sisbula;

import java.util.ArrayList;
import java.util.List;

public class GerenteDeDoencasESintomas {
	private List<Doenca> doencas;
	private List<Sintoma> sintomas;
	
	public GerenteDeDoencasESintomas(){
		this.doencas = new ArrayList<Doenca>();
		this.sintomas = new ArrayList<Sintoma>();
	}
	
	public void cadastraDoenca(String nomeDoenca)throws DoencaJaExisteException{
		Doenca d = new Doenca(nomeDoenca);
		for(Doenca d1: doencas){
			if(d1.getNome().equals(nomeDoenca)){
				throw new DoencaJaExisteException("Essa doenca ja existe");
			}
		}
		doencas.add(d);
	}
	
	public void cadastraSintoma(String nomeSintoma)throws SintomaJaExisteException{
		Sintoma s = new Sintoma(nomeSintoma);
		for(Sintoma s1: sintomas){
			if(s1.getNome().equals(nomeSintoma)){
				throw new SintomaJaExisteException("Essa doença ja existe");
			}
		}
		sintomas.add(s);
	}
	
	public Sintoma pesquisaSintoma(String nome)throws SintomaInexistenteException{
		for(Sintoma s1: sintomas){
			if(s1.getNome().equals(nome)){
				return s1;
			}
		}
		throw new SintomaInexistenteException("Sintoma nao existe");
		
	}
	

	public Doenca pesquisaDoenca(String nome)throws DoencaInexistenteException{
		for(Doenca d1: doencas){
			if(d1.getNome().equals(nome)){
				return d1;
			}
		}
		throw new DoencaInexistenteException("Doença nao existe");
		
	}
		
	
	
}
