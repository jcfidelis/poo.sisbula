package br.ufpb.sisbula.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

import br.ufpb.sisbula.Medicamento;

public class ArquivoDeMedicamentos {
	
	private String nomeArquivo;
	
	public  ArquivoDeMedicamentos(){
		this.nomeArquivo = "medicamentos.txt";
	}
	
	public void gravarMedicamento(Collection <Medicamento> medicamentos) throws FileNotFoundException, IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
			out.writeObject(medicamentos);

		}finally{
			if(out != null){
				out.close();
			}
		}
	}


public Collection <Medicamento> leMedicamento() throws FileNotFoundException, IOException, ClassNotFoundException{
	ObjectInputStream in = null;
	try{
		in = new ObjectInputStream(new FileInputStream(nomeArquivo));
		return (Collection<Medicamento>)in.readObject();
	}finally {
		if(in != null){
			in.close();
		}
	}
}
}
