package org.usp.test01;

import javax.ejb.Remote;

@Remote
public interface CalculatorRemote {
	public int sum(int add1, int add2);
	public int multiply(int mul1, int mul2);
}
