package test;

import main.domain.Imposto;
import main.domain.Orcamento;
import main.imposto.CalculadorDeImpostos;
import main.imposto.ICCC;
import main.imposto.ICMS;
import main.imposto.ISS;

import org.junit.Before;
import org.junit.Test;

public class TestaImposto {

	Imposto iss;
	Imposto icms;
	Imposto iccc;
	Imposto impostoComplexo;
	Orcamento orcamento;
	CalculadorDeImpostos calculador;
	
	@Before
	public void init() {
		iss = new ISS();
		icms = new ICMS();
		iccc = new ICCC();
		impostoComplexo = new ISS(new ICMS());
		orcamento = new Orcamento(500.0);
		
		calculador = new CalculadorDeImpostos();
	}
	
	@Test
	public void realizaCalculo() {
		
		// Calculando o ISS
		System.out.println("ISS: "+calculador.realizaCalculo(orcamento, iss));
		
		// Calculando o ICMS
		System.out.println("ICMS: "+calculador.realizaCalculo(orcamento, icms));
		
		// Calculando o ICCC
		System.out.println("ICCC: "+calculador.realizaCalculo(orcamento, iccc));
		
		// Calculando o ISS com ICMS
		System.out.println("ISS com ICCC: "+impostoComplexo.calcula(orcamento));
	}
}
