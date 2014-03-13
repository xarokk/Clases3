package ejercicio13;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.Date;

public class ThreadServer extends Thread {
	
	Socket ClientSocket=null;
	PrintWriter out= null;
	BufferedReader in =null;
	String MsgCliente=null;
	
	int IdThread=0;
	
	public ThreadServer ( Socket con, int id){
		ClientSocket=con;
		IdThread=id;
		System.out.println("Los parametros son los siguientes : "+ClientSocket+" ID:"+IdThread);
	}
	
	public void run() {
		
		try{
			System.out.println("......Entrando en el thread.....");
	
			out= new PrintWriter(ClientSocket.getOutputStream(),true);
			in = new BufferedReader ( new InputStreamReader(ClientSocket.getInputStream()));
			
			String InputLine;
			int pet;
			while((InputLine=in.readLine())!=null){
					
					pet=Integer.parseInt(InputLine);

					System.out.println("Server :  Receving!: "+InputLine);
				
				
						Date fecha = new Date();
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY  HH: mm: ss");
						String fechastring = formato.format(fecha);
						System.out.println("Servidor---> "+fechastring);
					
						
						out.println(fechastring);
						
						System.out.println("Server : Se ha enviado correctamente");	
			
			} 
	
			out.close();
			in.close();
	
			ClientSocket.close();
			Thread.interrupted();
			
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
	

}
