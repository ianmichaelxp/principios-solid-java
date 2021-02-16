package br.com.ian.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.ian.rh.ValidacaoException;
import br.com.ian.rh.modelo.Funcionario;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

	@Override
	public void validar(Funcionario funcionario, BigDecimal aumento){
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal reajustePercentual = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (reajustePercentual.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		
	}

}
