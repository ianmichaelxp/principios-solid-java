package br.com.ian.rh.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.ian.rh.modelo.Funcionario;

public class ReajusteService {
	
	private List<ValidacaoReajuste> validacoes;
	
	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;		
	}
	
	public void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal aumento) {
		this.validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));
		
		BigDecimal salarioAjustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioAjustado);
		
	}

}
