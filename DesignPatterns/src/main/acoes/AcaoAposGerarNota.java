package main.acoes;

import main.domain.NotaFiscal;

public interface AcaoAposGerarNota {

	void executa(NotaFiscal notaFiscal);
}