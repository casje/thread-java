package br.com.labs.calculadora;

import java.util.concurrent.TimeUnit;

public class Fatorial {
	
	public int Calcular(int numero) throws InterruptedException
	{
		int resultado = numero;
		int numeroFatorial = numero;
		
		while(numeroFatorial > 1)
		{
			TimeUnit.MILLISECONDS.sleep(500);

			resultado = resultado * (numeroFatorial - 1);
			numeroFatorial--;
		}
		
		System.out.println("Fatorial de " + numero + " é: " + resultado);
		
		return resultado;
	}

}
