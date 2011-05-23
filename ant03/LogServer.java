import java.io.*;
import java.util.*;
import java.net.*;

public class LogServer {
	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(1234);

		while (true) {
			Socket s = ss.accept();
			Scanner net = new Scanner(s.getInputStream());
			String str = null;

			while ((str = net.nextLine()) != null) {
				System.out.println(str);
			}
		}
	}
}
