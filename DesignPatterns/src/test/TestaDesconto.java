package test;

import main.desconto.CalculadorDeDescontos;
import main.domain.Item;
import main.domain.Orcamento;

import org.junit.Before;
import org.junit.Test;

public class TestaDesconto {

	private CalculadorDeDescontos calculador;
	private Orcamento orcamento;
	
	@Before
	public void init() {
		calculador = new CalculadorDeDescontos();
		orcamento = new Orcamento(700.0);
	}
	
	@Test
	public void descontoEmProdutos() {
		orcamento.adicionaItem(new Item("CANETA", 250.0));
		orcamento.adicionaItem(new Item("LAPIS", 250.0));
		
		// Gerar o desconto
		double desconto = calculador.calcula(orcamento);
		
		System.out.println("Desconto dado: "+desconto);
	}
}
