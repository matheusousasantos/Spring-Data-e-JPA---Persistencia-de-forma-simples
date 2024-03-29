package projeto.spring.data.aula;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.dao.InterfaceTelefone;
import projeto.spring.data.aula.model.Telefone;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
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
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		
		System.out.println(usuarioSpringData.get().getId());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getIdade());
		
		for(Telefone telefone : usuarioSpringData.get().getTelefones()) {
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
			System.out.println("------------------------------");
		}
		
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
	
	@Test
	public void testeConsultaNome() {
		
		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("Matheus");
		
		for (UsuarioSpringData usuarioSpringData : list) {
			
			System.out.println(usuarioSpringData.getNome());
			
		}
		
	}
	
	@Test
	public void testeConsultaNomeParam() {
		
		UsuarioSpringData usuario = interfaceSpringDataUser.buscaProNomeParam("Matheus");
		System.out.println(usuario.getNome());
		
	}
	
	@Test
	public void testeDeletePorNome() {
		
		interfaceSpringDataUser.deletePorNome("Matheus");
		
	}
	
	@Test
	public void testeUpdateEmailPorNome() {
		
		interfaceSpringDataUser.updateEmailPorNome("update@gmail.com", "Matheus Sousa");
		
	}
	
	@Test
	public void testeSetTelefone() {
		
		UsuarioSpringData usuario = interfaceSpringDataUser.buscaProNomeParam("Matheus Sousa");

		
		Telefone telefone = new Telefone();
		
		telefone.setTipo("Casa");
		telefone.setNumero("33221111");
		telefone.setUsuarioSpringData(usuario);
		
		interfaceTelefone.save(telefone);
		
	}


}













