package ufpb.minicurso.lab1.controladores;

import org.springframework.web.bind.annotation.RestController;

import ufpb.minicurso.lab1.servicos.DisciplinasServico;
import ufpb.minicurso.lab1.entidades.Disciplina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DisciplinasControladores {
	
	@Autowired
	private DisciplinasServico disciplinasService;

	@PostMapping("/v1/api/disciplinas/nova")
	public ResponseEntity<Disciplina> setNovaDisciplina(@RequestBody Disciplina novaDisciplina){
		return new ResponseEntity<Disciplina>(disciplinasService.setNovaDisciplina(novaDisciplina),HttpStatus.CREATED);
	}
	
	@GetMapping("/v1/api/disciplinas (id numerico, nome, nota)")
	public ResponseEntity<List<Disciplina>>getListaDisciplina(@RequestParam(value = "nome", defaultValue = "Materia") String nome) {
		return new ResponseEntity<List<Disciplina>>(disciplinasService.getListaDisciplinas(), HttpStatus.OK);
	}
	
	@GetMapping("/v1/api/saudacoes/alternativa/{id}")
	public ResponseEntity<Disciplina> getNovaDisciplina(@PathVariable Integer id, @RequestParam(value = "nome", defaultValue = "Materia") String nome) {
		try {
			return new ResponseEntity<Disciplina>(disciplinasService.getNovaDisciplina(nome, id), HttpStatus.OK);
		} catch(ArrayIndexOutOfBoundsException aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(null, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> setNomeDisciplina(@RequestBody Integer id, String nome){
		try {
		return new ResponseEntity<Disciplina>(disciplinasService.setNomeDisciplinaId(id, nome),HttpStatus.OK);
		} catch(Exception aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(null, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("PUT /v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> setNotaDisciplina(@RequestBody Integer id, Double nota){
		try {
			return new ResponseEntity<Disciplina>(disciplinasService.setNotaDisciplinaId(id, nota),HttpStatus.OK);
		} catch(Exception aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(null, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> deleteDisciplina(@RequestBody Integer id){
		try {
			return new ResponseEntity<Disciplina>(disciplinasService.deleteDisciplina(id),HttpStatus.OK);
		}catch(Exception aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(null, null), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
