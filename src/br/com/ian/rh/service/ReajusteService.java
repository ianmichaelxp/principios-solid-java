package br.com.ian.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import br.com.ian.rh.ValidacaoException;
import br.com.ian.rh.modelo.Funcionario;

public class ReajusteService {
	
	public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
		
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if(percentualReajuste.compareTo(new BigDecimal("0.4"))>0) {
			throw new ValidacaoException("Reajuste não pode ser superior a 40% do salário atual");
		}
		BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}

}
