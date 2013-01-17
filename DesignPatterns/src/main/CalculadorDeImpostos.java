package main;

public class CalculadorDeImpostos {

	public double realizaCalculo(Orcamento orcamento, Imposto imposto) {
		return imposto.calcular(orcamento);
	}
}