package org.usp.test02;

import javax.ejb.Remote;

//START SNIPPET: code
@Remote
public interface CalculatorRemote {
	public int count();
}
//END SNIPPET: code
