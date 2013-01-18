package main.domain;

public interface Desconto {

	double desconta(Orcamento orcamento);
	
	void setProximo(Desconto proximo);
}