package org.usp.test02;

import javax.ejb.Local;

@Local
public interface CalculatorLocal {
	public int count();
}
