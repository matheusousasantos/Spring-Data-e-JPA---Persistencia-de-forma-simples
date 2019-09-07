package projeto.spring.data.aula.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projeto.spring.data.aula.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long>{
	
	@Transactional( readOnly = true )
	@Query( value = "select p from UsuarioSpringData p where p.nome like %?1%" )
	public List<UsuarioSpringData> buscaPorNome(String nome);
	
	@Transactional( readOnly = true )
	@Query( value = "select p from UsuarioSpringData p where p.nome = :paramnome" )
	public UsuarioSpringData buscaProNomeParam(@Param("paramnome") String paramnome);
	
	
	default <S extends UsuarioSpringData> S saveAtual(S entity) {
		// TODO Auto-generated method stub
		return save(entity);
	}
	
	@Modifying
	@Transactional
	@Query( value = "delete from UsuarioSpringData u where u.nome = ?1" )
	public void deletePorNome(String nome);
	
	@Modifying
	@Transactional( timeout = 5)
	@Query( value = "update UsuarioSpringData u set u.email = ?1 where u.nome = ?2" )
	public void updateEmailPorNome( String email, String nome );


}
