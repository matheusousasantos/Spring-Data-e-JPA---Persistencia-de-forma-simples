package projeto.spring.data.aula;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void testInsert( ) {
		
		UsuarioSpringData usuario = new UsuarioSpringData();
		
		usuario.setEmail("matheus@gmail.com");
		usuario.setNome("Luma");
		usuario.setIdade(26);
		usuario.setLogin("123");
		usuario.setSenha("123");
		
		interfaceSpringDataUser.save(usuario);
		
	}

}
