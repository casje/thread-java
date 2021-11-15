package br.com.labs.paralela;

import java.util.concurrent.CountDownLatch;

import br.com.labs.calculadora.NumeroPerfeito;

public class NumeroPerfeitoThread implements Runnable {
	
	private int _numero;
	private CountDownLatch _latch;
	
	public NumeroPerfeitoThread(CountDownLatch latch, int numero)
	{
		_numero = numero;
		_latch = latch;
	}
	
	@Override
	public void run() {
		
		NumeroPerfeito objNumeroPerfeito = new NumeroPerfeito();
		try {
			objNumeroPerfeito.VerificarSeNumeroEhPerfeito(_numero);
			
			_latch.countDown();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
