package projeto.spring.data.aula;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javafx.animation.Interpolatable;
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
	
	@Test
	public void testConsulta() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		System.out.println(usuarioSpringData.get().getId());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getIdade());
		
	}
	
	@Test
	public void testConsultaAll() {
		
		Iterable<UsuarioSpringData> list = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuario : list) {
			System.out.println(usuario);
		}
		
	}
	
	@Test
	public void testeUpdate() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(28L);
		
		UsuarioSpringData data = usuarioSpringData.get();
		
		data.setNome("Usuario Editado");
		
		interfaceSpringDataUser.save(data);
		
	}
	
	@Test
	public void testeDelete() {
		
		interfaceSpringDataUser.deleteById(3L);
		
	}
	
	@Test
	public void testeDeleteBuscando() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		
		interfaceSpringDataUser.delete(usuarioSpringData.get());
		
	}


}













