package br.gov.presidencia.negocio.ejb;

import java.util.List;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.gov.presidencia.dao.FuncionarioDAO;
import br.gov.presidencia.entity.Funcionario;
import br.gov.presidencia.negocio.interfaces.FuncionarioInterface;
import br.gov.presidencia.util.Response;

@Model
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FuncionarioEJB implements FuncionarioInterface {

	@Inject
	FuncionarioDAO dao;

	public List<Funcionario> listarFuncionario() {
		return dao.listar();
	}

	public Response excluir(Integer id) {
		return dao.excluir(id);
	}

	public Response salvar(Funcionario funcionario) {
		if (funcionario.isStatus() == null)
			funcionario.setStatus(true);
		return dao.incluir(funcionario);
	}

	public Response editar(Funcionario funcionario) {
		return dao.alterar(funcionario);
	}

	public Funcionario consultar(Integer id) {
		return dao.consultar(id);
	}

	public List<Funcionario> listarFuncionariosAtivos() {
		return dao.listarFuncionariosAtivos();
	}

	public List<Funcionario> listarFuncionariosInativos() {
		return dao.listarFuncionariosInativos();
	}

	public Response atualizarStatusFuncionario(Funcionario funcionario) {
		return dao.atualizarStatusFuncionario(funcionario);
	}

	public List<Funcionario> filtrarFuncuionarios() {
		return null;
	}

	@Override
	public List<Funcionario> filtrarFuncionarios(String tipo, String valor) {
		return dao.filtrarFuncionario(filtro(tipo, valor));
	}

	private String filtro(String tipo, String valor) {
		switch (tipo) {
		case "1":
			return "SELECT f FROM Funcionario f WHERE f.nome LIKE '%"+valor+"%'";
		case "2":
			return "SELECT f FROM Funcionario f WHERE f.nomeGuerra LIKE '%"+valor+"%'";
		case "3":
			return "SELECT f FROM Funcionario f WHERE f.cpf LIKE '%"+valor+"%'";
		case "4":
			return "SELECT f FROM Funcionario f WHERE f.rg LIKE '%"+valor+"%'";
		case "5":
			return "SELECT f FROM Funcionario f WHERE f.ramal LIKE '%"+valor+"%'";
		default:
			return "SELECT f FROM Funcionario f ";
		}
	}
}

