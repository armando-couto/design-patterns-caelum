package main.imposto;

import main.domain.Item;
import main.domain.Orcamento;

public class IKCV extends TemplateDeImpostoCondicional {

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500
				&& temItemMaiorQue100ReaisNo(orcamento);
	}

	private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if (item.getValor() > 100)
				return true;
		}
		return false;
	}
	
	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}
}