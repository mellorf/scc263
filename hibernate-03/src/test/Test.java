package test;

import usp.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test {

    public static void main(String[] args) {
        Session session = 
		Database.getConfiguracao().getCurrentSession();

        session.beginTransaction();
	Pessoa p = new Pessoa();
	p.setNome("Joao");
	p.setEndereco("Endereco");
	p.setTelefone("1111");
	p.setEmail("email@email.com");

	String str = (String) session.save(p);
	System.out.println("chave primaria --> "+str);
        session.getTransaction().commit();

        Database.getConfiguracao().getCurrentSession().close();
    }
}
