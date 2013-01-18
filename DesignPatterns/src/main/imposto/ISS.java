package main.imposto;

import main.domain.Imposto;
import main.domain.Orcamento;

public class ISS implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.6;
	}
}