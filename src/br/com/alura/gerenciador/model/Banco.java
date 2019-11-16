package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresa = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		listaEmpresa.add(empresa);
		listaEmpresa.add(empresa2);
	}
	
	public void adicionar(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.listaEmpresa.add(empresa);
		
	}
	
	public List<Empresa> getListaEmpresas(){
		return Banco.listaEmpresa;
	}

	public void removerEmpresa(Integer id) {
		
		Iterator<Empresa> it = listaEmpresa.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}	
	}

	public Empresa buscarEmpresaId(Integer id) {
		for (Empresa empresa : listaEmpresa) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
		
	}
	
}
