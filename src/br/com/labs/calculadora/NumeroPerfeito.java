package br.com.labs.calculadora;

import java.util.concurrent.TimeUnit;

public class NumeroPerfeito {
	
	
	public boolean VerificarSeNumeroEhPerfeito(int numero) throws InterruptedException
	{
		int totalDivisores = 1;
		
		for(int x = 2; x < numero; x++)
		{
			TimeUnit.MILLISECONDS.sleep(500);
			
			if((numero % x) == 0)
				totalDivisores += x;			
		}
		
		boolean resultado = (numero == totalDivisores) ? true : false;
		
		System.out.println("Verificar se o número " + numero + " é perfeito: " + (resultado ? "sim" : "não"));
		
		return resultado;
	}

}
