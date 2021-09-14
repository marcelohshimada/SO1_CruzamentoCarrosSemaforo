package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private int idCarro;
	private String sentido;
	private Semaphore mutex;

	public ThreadCarro(int idCarro, Semaphore mutex) {
		this.idCarro = idCarro;
		this.mutex = mutex;

		switch (idCarro) {
		case 1:
			sentido = "Norte ao Sul";
			break;
		case 2:
			sentido = "Sul ao Norte";
			break;
		case 3:
			sentido = "Leste ao Oeste";
			break;
		case 4:
			sentido = "Oeste ao Leste";
			break;
		}

		System.out.println("O carro " + idCarro + " est� no sentido: " + sentido);
	}

	@Override
	public void run() {
		carroAndando(); // Paraleliz�vel (sem restri��es)
		
		// IN�CIO DA SE��O CR�TICA
		
		try {
			mutex.acquire();
			carroCruzando(); // Apenas 1 carro pode passar por vez (mutex)
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally { // Esse bloco roda independente do try ou catch ser executado
			mutex.release(); // Libera o cruzamento para o pr�ximo carro
		}
		
		// FIM DA SE��O CR�TICA
		
		carroSaindo();
	}

	private void carroAndando() {

	}

	private void carroCruzando() {

	}

	private void carroSaindo() {

	}

}
