package br.com.wmw.testes.main;

import java.util.List;

import br.com.wmw.testes.entity.Pessoa;
import br.com.wmw.testes.reflection.Relacoes;

public class Main {

	public static void main(String[] args) {
		List<Class> lista = Relacoes.getEntidadesRelacionadas(Pessoa.class);
		for (Class c : lista) {
			System.out.println(c.getName());
		}
	}

}
