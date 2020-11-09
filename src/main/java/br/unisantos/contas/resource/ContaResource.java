package br.unisantos.contas.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unisantos.contas.model.Conta;
import br.unisantos.contas.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaResource {
	private final ContaService service = new ContaService();

	@GetMapping
	public ResponseEntity<List<Conta>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{numero}")
	public ResponseEntity<?> get(@PathVariable("numero") Integer numero) {
		Conta _conta = service.get(numero);
		if (_conta != null) {
			return ResponseEntity.ok(_conta);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	public ResponseEntity<Conta> add(@RequestBody Conta conta) {
		service.add(conta);
		return ResponseEntity.ok(conta);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Conta conta) {
		if (service.update(conta)) {
			return ResponseEntity.ok(conta);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping(value = "/{numero}")
	public ResponseEntity<?> delete(@PathVariable("numero") Integer numero) {
		if (service.delete(numero)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
