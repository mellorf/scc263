package org.usp.app08.sample01;

class Impressora {
	private static Impressora i = null;

	public synchronized static Impressora getInstance() {
		if (i == null) {
			i = new Impressora();
		}
		return i;
	}

	public synchronized void m1(String msg) {
		for (int i = 0; i < 5; i++) {
			System.out.println(msg);
			try { Thread.sleep(120); 
			} catch (Exception e) {}
		}
	}

	public void m2() {
		for (int i = 0; i < 5; i++) {
			System.out.println("m2");
			try { Thread.sleep(120); 
			} catch (Exception e) {}
		}
	}
}

class Pessoa extends Thread {
	Impressora i;
	String msg;
	public Pessoa(/*Impressora i,*/ String msg) {
		this.i = Impressora.getInstance();
		this.msg = msg;
	}
	public void run() {
		i.m1(msg);
		i.m2();
	}
}

public class Sample01 {
	public static void main(String args[]) {
		//Impressora i = new Impressora();
		Pessoa p0 = new Pessoa(/*i,*/ "pessoa0");
		Pessoa p1 = new Pessoa(/*i,*/ "pessoa1");

		p0.start();
		p1.start();
	}
}
