package main.acoes;

import main.domain.NotaFiscal;

public class Impressora implements AcaoAposGerarNota {

	public void executa(NotaFiscal notaFiscal) {
		System.out.println("imprimindo notaFiscal");
	}
}