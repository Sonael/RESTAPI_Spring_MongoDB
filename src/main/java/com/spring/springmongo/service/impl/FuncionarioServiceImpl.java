package com.spring.springmongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springmongo.model.Funcionario;
import com.spring.springmongo.repository.FuncionarioRepository;
import com.spring.springmongo.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private	FuncionarioRepository FuncionarioRepository;
	
	@Override
	public List<Funcionario> obtertodos() {
		return this.FuncionarioRepository.findAll();
	}

	@Override
	public Funcionario obterPorCodigo(String codigo) {
		return this.FuncionarioRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Funcionario não Existe"));
	}

	@Override
	public Funcionario criar(Funcionario funcionario) {
		if(funcionario.getChefe() != null) {
		
		Funcionario chefe =  this.FuncionarioRepository
				.findById(funcionario.getChefe().getCodigo())
				.orElseThrow(() -> new IllegalArgumentException("Chefe inexistente"));
		
		funcionario.setChefe(chefe);
		}
		
		return this.FuncionarioRepository.save(funcionario);
	}

	@Override
	public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate) {
		return this.FuncionarioRepository.obterFuncionarioPorRangeDeIdade(de, ate);
	}

	@Override
	public List<Funcionario> obterFuncionarioPorNome(String nome) {
		return this.FuncionarioRepository.findByNome(nome);
	}

	@Override
	public void deletar(String codigo) {
		this.FuncionarioRepository.deleteById(codigo);
	}





	
}
