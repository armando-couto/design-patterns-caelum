package main.imposto;

import main.domain.Imposto;
import main.domain.Orcamento;

public class ICPP extends TemplateDeImpostoCondicional {

	public ICPP(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 + calculoDoOutroImposto(orcamento);
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07 + calculoDoOutroImposto(orcamento);
	}

	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + calculoDoOutroImposto(orcamento);
	}
}