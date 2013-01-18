package main.imposto;

import main.domain.Imposto;
import main.domain.Orcamento;

public class CalculadorDeImpostos {

	public double realizaCalculo(Orcamento orcamento, Imposto imposto) {
		return imposto.calcula(orcamento);
	}
}