package test;

import main.builder.NotaFiscalBuilder;
import main.domain.ItemDaNota;
import main.domain.NotaFiscal;

import org.junit.Test;

public class TestaNotaFiscal {

	NotaFiscalBuilder builder;
	
	public TestaNotaFiscal() {
		builder = new NotaFiscalBuilder();
	}
	
	@Test
	public void criarNotaFiscal() {
		
		builder.paraEmpresa("Caelum")
		.comCnpj("123.456.789/0001-10")
		.comItem(new ItemDaNota("item 1", 100.0))
		.comItem(new ItemDaNota("item 2", 200.0))
		.comItem(new ItemDaNota("item 3", 300.0))
		.comObservacoes("entregar nf pessoalmente")
		.naDataAtual();
		
		NotaFiscal nf = builder.constroi();
		
		System.out.println("Valor Total: "+nf.getValorTotal());
	}
}