package br.gov.presidencia.negocio.interfaces;

import java.util.List;

import br.gov.presidencia.entity.Rh;
import br.gov.presidencia.util.Response;

public interface RhInterface {

	public List<Rh> listarRh();
	public Response excluir(Integer id);
	public Response salvar(Rh rh);
	public Response editar(Rh rh);
	public Rh conultarRh(Integer id);
	public Rh consultarRhPorFuncionario(Integer id);
	public Response excluirFerias(Integer id);
	public List<Rh> listarTercerizados();
}
