package com.spring.springmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springmongo.model.Funcionario;
import com.spring.springmongo.service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/funcionarios")
@Api(value = "API REST Funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	
	
	@GetMapping
	@ApiOperation(value = "Retornar uma lista de todos os funcionarios cadastrados")
	public List<Funcionario> obterTodos()
	{
		return this.funcionarioService.obtertodos();
	}
	
	@GetMapping("/{codigo}")
	@ApiOperation(value = "Retornar por codigo um funcionario")
	public Funcionario obterPoCodigo(@PathVariable String codigo)
	{
		return this.funcionarioService.obterPorCodigo(codigo);
	}
	
	@PostMapping
	@ApiOperation(value = "Cria um funcionario no banco de dados")
	public Funcionario criar(@RequestBody Funcionario funcionario)
	{
		return this.funcionarioService.criar(funcionario);
	}
	
	@GetMapping("/range")
	@ApiOperation(value = "Retorna uma lista de todos os funcionarios de determinada idade até determinada idade")
	public List<Funcionario> obterFuncionarioPorRangeDeIdade(@RequestParam("de") Integer de,@RequestParam("ate") Integer ate)
	{
		return this.funcionarioService.obterFuncionarioPorRangeDeIdade(de, ate);
	}
	
	@GetMapping("/por-nome")
	@ApiOperation(value = "Retorna uma Lista por nome um funcionario")
	public List<Funcionario> obterFuncionarioPorNome(@RequestParam("nome") String nome)
	{
		return this.funcionarioService.obterFuncionarioPorNome(nome);
	}
	
	@DeleteMapping("deletar/{codigo}")
	@ApiOperation(value = "Deleta por códgio um funcinario da base de dados")
	public void deletar(@PathVariable String codigo)
	{
		this.funcionarioService.deletar(codigo);
	}
}
