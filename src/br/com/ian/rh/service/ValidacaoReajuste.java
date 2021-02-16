package br.com.ian.rh.service;

import java.math.BigDecimal;
import br.com.ian.rh.modelo.Funcionario;

public interface ValidacaoReajuste {
	
	void validar(Funcionario funcionario, BigDecimal aumento);

}
