package test;

import main.desconto.DescontoPorCincoItens;
import main.desconto.DescontoPorMaisDeQuinhentosReais;
import main.desconto.DescontoPorVendaCasada;
import main.desconto.SemDesconto;
import main.domain.Desconto;
import main.domain.Orcamento;

import org.junit.Before;
import org.junit.Test;

public class TestaCorrente {

	private Desconto desconto1;
	private Desconto desconto2;
	private Desconto desconto3;
	private Desconto desconto4;
	private Orcamento orcamento;
	
	@Before
	public void init() {
		desconto1 = new DescontoPorCincoItens();
		desconto2 = new DescontoPorMaisDeQuinhentosReais();
		desconto3 = new DescontoPorVendaCasada();
		desconto4 = new SemDesconto();

		orcamento = new Orcamento(800.0);
	}
	
	@Test
	public void descontoPorVendaCasada() {
	 
	    desconto1.setProximo(desconto2);
	    desconto2.setProximo(desconto3);
	    desconto3.setProximo(desconto4);
	     
	    // Gerar o desconto.
	    double desconto = desconto1.desconta(orcamento);
	   
	    System.out.println("Desconto dado: "+desconto);
	}
}