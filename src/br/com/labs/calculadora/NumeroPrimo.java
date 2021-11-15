package br.com.labs.calculadora;

import java.util.concurrent.TimeUnit;

public class NumeroPrimo {
	
	public boolean VerificarSeNumeroEhPrimo(int numero) throws InterruptedException
	{
		boolean resultado = true;
		for(int x = 2; x < numero; x++)
		{
			TimeUnit.MILLISECONDS.sleep(300);

			if((numero % x) == 0)
			{
				resultado = false;
				break;
			}
		}
		
		System.out.println("Verificar se o número " + numero + " é primo: " + (resultado ? "sim" : "não"));
		
		return resultado;
	}

}
