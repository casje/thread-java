package br.com.labs.paralela;

import java.util.concurrent.CountDownLatch;

import br.com.labs.calculadora.Fatorial;

public class FatorialThread implements Runnable {

	private int _numero;
	private CountDownLatch _latch;
	
	public FatorialThread(CountDownLatch latch, int numero)
	{
		_numero = numero;
		_latch = latch;
	}
	
	@Override
	public void run() {
		Fatorial objFatorial = new Fatorial();
		try {
			objFatorial.Calcular(_numero);

			_latch.countDown();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
