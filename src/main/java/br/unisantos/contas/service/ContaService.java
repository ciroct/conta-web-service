package br.unisantos.contas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.annotation.ApplicationScope;

import br.unisantos.contas.model.Conta;

@ApplicationScope
public class ContaService {
	private static List<Conta> contas = new ArrayList<>();

	public ContaService() {
		super();
	}

	public void add(Conta conta) {
		contas.add(conta);
	}

	public List<Conta> getAll() {
		return contas;
	}

	public Conta get(Conta conta) {
		for (Conta c : contas) {
			if (c.equals(conta)) {
				return c;
			}
		}
		return null;
	}

	public Conta get(Integer numero) {
		return get(new Conta(numero));
	}

	public boolean update(Conta conta) {
		Conta _conta = get(conta);
		if (_conta != null) {
			_conta.setTitular(conta.getTitular());
			_conta.setBanco(conta.getBanco());
			_conta.setAgencia(conta.getAgencia());
			return true;
		}
		return false;
	}

	public boolean delete(Integer numero) {
		Conta _conta = get(numero);
		if (_conta != null) {
			contas.remove(_conta);
			return true;
		}
		return false;
	}

}
