package main.acoes;

import main.domain.NotaFiscal;

public class NotaFiscalDAO implements AcaoAposGerarNota {

	public void executa(NotaFiscal notaFiscal) {
		System.out.println("salvando no banco");
	}
}