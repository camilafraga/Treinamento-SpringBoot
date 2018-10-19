package br.com.workshop.contacorrente.resource;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.workshop.contacorrente.Enumeration.TipoContaEnum;
import br.com.workshop.contacorrente.model.Conta;
import br.com.workshop.contacorrente.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaResourse {

	private final ContaService service;

	public ContaResourse(ContaService contaService) {
		this.service = contaService;
	}

	@PostMapping
	public ResponseEntity<Conta> insert(@Valid @RequestBody Conta conta) {
		return ResponseEntity.ok(service.insert(conta));
	}

	@GetMapping
	public ResponseEntity<Page<Conta>> findAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Conta> findById(@PathVariable("id") String id) {
		return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/tipoConta/{tipo}")
	public ResponseEntity<Page<Conta>> findByTipo(@PathVariable("tipo") TipoContaEnum tipo, Pageable pageable) {
		return ResponseEntity.ok(service.findByTipo(tipo, pageable));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Conta> update(@Valid @RequestBody Conta conta) {
		return ResponseEntity.ok(service.update(conta));
	}

}
