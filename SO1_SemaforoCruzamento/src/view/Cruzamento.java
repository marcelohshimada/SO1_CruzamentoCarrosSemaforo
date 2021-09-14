package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Cruzamento {
	
	public static void main(String[] args) {
		
		int permissão = 1;
		Semaphore mutex = new Semaphore(permissão);
		
		for (int idCarro = 1 ; idCarro < 5 ; idCarro++) {
			ThreadCarro tCarro = new ThreadCarro(idCarro, mutex);
			tCarro.start();
		}
	}

}
