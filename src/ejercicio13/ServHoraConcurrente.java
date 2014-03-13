package ejercicio13;

import java.io.*;
import java.net.*;


public class ServHoraConcurrente {
	
	public static void main(String[] args) throws IOException{
		
		ServerSocket ServSocket=null;
		Socket ClientSocket=null;
		int puerto=10009, i=0;
		
		try{
			ServSocket= new ServerSocket(puerto);
		}catch(IOException ioe){
			System.err.println("el  "+puerto + " Esta ocupado!!");
			System.exit(1);
		}
		
		System.out.println("Esperando...");
		
		while(true){
			ClientSocket=ServSocket.accept();

			
			System.out.println("Conexion aceptada ");
			System.out.println("Esperando....");
			
			ThreadServer cliente = new ThreadServer(ClientSocket,i);
			cliente.start();
			i++;
			
		}
		
	}

}
