package ufpb.minicurso.lab1.entidades;

public class Disciplina implements Comparable<Disciplina> {

	
	private String nome;
	private Double nota;
	private int id;
	
	
	public Disciplina() {
		super();
		this.nome = "Materi";
		this.nota = 0.0;
	}
	
	public Disciplina(String nome, Double nota) {
		super();
		this.id = 0;
		this.nome=nome;
		this.nota = nota;
	}
	public Disciplina(String nome) {
		super();
		this.id = 0;
		this.nome=nome;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String n) {
		this.nome = n;
	}
	public Double getNota() {
		return this.nota;
	}
	public void setNota(Double n) {
		this.nota = n;
	}
	public int getId() { 
		return this.id; 
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override public int compareTo(Disciplina alunpT) { 
		if (this.nota > alunpT.getNota()) { 
		  return -1; 
		  } if (this.nota < alunpT.getNota()) { 
		  return 1; 
		  } 
		  return 0; 
		 }
	

	
}
