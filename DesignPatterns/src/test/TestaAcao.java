package test;

import main.acoes.EnviadorDeEmail;
import main.acoes.EnviadorDeSMS;
import main.acoes.Impressora;
import main.acoes.NotaFiscalDAO;
import main.builder.NotaFiscalBuilder;
import main.domain.ItemDaNota;
import main.domain.NotaFiscal;

import org.junit.Test;

public class TestaAcao {

	NotaFiscalBuilder builder;
	NotaFiscal notaFiscal;
	
	public TestaAcao() {
		this.builder = new NotaFiscalBuilder();
	}

	@Test
	public void realizaTeste() {
		builder.adicionaAcao(new EnviadorDeEmail());
		builder.adicionaAcao(new NotaFiscalDAO());
		builder.adicionaAcao(new EnviadorDeSMS());
		builder.adicionaAcao(new Impressora());
		
		notaFiscal = builder.paraEmpresa("Caelum")
				.comCnpj("123.456.789/0001-10")
				.comItem(new ItemDaNota("item 1", 100.0))
				.comItem(new ItemDaNota("item 2", 200.0))
				.comItem(new ItemDaNota("item 3", 300.0))
				.comObservacoes("entregar notaFiscal pessoalmente")
				.naDataAtual().constroi();
		
		System.out.println("Valor Total: "+notaFiscal.getValorTotal());
	}
}