package psp.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunProcessPing {
	public static void main(String[] args) {
			String comando = "/bin/ping www.google.com";
			
			ProcessBuilder pb = new ProcessBuilder(args);
			pb.redirectErrorStream(true);
			
			try {
				Process proceso = pb.start();
				MostrarSalidaProceso(proceso);			
				System.exit(0);
				
			} catch (Exception e) {
				System.err.println("Error de E/S");
				System.exit(-1);
			}
		}

	private static void MostrarSalidaProceso(Process proceso) {
		int nLineas = 0;
		try {
			proceso.wait(5000);
			int retorno = proceso.waitFor();;
			
			System.out.println("El proceso hijo ha devuelto: "+ retorno);
			
			InputStreamReader lector = new InputStreamReader(proceso.getInputStream(),"utf-8");
			
			BufferedReader br = new BufferedReader(lector);

			String linea;		
						
			while (((linea = br.readLine()) != null) && nLineas <= 5) {
				
				System.out.println(linea);
				nLineas++;				
			}		
			
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
