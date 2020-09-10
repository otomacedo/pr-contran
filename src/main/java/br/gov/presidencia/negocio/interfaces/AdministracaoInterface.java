package br.gov.presidencia.negocio.interfaces;

import java.util.List;

import br.gov.presidencia.entity.Atividade;
import br.gov.presidencia.entity.Departamento;
import br.gov.presidencia.entity.Graduacao;
import br.gov.presidencia.entity.Gratificacao;
import br.gov.presidencia.entity.Setor;
import br.gov.presidencia.entity.TipoGratificacao;
import br.gov.presidencia.util.Response;

public interface AdministracaoInterface {
	
	public List<Atividade> listarAtividade();
	public Response excluirAtividade(Long id);
	public Response salvarAtividade(Atividade atividade);
	
	public List<Departamento> listarDepartamento();
	public Response excluirDepartamento(Long id);
	public Response salvarDepartamento(Departamento departamento);

	public List<Setor> listarSetor();
	public Response excluirSetor(Long id);
	public Response salvarSetor(Setor setor);
	
	public List<Graduacao> listarGraduacao();
	public Response excluirGraduacao(Long id);
	public Response salvarGraducao(Graduacao graduacao);
	
	public List<Gratificacao> listarGratificacao();
	public Response excluirGratificacao(Long id);
	public Response salvarGratificacao(Gratificacao gratificacao);
	
	public Response salvarTipoGratificacao(TipoGratificacao tipoGratificacao);
	
}
