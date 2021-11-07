package com.spring.springmongo.service;

import java.util.List;

import com.spring.springmongo.model.Funcionario;

public interface FuncionarioService {
	
	public List<Funcionario> obtertodos();
	
	public Funcionario obterPorCodigo(String codigo);
	
	public Funcionario criar(Funcionario funcionario);
	
	public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate);
	
	public List<Funcionario> obterFuncionarioPorNome(String nome);
	
	public void deletar(String codigo);
}
