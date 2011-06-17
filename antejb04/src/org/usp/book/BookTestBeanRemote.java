package org.usp.book;

import javax.ejb.Remote;

@Remote
public interface BookTestBeanRemote {
	public void test();
}
