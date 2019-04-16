package testes.cabineTelefonica;

import java.util.concurrent.Semaphore;

public class Principal {
	public static void main(String[] args) {
		int numeroDePermicoes = 2;
	    String[] telefonistas = {"Jefferson", "Bruno", "Renan", "Diego", "Andre"};
	    
	    Semaphore semaphore = new Semaphore(numeroDePermicoes);
	    CabineTelefonica[] processos = new CabineTelefonica[telefonistas.length];
	    
	    for (int i = 0; i < telefonistas.length; i++) {
	        processos[i] = new CabineTelefonica(telefonistas[i], semaphore);
	        processos[i].start();
	    }
	}
}
