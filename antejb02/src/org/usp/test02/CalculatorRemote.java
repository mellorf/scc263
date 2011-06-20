package org.usp.test02;

import javax.ejb.Remote;

@Remote
public interface CalculatorRemote {
	public int count();
}
