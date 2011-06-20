package org.usp.test02;

import javax.ejb.Stateless;
import javax.ejb.Stateful;
import javax.ejb.Local;
import javax.ejb.Remote;
import org.jboss.annotation.ejb.Clustered;  

@Stateful
@Clustered
public class CalculatorImpl implements 
		CalculatorRemote, CalculatorLocal {
	private int c = 0;

	public int count() {
		System.out.println(++c);
		return c;
	}

}
