package br.gov.presidencia.negocio.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import br.gov.presidencia.dao.AtividadeDAO;
import br.gov.presidencia.dao.DepartamentoDAO;
import br.gov.presidencia.dao.GraduacaoDAO;
import br.gov.presidencia.dao.GratificacaoDAO;
import br.gov.presidencia.dao.SetorDAO;
import br.gov.presidencia.dao.TipoGratificacaoDAO;
import br.gov.presidencia.entity.Atividade;
import br.gov.presidencia.entity.Departamento;
import br.gov.presidencia.entity.Graduacao;
import br.gov.presidencia.entity.Gratificacao;
import br.gov.presidencia.entity.Setor;
import br.gov.presidencia.entity.TipoGratificacao;
import br.gov.presidencia.negocio.interfaces.AdministracaoInterface;
import br.gov.presidencia.util.Response;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AdministracaoEJB implements AdministracaoInterface {
	
	AtividadeDAO atividadeDAO = new  AtividadeDAO();
	
	DepartamentoDAO departamentoDAO = new DepartamentoDAO();
	
	SetorDAO setorDAO = new SetorDAO();
	
	GraduacaoDAO graduacaoDAO = new GraduacaoDAO();
	
	GratificacaoDAO gratificacaoDAO = new GratificacaoDAO();
	
	TipoGratificacaoDAO tipoGratificacaoDAO = new TipoGratificacaoDAO();
	
	
	public List<Atividade> listarAtividade() {
			return atividadeDAO.listar();
	}
	
	public Response excluirAtividade(Long id) {
			return atividadeDAO.excluir(id);
	}

	
	public Response salvarAtividade(Atividade atividade) {
			return atividadeDAO.incluir(atividade);
	}

	
	public List<Departamento> listarDepartamento() {
			return departamentoDAO.listar();
	}

	
	public Response excluirDepartamento(Long id) {
			return departamentoDAO.excluir(id);
	}

	
	public Response salvarDepartamento(Departamento departamento) {
			return departamentoDAO.incluir(departamento);
	}

	
	public List<Setor> listarSetor() {
		return setorDAO.listar();
	}

	
	public Response excluirSetor(Long id) {
		return setorDAO.excluir(id);
	}

	
	public Response salvarSetor(Setor setor) {
		return setorDAO.incluir(setor);
	}

	
	public List<Graduacao> listarGraduacao() {
		return graduacaoDAO.listar();
	}

	
	public Response excluirGraduacao(Long id) {
		return graduacaoDAO.excluir(id);
	}

	
	public Response salvarGraducao(Graduacao graduacao) {
		return graduacaoDAO.incluir(graduacao);
	}

	
	public List<Gratificacao> listarGratificacao() {
		return gratificacaoDAO.listar();
	}

	
	public Response excluirGratificacao(Long id) {
		return gratificacaoDAO.excluir(id);
	}

	
	public Response salvarGratificacao(Gratificacao gratificacao) {
		return gratificacaoDAO.incluir(gratificacao);
	}

	public Response salvarTipoGratificacao(TipoGratificacao tipoGratificacao) {
		return tipoGratificacaoDAO.incluir(tipoGratificacao);
	}

}
