package main.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import main.acoes.AcaoAposGerarNota;
import main.domain.ItemDaNota;
import main.domain.NotaFiscal;

public class NotaFiscalBuilder {

	private String razaoSocial;
	private String cnpj;
	private double valorTotal;
	private double impostos;
	private Calendar data;
	private String observacoes;

	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();

	private List<AcaoAposGerarNota> todasAcoesASeremExecutadas;

	public NotaFiscalBuilder() {
		this.todasAcoesASeremExecutadas = new ArrayList<AcaoAposGerarNota>();
	}

	public void adicionaAcao(AcaoAposGerarNota novaAcao) {
		this.todasAcoesASeremExecutadas.add(novaAcao);
	}

	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public NotaFiscalBuilder comItem(ItemDaNota item) {
		todosItens.add(item);
		valorTotal += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}

	public NotaFiscalBuilder naDataAtual() {
		this.data = Calendar.getInstance();
		return this;
	}

	public NotaFiscalBuilder comObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}

	public NotaFiscal constroi() {

		NotaFiscal notaFiscal = new NotaFiscal(razaoSocial, cnpj, data,
				valorTotal, impostos, todosItens, observacoes);

		for (AcaoAposGerarNota acao : todasAcoesASeremExecutadas) {
			acao.executa(notaFiscal);
		}

		return notaFiscal;
	}
}