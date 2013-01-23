package main.imposto;

import java.util.ArrayList;
import java.util.List;

import main.domain.Imposto;
import main.domain.Item;
import main.domain.Orcamento;

public class IHIT extends TemplateDeImpostoCondicional {

	public IHIT(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		List<String> noOrcamento = new ArrayList<String>();
	     
	    for(Item item : orcamento.getItens()) {
	      if(noOrcamento.contains(item.getNome())) return true;
	      else noOrcamento.add(item.getNome());
	    }
	     
	    return false;
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.13 + 100;
	}

	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * (0.01 * orcamento.getItens().size());
	}
}