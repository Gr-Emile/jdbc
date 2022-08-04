package jdbc;

import jdbc.dao.DaoContato;
import jdbc.entidades.Contato;
//import jdbc.utilidades.Conexao;

public class Jdbc {

	public static void main(String[] args) {
		// conectar ao banco de dados
//		if(Conexao.conectar() != null) {
//			System.out.println("Conectado");
//		}
//		else {
//			System.out.println("Erro ao Conectar");
//			
//		}
		
		DaoContato dc = new DaoContato();
		//cadastrar contato 
//		Contato c1 = new Contato("Emile","321-876","emile@gmail.com");
//		if(dc.salvar(c1)) {
//		System.out.println("Contato cadastrado com sucesso!");
//		}
		
		// consultar todos
//		System.out.println(dc.consultar());
		
		//consultar um contato
//		System.out.println(dc.consultar(1));
		
		//alterar contato
//		Contato contato = dc.consultar(1);
//		System.out.println(contato);
//		contato.setNome("Emilae");
//		contato.setTelefone("1111-1111");
//		contato.getEmail();
//		
//		if (dc.alterar(contato));
//		System.out.println("Contato Alterado com sucesso!\n");
//		System.out.println(contato);
		
		//delete contato
		Contato contato = dc.consultar(1);
		System.out.println(contato);
		dc.excluir(1);
		contato = dc.consultar(1);
		System.out.println("Contato excluido com sucesso!\n");
		System.out.println(contato);
		
			
	}
}
