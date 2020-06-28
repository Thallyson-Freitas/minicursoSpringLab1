package ufpb.minicurso.lab1.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ufpb.minicurso.lab1.entidades.Disciplina;

@Service
public class DisciplinasServico {
	
	private List<Disciplina> listaDisciplinas = new ArrayList<>();
	
	public Disciplina setNovaDisciplina(Disciplina novaDisciplina) {
		this.listaDisciplinas.add(novaDisciplina);
		int temp = listaDisciplinas.size() - 1;
		listaDisciplinas.get(temp).setId(temp);
		return this.listaDisciplinas.get(temp);
	}
	public List<Disciplina> getListaDisciplinas(){
		return this.listaDisciplinas;
	}
	public Disciplina getNovaDisciplina(String nome, int id) {
		if (listaDisciplinas.isEmpty() || id < 0 || id >= listaDisciplinas.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		listaDisciplinas.get(id).setNome(nome);
		return listaDisciplinas.get(id);
	}
	public Disciplina setNomeDisciplinaId(int id, String nome) {
		for(Disciplina k: listaDisciplinas) {
			if (k.getId() == id) {
				k.setNome(nome);
				return k;
			}
		}throw new ArrayIndexOutOfBoundsException();
	}
	public Disciplina setNotaDisciplinaId(int id, Double nota) {
		for(Disciplina k: listaDisciplinas) {
			if (k.getId() == id) {
				k.setNota(nota);
				return k;
			}
		}throw new ArrayIndexOutOfBoundsException();
	}
	public Disciplina deleteDisciplina(int id) {
		Disciplina k = new Disciplina();
		for (int t = 0; t < listaDisciplinas.size(); t++) {
			if (listaDisciplinas.get(t).getId() == id) {
				k = listaDisciplinas.get(t);
				listaDisciplinas.remove(t);
				return k;
			}	
		}throw new ArrayIndexOutOfBoundsException();
	}
	
	
	
	
	
	
}
