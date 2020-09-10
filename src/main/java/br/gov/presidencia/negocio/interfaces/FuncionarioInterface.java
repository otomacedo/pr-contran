package br.gov.presidencia.negocio.interfaces;

import java.util.List;

import br.gov.presidencia.entity.Funcionario;
import br.gov.presidencia.util.Response;

public interface FuncionarioInterface {

	public List<Funcionario> listarFuncionario();
	public Response excluir(Integer id);
	public Response salvar(Funcionario funcionario);
	public Response editar(Funcionario funcionario);
	public Funcionario consultar(Integer id);
	public List<Funcionario> listarFuncionariosAtivos();
	public List<Funcionario> listarFuncionariosInativos();
	public Response atualizarStatusFuncionario(Funcionario funcionario);
	public List<Funcionario> filtrarFuncionarios(String tipo, String valor);
	
	
}
