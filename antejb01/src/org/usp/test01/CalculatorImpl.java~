package org.usp.test01;

import javax.ejb.Stateless;
import javax.ejb.Local;
import javax.ejb.Remote;

//START SNIPPET: code
@Stateless(name="CalculatorImpl")
@Local ({CalculatorLocal.class})
//@LocalBinding (jndiBinding="exemplo05/LocalCalculator")
@Remote ({CalculatorRemote.class})
//@RemoteBinding (jndiBinding="exemplo05/RemoteCalculator")
public class CalculatorImpl implements CalculatorRemote, CalculatorLocal {

	public int sum(int add1, int add2) {
		return add1+add2;
	}

	public int multiply(int mul1, int mul2) {
		return mul1*mul2;
	}

}
//END SNIPPET: code
