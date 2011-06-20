package org.usp.test02;

import javax.ejb.Stateful;
import javax.ejb.Local;
import javax.ejb.Remote;
import org.jboss.annotation.ejb.Clustered;  

//START SNIPPET: code
@Stateful//(name="CalculatorImpl")
@Clustered
//@Local ({CalculatorLocal.class})
//@LocalBinding (jndiBinding="exemplo05/LocalCalculator")
//@Remote ({CalculatorRemote.class})
//@RemoteBinding (jndiBinding="exemplo05/RemoteCalculator")
public class CalculatorImpl implements CalculatorRemote, CalculatorLocal {
	private int c = 0;

	public int count() {
		return ++c;
	}

}
//END SNIPPET: code
