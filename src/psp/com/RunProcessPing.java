package psp.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunProcessPing {
	public static void main(String[] args) {
			Process proceso = null;
			
		
			
			try {
				proceso = new ProcessBuilder("ping","www.google.com").start();
				BufferedReader in = new BufferedReader(
					new InputStreamReader(proceso.getInputStream(), "utf-8"));
				for (int i = 0; i < 5; i++) {
					System.out.println(in.readLine());
				}
				if (proceso != null) {
					proceso.destroy();
				}		
				
				
				
			} catch (IOException e) {
				System.err.println("Error de E/S");
				System.exit(-1);
			}
		}
}
