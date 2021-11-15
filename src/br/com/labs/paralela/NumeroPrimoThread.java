package br.com.labs.paralela;

import java.util.concurrent.CountDownLatch;

import br.com.labs.calculadora.NumeroPrimo;

public class NumeroPrimoThread implements Runnable {
	
	private int _numero;
	private CountDownLatch _latch;
	
	public NumeroPrimoThread(CountDownLatch latch, int numero)
	{
		_numero = numero;
		_latch = latch;
	}
	
	@Override
	public void run() {
		NumeroPrimo objNumeroPrimo = new NumeroPrimo();
		
		try {
			objNumeroPrimo.VerificarSeNumeroEhPrimo(_numero);
			
			_latch.countDown();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
