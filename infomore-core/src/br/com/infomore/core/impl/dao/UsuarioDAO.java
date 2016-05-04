package br.com.infomore.core.impl.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;

import br.com.infomore.dominio.Usuario;

public class UsuarioDAO extends AbstractDAO<Long, Usuario> {
	
	public UsuarioDAO(){
		super(Usuario.class);	
	}
	
	public Usuario consultarPorEmail(String email){
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query query = em.createQuery("SELECT * FROM " + 
		Usuario.class.getAnnotation(Table.class).name()+ "WHERE " +
		Usuario.class.getAnnotation(Column.class).name() +
		"=" + email);
	
		return (Usuario)query.getResultList();
	}

}
	/*@Override
	public String salvar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
		String sql = "insert into usuarios (nome, email, senha, executarWizard) values (?, ?, ?, ?);";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			// substituir todas ? pelos valores corretos
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());
			preparador.setBoolean(4, usuario.getExecutarWizard());
			// executar o comando
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
		// criar a lista para receber os resultados
		List<EntidadeDominio> lista = new ArrayList<>();
		String sql = "select nome, email, senha from usuarios where email = ?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			// substituir todas ? pelos valores corretos
			preparador.setString(1, usuario.getEmail());
			// executar o comando
			ResultSet resultado = preparador.executeQuery();
			while(resultado.next()){
				Usuario u = new Usuario();
				u.setNome(resultado.getString("nome"));
				u.setEmail(resultado.getString("email"));
				u.setSenha(resultado.getString("senha"));
				lista.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
*/

