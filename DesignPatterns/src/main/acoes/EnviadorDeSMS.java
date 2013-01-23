package main.acoes;

import main.domain.NotaFiscal;

public class EnviadorDeSMS implements AcaoAposGerarNota {

	public void executa(NotaFiscal notaFiscal) {
		System.out.println("enviando por sms");
	}
}