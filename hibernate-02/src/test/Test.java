package test;

import usp.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test {

    public static void main(String[] args) {
      if (args[0].equals("save")) {
        Session session = 
		Database.getConfiguracao().getCurrentSession();

        session.beginTransaction();

	Pessoa p = new Pessoa();
	p.setNome("Joao");
	p.setEndereco("Endereco");
	p.setTelefone("1111");
	p.setEmail("email@email.com");

	// Object
	Integer id = (Integer) session.save(p);
	System.out.println("chave primaria --> "+id);
        session.getTransaction().commit();

        Database.getConfiguracao().getCurrentSession().close();
      }
    }
}
